package org.ubsfree.bookingapp.service

import org.springframework.stereotype.Service
import org.ubsfree.bookingapp.data.dto.booking.BookingDto
import org.ubsfree.bookingapp.data.dto.common.ServiceDto
import org.ubsfree.bookingapp.data.dto.common.SpecialistDto
import org.ubsfree.bookingapp.data.entity.BookingEntity
import org.ubsfree.bookingapp.data.entity.ServiceEntity
import org.ubsfree.bookingapp.data.entity.SpecialistEntity

/**
 * Created by lconnected on 18/02/2018.
 */
@Service
class EntityService {

    fun fromDto(dto: BookingDto): BookingEntity {
        val entity = BookingEntity()
        entity.id = dto.id
        entity.timeStart = dto.timeStart
        entity.serviceId = dto.serviceId
        entity.specialistId = dto.specialistId
        return entity
    }

    fun toDto(entity: BookingEntity) : BookingDto {
        val dto = BookingDto()
        dto.id = entity.id
        dto.timeStart = entity.timeStart
        dto.service = toDto(entity.service)
        dto.serviceId = entity.serviceId
        dto.specialistId = entity.specialistId
        return dto
    }

    fun fromDto(dto: ServiceDto) : ServiceEntity {
        val entity = ServiceEntity()
        entity.id = dto.id
        entity.name = dto.name
        entity.description = dto.description
        entity.cooldownMinutes = dto.cooldownMinutes
        entity.durationMinutes = dto.durationMinutes
        entity.conflictable = dto.conflictable
        return entity
    }

    fun toDto(entity: ServiceEntity) : ServiceDto {
        val dto = ServiceDto()
        dto.id = entity.id
        dto.name = entity.name
        dto.description = entity.description
        dto.cooldownMinutes = entity.cooldownMinutes
        dto.durationMinutes = entity.durationMinutes
        dto.conflictable = entity.conflictable
        return dto
    }

    fun fromDto(dto: SpecialistDto) : SpecialistEntity {
        val entity = SpecialistEntity();
        entity.id = dto.id
        entity.firstName = dto.firstName
        entity.secondName = dto.secondName
        entity.middleName = entity.middleName
        return entity
    }

    fun toDto(entity: SpecialistEntity) : SpecialistDto {
        val dto = SpecialistDto()
        dto.id = entity.id
        dto.firstName = entity.firstName
        dto.secondName = entity.secondName
        dto.middleName = entity.middleName
        return dto
    }

}