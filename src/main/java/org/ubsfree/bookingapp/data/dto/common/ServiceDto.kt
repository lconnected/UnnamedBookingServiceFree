package org.ubsfree.bookingapp.data.dto.common

/**
 * Created by lconnected on 19/02/2018.
 */
data class ServiceDto(var id: Long = -1,
                      var name: String = "",
                      var description: String? = null,
                      var durationMinutes: Int? = null,
                      var cooldownMinutes: Int? = null,
                      var conflictable: Boolean? = null) {
    // empty
}