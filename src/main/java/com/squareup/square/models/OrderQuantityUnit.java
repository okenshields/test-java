package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for OrderQuantityUnit type.
 */
public class OrderQuantityUnit {

    /**
     * Initialization constructor.
     * @param measurementUnit
     * @param precision
     */
    @JsonCreator
    public OrderQuantityUnit(
            @JsonProperty("measurement_unit") MeasurementUnit measurementUnit,
            @JsonProperty("precision") Integer precision) {
        this.measurementUnit = measurementUnit;
        this.precision = precision;
    }

    private final MeasurementUnit measurementUnit;
    private final Integer precision;
    /**
     * Getter for MeasurementUnit.
     * Represents a unit of measurement to use with a quantity, such as ounces
     * or inches. Exactly one of the following fields are required: `custom_unit`,
     * `area_unit`, `length_unit`, `volume_unit`, and `weight_unit`.
     */
    @JsonGetter("measurement_unit")
    public MeasurementUnit getMeasurementUnit() {
        return this.measurementUnit;
    }

    /**
     * Getter for Precision.
     * For non-integer quantities, represents the number of digits after the decimal point that are
     * recorded for this quantity.
     * For example, a precision of 1 allows quantities like `"1.0"` and `"1.1"`, but not `"1.01"`.
     * Min: 0. Max: 5.
     */
    @JsonGetter("precision")
    public Integer getPrecision() {
        return this.precision;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(measurementUnit, precision);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof OrderQuantityUnit)) {
            return false;
        }
        OrderQuantityUnit orderQuantityUnit = (OrderQuantityUnit) obj;
        return Objects.equals(measurementUnit, orderQuantityUnit.measurementUnit) &&
            Objects.equals(precision, orderQuantityUnit.precision);
    }

    /**
     * Builds a new {@link OrderQuantityUnit.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link OrderQuantityUnit.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .measurementUnit(getMeasurementUnit())
            .precision(getPrecision());
            return builder;
    }

    /**
     * Class to build instances of {@link OrderQuantityUnit}
     */
    public static class Builder {
        private MeasurementUnit measurementUnit;
        private Integer precision;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for measurementUnit
         * @param measurementUnit
         * @return Builder
         */
        public Builder measurementUnit(MeasurementUnit measurementUnit) {
            this.measurementUnit = measurementUnit;
            return this;
        }
        /**
         * Setter for precision
         * @param precision
         * @return Builder
         */
        public Builder precision(Integer precision) {
            this.precision = precision;
            return this;
        }

        /**
         * Builds a new {@link OrderQuantityUnit} object using the set fields.
         * @return {@link OrderQuantityUnit}
         */
        public OrderQuantityUnit build() {
            return new OrderQuantityUnit(measurementUnit,
                precision);
        }
    }
}
