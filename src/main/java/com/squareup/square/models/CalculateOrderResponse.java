package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for CalculateOrderResponse type.
 */
public class CalculateOrderResponse {

    /**
     * Initialization constructor.
     * @param order
     * @param errors
     */
    @JsonCreator
    public CalculateOrderResponse(
            @JsonProperty("order") Order order,
            @JsonProperty("errors") List<Error> errors) {
        this.order = order;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final Order order;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Order.
     * Contains all information related to a single order to process with Square,
     * including line items that specify the products to purchase. Order objects also
     * include information on any associated tenders, refunds, and returns.
     * All Connect V2 Transactions have all been converted to Orders including all associated
     * itemization data.
     */
    @JsonGetter("order")
    public Order getOrder() {
        return this.order;
    }

    /**
     * Getter for Errors.
     * Any errors that occurred during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(order, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CalculateOrderResponse)) {
            return false;
        }
        CalculateOrderResponse calculateOrderResponse = (CalculateOrderResponse) obj;
        return Objects.equals(order, calculateOrderResponse.order) &&
            Objects.equals(errors, calculateOrderResponse.errors);
    }

    /**
     * Builds a new {@link CalculateOrderResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CalculateOrderResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .order(getOrder())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link CalculateOrderResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private Order order;
        private List<Error> errors;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for httpContext
         * @param httpContext
         * @return Builder
         */
        public Builder httpContext(HttpContext httpContext) {
            this.httpContext = httpContext;
            return this;
        }
        /**
         * Setter for order
         * @param order
         * @return Builder
         */
        public Builder order(Order order) {
            this.order = order;
            return this;
        }
        /**
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link CalculateOrderResponse} object using the set fields.
         * @return {@link CalculateOrderResponse}
         */
        public CalculateOrderResponse build() {
            CalculateOrderResponse model = new CalculateOrderResponse(order,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
