package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SearchSubscriptionsQuery type.
 */
public class SearchSubscriptionsQuery {

    /**
     * Initialization constructor.
     * @param filter
     */
    @JsonCreator
    public SearchSubscriptionsQuery(
            @JsonProperty("filter") SearchSubscriptionsFilter filter) {
        this.filter = filter;
    }

    private final SearchSubscriptionsFilter filter;
    /**
     * Getter for Filter.
     * Represents a set of SearchSubscriptionsQuery filters used to limit the set of Subscriptions returned by SearchSubscriptions.
     */
    @JsonGetter("filter")
    public SearchSubscriptionsFilter getFilter() {
        return this.filter;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(filter);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SearchSubscriptionsQuery)) {
            return false;
        }
        SearchSubscriptionsQuery searchSubscriptionsQuery = (SearchSubscriptionsQuery) obj;
        return Objects.equals(filter, searchSubscriptionsQuery.filter);
    }

    /**
     * Builds a new {@link SearchSubscriptionsQuery.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SearchSubscriptionsQuery.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .filter(getFilter());
            return builder;
    }

    /**
     * Class to build instances of {@link SearchSubscriptionsQuery}
     */
    public static class Builder {
        private SearchSubscriptionsFilter filter;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for filter
         * @param filter
         * @return Builder
         */
        public Builder filter(SearchSubscriptionsFilter filter) {
            this.filter = filter;
            return this;
        }

        /**
         * Builds a new {@link SearchSubscriptionsQuery} object using the set fields.
         * @return {@link SearchSubscriptionsQuery}
         */
        public SearchSubscriptionsQuery build() {
            return new SearchSubscriptionsQuery(filter);
        }
    }
}
