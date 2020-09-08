package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for V1UpdatePageCellRequest type.
 */
public class V1UpdatePageCellRequest {

    /**
     * Initialization constructor.
     * @param body
     */
    @JsonCreator
    public V1UpdatePageCellRequest(
            @JsonProperty("body") V1PageCell body) {
        this.body = body;
    }

    private final V1PageCell body;
    /**
     * Getter for Body.
     * V1PageCell
     */
    @JsonGetter("body")
    public V1PageCell getBody() {
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
        if(!(obj instanceof V1UpdatePageCellRequest)) {
            return false;
        }
        V1UpdatePageCellRequest v1UpdatePageCellRequest = (V1UpdatePageCellRequest) obj;
        return Objects.equals(body, v1UpdatePageCellRequest.body);
    }

    /**
     * Builds a new {@link V1UpdatePageCellRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link V1UpdatePageCellRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(body);
            return builder;
    }

    /**
     * Class to build instances of {@link V1UpdatePageCellRequest}
     */
    public static class Builder {
        private V1PageCell body;

        /**
         * Initialization constructor
         */
        public Builder(V1PageCell body) {
            this.body = body;
        }

        /**
         * Setter for body
         * @param body
         * @return Builder
         */
        public Builder body(V1PageCell body) {
            this.body = body;
            return this;
        }

        /**
         * Builds a new {@link V1UpdatePageCellRequest} object using the set fields.
         * @return {@link V1UpdatePageCellRequest}
         */
        public V1UpdatePageCellRequest build() {
            return new V1UpdatePageCellRequest(body);
        }
    }
}
