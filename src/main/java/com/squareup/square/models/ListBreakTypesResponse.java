package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListBreakTypesResponse type.
 */
public class ListBreakTypesResponse {

    /**
     * Initialization constructor.
     * @param breakTypes
     * @param cursor
     * @param errors
     */
    @JsonCreator
    public ListBreakTypesResponse(
            @JsonProperty("break_types") List<BreakType> breakTypes,
            @JsonProperty("cursor") String cursor,
            @JsonProperty("errors") List<Error> errors) {
        this.breakTypes = breakTypes;
        this.cursor = cursor;
        this.errors = errors;
    }

    private HttpContext httpContext;
    private final List<BreakType> breakTypes;
    private final String cursor;
    private final List<Error> errors;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for BreakTypes.
     * A page of `BreakType` results.
     */
    @JsonGetter("break_types")
    public List<BreakType> getBreakTypes() {
        return this.breakTypes;
    }

    /**
     * Getter for Cursor.
     * Value supplied in the subsequent request to fetch the next next page
     * of Break Type results.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
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
        return Objects.hash(breakTypes, cursor, errors);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListBreakTypesResponse)) {
            return false;
        }
        ListBreakTypesResponse listBreakTypesResponse = (ListBreakTypesResponse) obj;
        return Objects.equals(breakTypes, listBreakTypesResponse.breakTypes) &&
            Objects.equals(cursor, listBreakTypesResponse.cursor) &&
            Objects.equals(errors, listBreakTypesResponse.errors);
    }

    /**
     * Builds a new {@link ListBreakTypesResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListBreakTypesResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .breakTypes(getBreakTypes())
            .cursor(getCursor())
            .errors(getErrors());
            return builder;
    }

    /**
     * Class to build instances of {@link ListBreakTypesResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<BreakType> breakTypes;
        private String cursor;
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
         * Setter for breakTypes
         * @param breakTypes
         * @return Builder
         */
        public Builder breakTypes(List<BreakType> breakTypes) {
            this.breakTypes = breakTypes;
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
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        /**
         * Builds a new {@link ListBreakTypesResponse} object using the set fields.
         * @return {@link ListBreakTypesResponse}
         */
        public ListBreakTypesResponse build() {
            ListBreakTypesResponse model = new ListBreakTypesResponse(breakTypes,
                cursor,
                errors);
            model.httpContext = httpContext;
            return model;
        }
    }
}
