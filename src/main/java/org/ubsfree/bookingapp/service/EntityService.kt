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

    /**
     * Coneverts `booking` from dto to entity class
     * @return @Entity object
     */
    fun fromDto(dto: BookingDto): BookingEntity {
        val entity = BookingEntity()
        entity.id = dto.id
        entity.timeStart = dto.timeStart
        entity.serviceId = dto.serviceId
        entity.specialistId = dto.specialistId
        return entity
    }

    /**
     * Coneverts `booking` from entity to dto class
     * @return data class object
     */
    fun fromEntity(entity: BookingEntity) : BookingDto {
        return BookingDto(
            id = entity.id,
            timeStart = entity.timeStart,
            service = fromEntity(entity.service),
            serviceId = entity.serviceId,
            specialistId = entity.specialistId,
            specialist = fromEntity(entity.specialist)
        )
    }

    /**
     * Coneverts `service` from dto to entity class
     * @return @Entity object
     */
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

    /**
     * Coneverts `service` from entity to dto class
     * @return data class object
     */
    fun fromEntity(entity: ServiceEntity?): ServiceDto? {
        entity ?: return null
        return ServiceDto(
                id = entity.id,
                name = entity.name,
                description = entity.description,
                cooldownMinutes = entity.cooldownMinutes,
                durationMinutes = entity.durationMinutes,
                conflictable = entity.conflictable
        )
    }

    /**
     * Coneverts `specialist` from dto to entity class
     * @return @Entity object
     */
    fun fromDto(dto: SpecialistDto) : SpecialistEntity {
        val entity = SpecialistEntity();
        entity.id = dto.id
        entity.firstName = dto.firstName
        entity.secondName = dto.secondName
        entity.middleName = entity.middleName
        return entity
    }

    /**
     * Coneverts `specialist` from entity to dto class
     * @return data class object
     */
    fun fromEntity(entity: SpecialistEntity?): SpecialistDto? {
        entity ?: return null
        return SpecialistDto(
                id = entity.id,
                firstName = entity.firstName,
                secondName = entity.secondName,
                middleName = entity.middleName
        )
    }

}