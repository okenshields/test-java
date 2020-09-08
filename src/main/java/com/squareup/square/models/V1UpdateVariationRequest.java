package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1UpdateVariationRequest type.
 */
public class V1UpdateVariationRequest {

    /**
     * Initialization constructor.
     * @param body
     */
    @JsonCreator
    public V1UpdateVariationRequest(
            @JsonProperty("body") V1Variation body) {
        this.body = body;
    }

    private final V1Variation body;
    /**
     * Getter for Body.
     * V1Variation
     */
    @JsonGetter("body")
    public V1Variation getBody() {
        return this.body;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(body);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof V1UpdateVariationRequest)) {
            return false;
        }
        V1UpdateVariationRequest v1UpdateVariationRequest = (V1UpdateVariationRequest) obj;
        return Objects.equals(body, v1UpdateVariationRequest.body);
    }

    /**
     * Builds a new {@link V1UpdateVariationRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1UpdateVariationRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(body);
            return builder;
    }

    /**
     * Class to build instances of {@link V1UpdateVariationRequest}
     */
    public static class Builder {
        private V1Variation body;

        /**
         * Initialization constructor
         */
        public Builder(V1Variation body) {
            this.body = body;
        }

        /**
         * Setter for body
         * @param body
         * @return Builder
         */
        public Builder body(V1Variation body) {
            this.body = body;
            return this;
        }

        /**
         * Builds a new {@link V1UpdateVariationRequest} object using the set fields.
         * @return {@link V1UpdateVariationRequest}
         */
        public V1UpdateVariationRequest build() {
            return new V1UpdateVariationRequest(body);
        }
    }
}
