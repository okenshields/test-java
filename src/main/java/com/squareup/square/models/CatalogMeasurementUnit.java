package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogMeasurementUnit type.
 */
public class CatalogMeasurementUnit {

    /**
     * Initialization constructor.
     * @param measurementUnit
     * @param precision
     */
    @JsonCreator
    public CatalogMeasurementUnit(
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
     * An integer between 0 and 5 that represents the maximum number of
     * positions allowed after the decimal in quantities measured with this unit.
     * For example:
     * - if the precision is 0, the quantity can be 1, 2, 3, etc.
     * - if the precision is 1, the quantity can be 0.1, 0.2, etc.
     * - if the precision is 2, the quantity can be 0.01, 0.12, etc.
     * Default: 3
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
        if(!(obj instanceof CatalogMeasurementUnit)) {
            return false;
        }
        CatalogMeasurementUnit catalogMeasurementUnit = (CatalogMeasurementUnit) obj;
        return Objects.equals(measurementUnit, catalogMeasurementUnit.measurementUnit) &&
            Objects.equals(precision, catalogMeasurementUnit.precision);
    }

    /**
     * Builds a new {@link CatalogMeasurementUnit.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogMeasurementUnit.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .measurementUnit(getMeasurementUnit())
            .precision(getPrecision());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogMeasurementUnit}
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
         * Builds a new {@link CatalogMeasurementUnit} object using the set fields.
         * @return {@link CatalogMeasurementUnit}
         */
        public CatalogMeasurementUnit build() {
            return new CatalogMeasurementUnit(measurementUnit,
                precision);
        }
    }
}
