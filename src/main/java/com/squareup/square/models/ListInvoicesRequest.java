package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for ListInvoicesRequest type.
 */
public class ListInvoicesRequest {

    /**
     * Initialization constructor.
     * @param locationId
     * @param cursor
     * @param limit
     */
    @JsonCreator
    public ListInvoicesRequest(
            @JsonProperty("location_id") String locationId,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("limit") Integer limit) {
        this.locationId = locationId;
        this.cursor = cursor;
        this.limit = limit;
    }

    private final String locationId;
    private final String cursor;
    private final Integer limit;
    /**
     * Getter for LocationId.
     * The ID of the location for which to list invoices.
     */
    @JsonGetter("location_id")
    public String getLocationId() {
        return this.locationId;
    }

    /**
     * Getter for Cursor.
     * A pagination cursor returned by a previous call to this endpoint. 
     * Provide this cursor to retrieve the next set of results for your original query.
     * For more information, see [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination).
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for Limit.
     * The maximum number of invoices to return (200 is the maximum `limit`). 
     * If not provided, the server 
     * uses a default limit of 100 invoices.
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(locationId, cursor, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListInvoicesRequest)) {
            return false;
        }
        ListInvoicesRequest listInvoicesRequest = (ListInvoicesRequest) obj;
        return Objects.equals(locationId, listInvoicesRequest.locationId) &&
            Objects.equals(cursor, listInvoicesRequest.cursor) &&
            Objects.equals(limit, listInvoicesRequest.limit);
    }

    /**
     * Builds a new {@link ListInvoicesRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListInvoicesRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(locationId)
            .cursor(getCursor())
            .limit(getLimit());
            return builder;
    }

    /**
     * Class to build instances of {@link ListInvoicesRequest}
     */
    public static class Builder {
        private String locationId;
        private String cursor;
        private Integer limit;

        /**
         * Initialization constructor
         */
        public Builder(String locationId) {
            this.locationId = locationId;
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
         * Setter for cursor
         * @param cursor
         * @return Builder
         */
        public Builder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }
        /**
         * Setter for limit
         * @param limit
         * @return Builder
         */
        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        /**
         * Builds a new {@link ListInvoicesRequest} object using the set fields.
         * @return {@link ListInvoicesRequest}
         */
        public ListInvoicesRequest build() {
            return new ListInvoicesRequest(locationId,
                cursor,
                limit);
        }
    }
}
