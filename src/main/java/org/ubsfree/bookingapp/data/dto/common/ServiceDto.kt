package org.ubsfree.bookingapp.data.dto.common

/**
 * Created by lconnected on 19/02/2018.
 */
data class ServiceDto(var id: Long? = null,
                      var name: String,
                      var description: String? = null,
                      var durationMinutes: Int,
                      var cooldownMinutes: Int,
                      var conflictable: Boolean)