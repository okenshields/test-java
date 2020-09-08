package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchCatalogObjectsRequest type.
 */
public class SearchCatalogObjectsRequest {

    /**
     * Initialization constructor.
     * @param cursor
     * @param objectTypes
     * @param includeDeletedObjects
     * @param includeRelatedObjects
     * @param beginTime
     * @param query
     * @param limit
     */
    @JsonCreator
    public SearchCatalogObjectsRequest(
            @JsonProperty("cursor") String cursor,
            @JsonProperty("object_types") List<String> objectTypes,
            @JsonProperty("include_deleted_objects") Boolean includeDeletedObjects,
            @JsonProperty("include_related_objects") Boolean includeRelatedObjects,
            @JsonProperty("begin_time") String beginTime,
            @JsonProperty("query") CatalogQuery query,
            @JsonProperty("limit") Integer limit) {
        this.cursor = cursor;
        this.objectTypes = objectTypes;
        this.includeDeletedObjects = includeDeletedObjects;
        this.includeRelatedObjects = includeRelatedObjects;
        this.beginTime = beginTime;
        this.query = query;
        this.limit = limit;
    }

    private final String cursor;
    private final List<String> objectTypes;
    private final Boolean includeDeletedObjects;
    private final Boolean includeRelatedObjects;
    private final String beginTime;
    private final CatalogQuery query;
    private final Integer limit;
    /**
     * Getter for Cursor.
     * The pagination cursor returned in the previous response. Leave unset for an initial request.
     * See [Pagination](https://developer.squareup.com/docs/basics/api101/pagination) for more information.
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

    /**
     * Getter for ObjectTypes.
     * The desired set of object types to appear in the search results.
     * The legal values are taken from the CatalogObjectType enum: `"ITEM"`, `"ITEM_VARIATION"`, `"CATEGORY"`,
     * `"DISCOUNT"`, `"TAX"`, `"MODIFIER"`, or `"MODIFIER_LIST"`.
     * See [CatalogObjectType](#type-catalogobjecttype) for possible values
     */
    @JsonGetter("object_types")
    public List<String> getObjectTypes() {
        return this.objectTypes;
    }

    /**
     * Getter for IncludeDeletedObjects.
     * If `true`, deleted objects will be included in the results. Deleted objects will have their
     * `is_deleted` field set to `true`.
     */
    @JsonGetter("include_deleted_objects")
    public Boolean getIncludeDeletedObjects() {
        return this.includeDeletedObjects;
    }

    /**
     * Getter for IncludeRelatedObjects.
     * If `true`, the response will include additional objects that are related to the
     * requested object, as follows:
     * If a CatalogItem is returned in the object field of the response,
     * its associated CatalogCategory, CatalogTax objects,
     * CatalogImage objects and CatalogModifierList objects
     * will be included in the `related_objects` field of the response.
     * If a CatalogItemVariation is returned in the object field of the
     * response, its parent CatalogItem will be included in the `related_objects` field of
     * the response.
     */
    @JsonGetter("include_related_objects")
    public Boolean getIncludeRelatedObjects() {
        return this.includeRelatedObjects;
    }

    /**
     * Getter for BeginTime.
     * Return objects modified after this [timestamp](https://developer.squareup.com/docs/build-basics/working-with-dates), in RFC 3339
     * format, e.g., `2016-09-04T23:59:33.123Z`. The timestamp is exclusive - objects with a
     * timestamp equal to `begin_time` will not be included in the response.
     */
    @JsonGetter("begin_time")
    public String getBeginTime() {
        return this.beginTime;
    }

