package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CreateCustomerGroupRequest type.
 */
public class CreateCustomerGroupRequest {

    /**
     * Initialization constructor.
     * @param group
     * @param idempotencyKey
     */
    @JsonCreator
    public CreateCustomerGroupRequest(
            @JsonProperty("group") CustomerGroup group,
            @JsonProperty("idempotency_key") String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
        this.group = group;
    }

    private final String idempotencyKey;
    private final CustomerGroup group;
    /**
     * Getter for IdempotencyKey.
     * The idempotency key for the request. See the [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency)
     * guide for more information.
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for Group.
     * Represents a group of customer profiles. 
     * Customer groups can be created, modified, and have their membership defined either via 
     * the Customers API or within Customer Directory in the Square Dashboard or Point of Sale.
     */
    @JsonGetter("group")
    public CustomerGroup getGroup() {
        return this.group;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(idempotencyKey, group);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CreateCustomerGroupRequest)) {
            return false;
        }
        CreateCustomerGroupRequest createCustomerGroupRequest = (CreateCustomerGroupRequest) obj;
        return Objects.equals(idempotencyKey, createCustomerGroupRequest.idempotencyKey) &&
            Objects.equals(group, createCustomerGroupRequest.group);
    }

    /**
     * Builds a new {@link CreateCustomerGroupRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CreateCustomerGroupRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(group)
            .idempotencyKey(getIdempotencyKey());
            return builder;
    }

    /**
     * Class to build instances of {@link CreateCustomerGroupRequest}
     */
    public static class Builder {
        private CustomerGroup group;
        private String idempotencyKey;

        /**
         * Initialization constructor
         */
        public Builder(CustomerGroup group) {
            this.group = group;
        }

        /**
         * Setter for group
         * @param group
         * @return Builder
         */
        public Builder group(CustomerGroup group) {
            this.group = group;
            return this;
        }
        /**
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        /**
         * Builds a new {@link CreateCustomerGroupRequest} object using the set fields.
         * @return {@link CreateCustomerGroupRequest}
         */
        public CreateCustomerGroupRequest build() {
            return new CreateCustomerGroupRequest(group,
                idempotencyKey);
        }
    }
}
