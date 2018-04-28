package org.ubsfree.bookingapp.service

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.ubsfree.bookingapp.BookingAppStarterTest
import org.ubsfree.bookingapp.data.entity.BookingEntity
import org.ubsfree.bookingapp.exception.booking.BookingDateInPastException
import java.util.*
import javax.transaction.Transactional

/**
 * Created by lconnected on 09/02/2018.
 */
@Transactional
class BookingServiceTest : BookingAppStarterTest() {

    @Autowired
    lateinit var bookingService: BookingService

    @Test
    fun serviceInitialized() {
        assertNotNull("BookingService instance has not been created", bookingService)
    }

    @Test
    fun addBooking() {
        val initialCount = bookingService.repository.count()
        assertTrue("initialCount should be initialized", initialCount == 0L)

        val bookingEntity = BookingEntity()
        bookingEntity.serviceId = 200
        bookingEntity.specialistId = 300
        bookingEntity.userId = 1
        val timeStart = Date(Date().time + 10000)
        bookingEntity.timeStart = timeStart

        // the main call
        bookingService.addBooking(bookingEntity)
        assertTrue("Table `booking` must contain 1 record", bookingService.repository.count() > initialCount)
    }

    @Test(expected = BookingDateInPastException::class)
    fun addBookingInPast() {
        val bookingEntity = BookingEntity()
        bookingEntity.serviceId = 200
        bookingEntity.specialistId = 300
        bookingEntity.userId = 1
        val timeStart = Date(Date().time - 10000)
        bookingEntity.timeStart = timeStart

        // the main call
        bookingService.addBooking(bookingEntity)
    }

}