    /**
     * Getter for Query.
     * A query composed of one or more different types of filters to narrow the scope of targeted objects when calling the `SearchCatalogObjects` endpoint.
     * Although a query can have multiple filters, only one query is allowed per call to [SearchCatalogObjects](#endpoint-Catalog-SearchCatalogObjects).
     * When a query filter is based on an attribute, the attribute must be searchable. 
     * Searchable attributes are listed as follows, along their parent types that can be searched for with applicable query filters. 
     * Searchable attribute and objects queryable by searchable attributes ** 
     * - `name`:  `CatalogItem`, `CatalogItemVariation`, `CatelogCatogry`, `CatalogTax`, `CatalogDiscount`, `CatalogModifier`, 'CatalogModifierList`, `CatalogItemOption`, `CatalogItemOptionValue` 
     * - `description`: `CatalogItem`, `CatalogItemOptionValue` 
     * - `abbreviation`: `CatalogItem` 
     * - `upc`: `CatalogItemVariation` 
     * - `sku`: `CatalogItemVariation` 
     * - `caption`: `CatalogImage` 
     * - `display_name`: `CatalogItemOption` 
     * For example, to search for [CatalogItem](#type-CatalogItem) objects by searchable attributes, you can use 
     * the `"name"`, `"description"`, or `"abbreviation"` attribute in an applicable query filter.
     */
    @JsonGetter("query")
    public CatalogQuery getQuery() {
        return this.query;
    }

    /**
     * Getter for Limit.
     * A limit on the number of results to be returned in a single page. The limit is advisory -
     * the implementation may return more or fewer results. If the supplied limit is negative, zero, or
     * is higher than the maximum limit of 1,000, it will be ignored.
     */
    @JsonGetter("limit")
    public Integer getLimit() {
        return this.limit;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(cursor, objectTypes, includeDeletedObjects, includeRelatedObjects,
            beginTime, query, limit);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchCatalogObjectsRequest)) {
            return false;
        }
        SearchCatalogObjectsRequest searchCatalogObjectsRequest = (SearchCatalogObjectsRequest) obj;
        return Objects.equals(cursor, searchCatalogObjectsRequest.cursor) &&
            Objects.equals(objectTypes, searchCatalogObjectsRequest.objectTypes) &&
            Objects.equals(includeDeletedObjects, searchCatalogObjectsRequest.includeDeletedObjects) &&
            Objects.equals(includeRelatedObjects, searchCatalogObjectsRequest.includeRelatedObjects) &&
            Objects.equals(beginTime, searchCatalogObjectsRequest.beginTime) &&
            Objects.equals(query, searchCatalogObjectsRequest.query) &&
            Objects.equals(limit, searchCatalogObjectsRequest.limit);
    }

    /**
     * Builds a new {@link SearchCatalogObjectsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchCatalogObjectsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .cursor(getCursor())
            .objectTypes(getObjectTypes())
            .includeDeletedObjects(getIncludeDeletedObjects())
            .includeRelatedObjects(getIncludeRelatedObjects())
            .beginTime(getBeginTime())
            .query(getQuery())
            .limit(getLimit());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchCatalogObjectsRequest}
     */
    public static class Builder {
        private String cursor;
        private List<String> objectTypes;
        private Boolean includeDeletedObjects;
        private Boolean includeRelatedObjects;
        private String beginTime;
        private CatalogQuery query;
        private Integer limit;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Setter for objectTypes
         * @param objectTypes
         * @return Builder
         */
        public Builder objectTypes(List<String> objectTypes) {
            this.objectTypes = objectTypes;
            return this;
        }
        /**
         * Setter for includeDeletedObjects
         * @param includeDeletedObjects
         * @return Builder
         */
        public Builder includeDeletedObjects(Boolean includeDeletedObjects) {
            this.includeDeletedObjects = includeDeletedObjects;
            return this;
        }
        /**
         * Setter for includeRelatedObjects
         * @param includeRelatedObjects
         * @return Builder
         */
        public Builder includeRelatedObjects(Boolean includeRelatedObjects) {
            this.includeRelatedObjects = includeRelatedObjects;
            return this;
        }
        /**
         * Setter for beginTime
         * @param beginTime
         * @return Builder
         */
        public Builder beginTime(String beginTime) {
            this.beginTime = beginTime;
            return this;
        }
        /**
         * Setter for query
         * @param query
         * @return Builder
         */
        public Builder query(CatalogQuery query) {
            this.query = query;
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
         * Builds a new {@link SearchCatalogObjectsRequest} object using the set fields.
         * @return {@link SearchCatalogObjectsRequest}
         */
        public SearchCatalogObjectsRequest build() {
            return new SearchCatalogObjectsRequest(cursor,
                objectTypes,
                includeDeletedObjects,
                includeRelatedObjects,
                beginTime,
                query,
                limit);
        }
    }
}
