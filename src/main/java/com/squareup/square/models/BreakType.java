package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for BreakType type.
 */
public class BreakType {

    /**
     * Initialization constructor.
     * @param locationId
     * @param breakName
     * @param expectedDuration
     * @param isPaid
     * @param id
     * @param version
     * @param createdAt
     * @param updatedAt
     */
    @JsonCreator
    public BreakType(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("break_name") String breakName,
            @JsonProperty("expected_duration") String expectedDuration,
            @JsonProperty("is_paid") boolean isPaid,
            @JsonProperty("id") String id,
            @JsonProperty("version") Integer version,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("updated_at") String updatedAt) {
        this.id = id;
        this.locationId = locationId;
        this.breakName = breakName;
        this.expectedDuration = expectedDuration;
        this.isPaid = isPaid;
        this.version = version;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private final String id;
    private final String locationId;
    private final String breakName;
    private final String expectedDuration;
    private final boolean isPaid;
    private final Integer version;
    private final String createdAt;
    private final String updatedAt;
    /**
     * Getter for Id.
     * UUID for this object.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for LocationId.
     * The ID of the business location this type of break applies to.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for BreakName.
     * A human-readable name for this type of break. Will be displayed to
     * employees in Square products.
     */
    @JsonGetter("break_name")
    public String getBreakName() {
        return this.breakName;
    }

    /**
     * Getter for ExpectedDuration.
     * Format: RFC-3339 P[n]Y[n]M[n]DT[n]H[n]M[n]S. The expected length of
     * this break. Precision below minutes is truncated.
     */
    @JsonGetter("expected_duration")
    public String getExpectedDuration() {
        return this.expectedDuration;
    }

    /**
     * Getter for IsPaid.
     * Whether this break counts towards time worked for compensation
     * purposes.
     */
    @JsonGetter("is_paid")
    public boolean getIsPaid() {
        return this.isPaid;
    }

    /**
     * Getter for Version.
     * Used for resolving concurrency issues; request will fail if version
     * provided does not match server version at time of request. If a value is not
     * provided, Square's servers execute a "blind" write; potentially
     * overwriting another writer's data.
     */
    @JsonGetter("version")
    public Integer getVersion() {
        return this.version;
    }

    /**
     * Getter for CreatedAt.
     * A read-only timestamp in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for UpdatedAt.
     * A read-only timestamp in RFC 3339 format.
     */
    @JsonGetter("updated_at")
    public String getUpdatedAt() {
        return this.updatedAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, locationId, breakName, expectedDuration, isPaid, version, createdAt,
            updatedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof BreakType)) {
            return false;
        }
        BreakType breakType = (BreakType) obj;
        return Objects.equals(id, breakType.id) &&
            Objects.equals(locationId, breakType.locationId) &&
            Objects.equals(breakName, breakType.breakName) &&
            Objects.equals(expectedDuration, breakType.expectedDuration) &&
            Objects.equals(isPaid, breakType.isPaid) &&
            Objects.equals(version, breakType.version) &&
            Objects.equals(createdAt, breakType.createdAt) &&
            Objects.equals(updatedAt, breakType.updatedAt);
    }

    /**
     * Builds a new {@link BreakType.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link BreakType.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationId,
            breakName,
            expectedDuration,
            isPaid)
            .id(getId())
            .version(getVersion())
            .createdAt(getCreatedAt())
            .updatedAt(getUpdatedAt());
            return builder;
    }

    /**
     * Class to build instances of {@link BreakType}
     */
    public static class Builder {
        private String locationId;
        private String breakName;
        private String expectedDuration;
        private boolean isPaid;
        private String id;
        private Integer version;
        private String createdAt;
        private String updatedAt;

        /**
         * Initialization constructor
         */
        public Builder(String locationId,
                String breakName,
                String expectedDuration,
                boolean isPaid) {
            this.locationId = locationId;
            this.breakName = breakName;
            this.expectedDuration = expectedDuration;
            this.isPaid = isPaid;
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
         * Setter for breakName
         * @param breakName
         * @return Builder
         */
        public Builder breakName(String breakName) {
            this.breakName = breakName;
            return this;
        }
        /**
         * Setter for expectedDuration
         * @param expectedDuration
         * @return Builder
         */
        public Builder expectedDuration(String expectedDuration) {
            this.expectedDuration = expectedDuration;
            return this;
        }
        /**
         * Setter for isPaid
         * @param isPaid
         * @return Builder
         */
        public Builder isPaid(boolean isPaid) {
            this.isPaid = isPaid;
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
         * Builds a new {@link BreakType} object using the set fields.
         * @return {@link BreakType}
         */
        public BreakType build() {
            return new BreakType(locationId,
                breakName,
                expectedDuration,
                isPaid,
                id,
                version,
                createdAt,
                updatedAt);
        }
    }
}
