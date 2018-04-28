package org.ubsfree.bookingapp.service

import org.junit.Test

import org.junit.Assert.*
import org.ubsfree.bookingapp.data.dto.booking.BookingDto
import org.ubsfree.bookingapp.data.dto.common.ServiceDto
import org.ubsfree.bookingapp.data.dto.common.SpecialistDto
import java.util.*

/**
 * Created by lconnected on 27/04/2018.
 */
class EntityServiceTest {

    val entityService = EntityService()

    @Test
    fun bookingTest() {
        val sourceDto = BookingDto(id = 1, timeStart = Date(), serviceId = 200, specialistId = 300)
        val convertedDto = entityService.fromDto(sourceDto)
        assertNotNull("Have to be initialized", convertedDto)
        assertEquals("ID equal to 1", 1, convertedDto.id)
        assertEquals("serviceId equal to 1", 200, convertedDto.serviceId)
        assertEquals("specialistId equal to 1", 300, convertedDto.specialistId)
        assertEquals("reverse conversion must be the same as initial dto", sourceDto, entityService.fromEntity(convertedDto))
    }

    @Test
    fun serviceTest() {
        val sourceDto = ServiceDto(
                id = 1,
                name = "Test Service",
                durationMinutes = 10,
                cooldownMinutes = 50,
                conflictable = false
        )
        val convertedDto = entityService.fromDto(sourceDto)
        assertNotNull("Have to be initialized", convertedDto)
        assertEquals("ID equal to 1", 1, convertedDto.id)
        assertEquals("""name equal to "Test Service" """, "Test Service", convertedDto.name)
        assertEquals("durationMinutes equal to 10", 10, convertedDto.durationMinutes)
        assertEquals("cooldownMinutes equal to 50", 50, convertedDto.cooldownMinutes)
        assertFalse("conflictable is false", convertedDto.conflictable)
        assertEquals("reverse conversion must be the same as initial dto", sourceDto, entityService.fromEntity(convertedDto))
    }

    @Test
    fun specialistTest() {
        val sourceDto = SpecialistDto(
                id = 1,
                firstName = "Testname",
                secondName = "Testsurname"
        )
        val convertedDto = entityService.fromDto(sourceDto)
        assertNotNull("Have to be initialized", convertedDto)
        assertEquals("ID equal to 1", 1, convertedDto.id)
        assertEquals("""name equal to "Testname" """, "Testname", convertedDto.firstName)
        assertEquals("""name equal to "Testsurname" """, "Testsurname", convertedDto.secondName)
        assertEquals("reverse conversion must be the same as initial dto", sourceDto, entityService.fromEntity(convertedDto))
    }

}