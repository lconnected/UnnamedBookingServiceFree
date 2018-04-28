package org.ubsfree.bookingapp.data.dto.booking

import org.ubsfree.bookingapp.data.dto.common.ServiceDto
import org.ubsfree.bookingapp.data.dto.common.SpecialistDto

import java.util.Date

/**
 * Created by lconnected on 30/01/2018.
 */
data class BookingDto (
    var id: Long?,
    var timeStart: Date,
    var serviceId: Long,
    var service: ServiceDto? = null,
    var specialistId: Long,
    var specialist: SpecialistDto? = null
)
