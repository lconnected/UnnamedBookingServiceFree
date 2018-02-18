package org.ubsfree.bookingapp.data.dto.common;

/**
 * Created by lconnected on 30/01/2018.
 */
public class ServiceDto {

    private Long id;
    private String name;
    private String description;
    private Integer durationMinutes;
    private Integer cooldownMinutes;
    private Boolean conflictable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Integer getCooldownMinutes() {
        return cooldownMinutes;
    }

    public void setCooldownMinutes(Integer cooldownMinutes) {
        this.cooldownMinutes = cooldownMinutes;
    }

    public Boolean getConflictable() {
        return conflictable;
    }

    public void setConflictable(Boolean conflictable) {
        this.conflictable = conflictable;
    }
}
