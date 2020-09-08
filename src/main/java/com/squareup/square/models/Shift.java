package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for Shift type.
 */
public class Shift {

    /**
     * Initialization constructor.
     * @param startAt
     * @param id
     * @param employeeId
     * @param locationId
     * @param timezone
     * @param endAt
     * @param wage
     * @param breaks
     * @param status
     * @param version
     * @param createdAt
     * @param updatedAt
     * @param teamMemberId
     */
    @JsonCreator
    public Shift(
            @JsonProperty("start_at") String startAt,
            @JsonProperty("id") String id,
            @JsonProperty("employee_id") String employeeId,
            @JsonProperty("location_id") String locationId,
            @JsonProperty("timezone") String timezone,
            @JsonProperty("end_at") String endAt,
            @JsonProperty("wage") ShiftWage wage,
            @JsonProperty("breaks") List<Break> breaks,
            @JsonProperty("status") String status,
            @JsonProperty("version") Integer version,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("team_member_id") String teamMemberId) {
        this.id = id;
        this.employeeId = employeeId;
        this.locationId = locationId;
        this.timezone = timezone;
        this.startAt = startAt;
        this.endAt = endAt;
        this.wage = wage;
        this.breaks = breaks;
        this.status = status;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.teamMemberId = teamMemberId;
    }

    private final String id;
    private final String employeeId;
    private final String locationId;
    private final String timezone;
    private final String startAt;
    private final String endAt;
    private final ShiftWage wage;
    private final List<Break> breaks;
    private final String status;
    private final Integer version;
    private final String createdAt;
    private final String updatedAt;
    private final String teamMemberId;
    /**
     * Getter for Id.
     * UUID for this object
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for EmployeeId.
     * The ID of the employee this shift belongs to. DEPRECATED at version 2020-08-26. Use `team_member_id` instead
     */
    @JsonGetter("employee_id")
    public String getEmployeeId() {
        return this.employeeId;
    }

    /**
     * Getter for LocationId.
     * The ID of the location this shift occurred at. Should be based on
     * where the employee clocked in.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for Timezone.
     * Read-only convenience value that is calculated from the location based
     * on `location_id`. Format: the IANA Timezone Database identifier for the
     * location timezone.
     */
    @JsonGetter("timezone")
    public String getTimezone() {
        return this.timezone;
    }

    /**
     * Getter for StartAt.
     * RFC 3339; shifted to location timezone + offset. Precision up to the
     * minute is respected; seconds are truncated.
     */
    @JsonGetter("start_at")
    public String getStartAt() {
        return this.startAt;
    }

    /**
     * Getter for EndAt.
     * RFC 3339; shifted to timezone + offset. Precision up to the minute is
     * respected; seconds are truncated.
     */
    @JsonGetter("end_at")
    public String getEndAt() {
        return this.endAt;
    }

    /**
     * Getter for Wage.
     * The hourly wage rate used to compensate an employee for this shift.
     */
    @JsonGetter("wage")
    public ShiftWage getWage() {
        return this.wage;
    }

    /**
     * Getter for Breaks.
     * A list of any paid or unpaid breaks that were taken during this shift.
     */
    @JsonGetter("breaks")
    public List<Break> getBreaks() {
        return this.breaks;
    }

    /**
     * Getter for Status.
     * Enumerates the possible status of a `Shift`
     */
    @JsonGetter("status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Getter for Version.
     * Used for resolving concurrency issues; request will fail if version
     * provided does not match server version at time of request. If not provided,
     * Square executes a blind write; potentially overwriting data from another
     * write.
     */
    @JsonGetter("version")
    public Integer getVersion() {
        return this.version;
    }

    /**
     * Getter for CreatedAt.
     * A read-only timestamp in RFC 3339 format; presented in UTC.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * A read-only timestamp in RFC 3339 format; presented in UTC.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Getter for TeamMemberId.
     * The ID of the team member this shift belongs to. Replaced `employee_id` at version "2020-08-26"
     */
    @JsonGetter("team_member_id")
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, locationId, timezone, startAt, endAt, wage, breaks,
            status, version, createdAt, updatedAt, teamMemberId);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Shift)) {
            return false;
        }
        Shift shift = (Shift) obj;
        return Objects.equals(id, shift.id) &&
            Objects.equals(employeeId, shift.employeeId) &&
            Objects.equals(locationId, shift.locationId) &&
            Objects.equals(timezone, shift.timezone) &&
            Objects.equals(startAt, shift.startAt) &&
            Objects.equals(endAt, shift.endAt) &&
            Objects.equals(wage, shift.wage) &&
            Objects.equals(breaks, shift.breaks) &&
            Objects.equals(status, shift.status) &&
            Objects.equals(version, shift.version) &&
            Objects.equals(createdAt, shift.createdAt) &&
            Objects.equals(updatedAt, shift.updatedAt) &&
            Objects.equals(teamMemberId, shift.teamMemberId);
    }

    /**
     * Builds a new {@link Shift.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Shift.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(startAt)
            .id(getId())
            .employeeId(getEmployeeId())
            .locationId(getLocationId())
            .timezone(getTimezone())
            .endAt(getEndAt())
            .wage(getWage())
            .breaks(getBreaks())
            .status(getStatus())
            .version(getVersion())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt())
            .teamMemberId(getTeamMemberId());
            return builder;
    }

    /**
     * Class to build instances of {@link Shift}
     */
    public static class Builder {
        private String startAt;
        private String id;
        private String employeeId;
        private String locationId;
        private String timezone;
        private String endAt;
        private ShiftWage wage;
        private List<Break> breaks;
        private String status;
        private Integer version;
        private String createdAt;
        private String updatedAt;
        private String teamMemberId;

        /**
         * Initialization constructor
         */
        public Builder(String startAt) {
            this.startAt = startAt;
        }

        /**
         * Setter for startAt
         * @param startAt
         * @return Builder
         */
        public Builder startAt(String startAt) {
            this.startAt = startAt;
            return this;
        }
        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for employeeId
         * @param employeeId
         * @return Builder
         */
        public Builder employeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        /**
         * Setter for locationId
         * @param locationId
         * @return Builder
         */
        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }
        /**
         * Setter for timezone
         * @param timezone
         * @return Builder
         */
        public Builder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }
        /**
         * Setter for endAt
         * @param endAt
         * @return Builder
         */
        public Builder endAt(String endAt) {
            this.endAt = endAt;
            return this;
        }
        /**
         * Setter for wage
         * @param wage
         * @return Builder
         */
        public Builder wage(ShiftWage wage) {
            this.wage = wage;
            return this;
        }
        /**
         * Setter for breaks
         * @param breaks
         * @return Builder
         */
        public Builder breaks(List<Break> breaks) {
            this.breaks = breaks;
            return this;
        }
        /**
         * Setter for status
         * @param status
         * @return Builder
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }
        /**
         * Setter for version
         * @param version
         * @return Builder
         */
        public Builder version(Integer version) {
            this.version = version;
            return this;
        }
        /**
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        /**
         * Setter for updatedAt
         * @param updatedAt
         * @return Builder
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        /**
         * Setter for teamMemberId
         * @param teamMemberId
         * @return Builder
         */
        public Builder teamMemberId(String teamMemberId) {
            this.teamMemberId = teamMemberId;
            return this;
        }

        /**
         * Builds a new {@link Shift} object using the set fields.
         * @return {@link Shift}
         */
        public Shift build() {
            return new Shift(startAt,
                id,
                employeeId,
                locationId,
                timezone,
                endAt,
                wage,
                breaks,
                status,
                version,
                createdAt,
                updatedAt,
                teamMemberId);
        }
    }
}
