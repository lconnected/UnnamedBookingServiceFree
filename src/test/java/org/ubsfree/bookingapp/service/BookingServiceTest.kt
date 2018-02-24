package org.ubsfree.bookingapp.service

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.ubsfree.bookingapp.data.entity.BookingEntity

import javax.transaction.Transactional

import java.util.Date

import org.junit.Assert.*

/**
 * Created by lconnected on 09/02/2018.
 */
@RunWith(SpringRunner::class)
@SpringBootTest
@Transactional
open class BookingServiceTest {

    @Autowired
    private val bookingService: BookingService? = null

    @Test
    fun serviceInitialized() {
        assertNotNull("BookingService instance has not been created", bookingService)
    }

    @Test
    @Throws(Exception::class)
    fun addBooking() {
        val initialCount = bookingService!!.repository.count();

        val bookingEntity = BookingEntity()
        bookingEntity.serviceId = 1L
        bookingEntity.specialistId = 1L
        bookingEntity.userId = 1L
        val timeStart = Date(Date().time + 10000)
        bookingEntity.timeStart = timeStart

        // the main call
        bookingService.addBooking(bookingEntity)
        assertTrue("Table `booking` must contain 1 record", bookingService.repository.count() > initialCount)
    }

}