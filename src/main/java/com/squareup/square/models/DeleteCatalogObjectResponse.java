package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for DeleteCatalogObjectResponse type.
 */
public class DeleteCatalogObjectResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param deletedObjectIds
     * @param deletedAt
     */
    @JsonCreator
    public DeleteCatalogObjectResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("deleted_object_ids") List<String> deletedObjectIds,
            @JsonProperty("deleted_at") String deletedAt) {
        this.errors = errors;
        this.deletedObjectIds = deletedObjectIds;
        this.deletedAt = deletedAt;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<String> deletedObjectIds;
    private final String deletedAt;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on any errors encountered.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for DeletedObjectIds.
     * The IDs of all catalog objects deleted by this request.
     * Multiple IDs may be returned when associated objects are also deleted, for example
     * a catalog item variation will be deleted (and its ID included in this field)
     * when its parent catalog item is deleted.
     */
    @JsonGetter("deleted_object_ids")
    public List<String> getDeletedObjectIds() {
        return this.deletedObjectIds;
    }

    /**
     * Getter for DeletedAt.
     * The database [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates)
     * of this deletion in RFC 3339 format, e.g., `2016-09-04T23:59:33.123Z`.
     */
    @JsonGetter("deleted_at")
    public String getDeletedAt() {
        return this.deletedAt;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, deletedObjectIds, deletedAt);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof DeleteCatalogObjectResponse)) {
            return false;
        }
        DeleteCatalogObjectResponse deleteCatalogObjectResponse = (DeleteCatalogObjectResponse) obj;
        return Objects.equals(errors, deleteCatalogObjectResponse.errors) &&
            Objects.equals(deletedObjectIds, deleteCatalogObjectResponse.deletedObjectIds) &&
            Objects.equals(deletedAt, deleteCatalogObjectResponse.deletedAt);
    }

    /**
     * Builds a new {@link DeleteCatalogObjectResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link DeleteCatalogObjectResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .deletedObjectIds(getDeletedObjectIds())
            .deletedAt(getDeletedAt());
            return builder;
    }

    /**
     * Class to build instances of {@link DeleteCatalogObjectResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<String> deletedObjectIds;
        private String deletedAt;

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
         * Setter for errors
         * @param errors
         * @return Builder
         */
        public Builder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }
        /**
         * Setter for deletedObjectIds
         * @param deletedObjectIds
         * @return Builder
         */
        public Builder deletedObjectIds(List<String> deletedObjectIds) {
            this.deletedObjectIds = deletedObjectIds;
            return this;
        }
        /**
         * Setter for deletedAt
         * @param deletedAt
         * @return Builder
         */
        public Builder deletedAt(String deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        /**
         * Builds a new {@link DeleteCatalogObjectResponse} object using the set fields.
         * @return {@link DeleteCatalogObjectResponse}
         */
        public DeleteCatalogObjectResponse build() {
            DeleteCatalogObjectResponse model = new DeleteCatalogObjectResponse(errors,
                deletedObjectIds,
                deletedAt);
            model.httpContext = httpContext;
            return model;
        }
    }
}
