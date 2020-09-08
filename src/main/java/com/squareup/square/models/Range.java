package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for Range type.
 */
public class Range {

    /**
     * Initialization constructor.
     * @param min
     * @param max
     */
    @JsonCreator
    public Range(
            @JsonProperty("min") String min,
            @JsonProperty("max") String max) {
        this.min = min;
        this.max = max;
    }

    private final String min;
    private final String max;
    /**
     * Getter for Min.
     * The lower bound of the number range.
     */
    @JsonGetter("min")
    public String getMin() {
        return this.min;
    }

    /**
     * Getter for Max.
     * The upper bound of the number range.
     */
    @JsonGetter("max")
    public String getMax() {
        return this.max;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return Objects.equals(min, range.min) &&
            Objects.equals(max, range.max);
    }

    /**
     * Builds a new {@link Range.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Range.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .min(getMin())
            .max(getMax());
            return builder;
    }

    /**
     * Class to build instances of {@link Range}
     */
    public static class Builder {
        private String min;
        private String max;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for min
         * @param min
         * @return Builder
         */
        public Builder min(String min) {
            this.min = min;
            return this;
        }
        /**
         * Setter for max
         * @param max
         * @return Builder
         */
        public Builder max(String max) {
            this.max = max;
            return this;
        }

        /**
         * Builds a new {@link Range} object using the set fields.
         * @return {@link Range}
         */
        public Range build() {
            return new Range(min,
                max);
        }
    }
}
