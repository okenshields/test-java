package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogQueryText type.
 */
public class CatalogQueryText {

    /**
     * Initialization constructor.
     * @param keywords
     */
    @JsonCreator
    public CatalogQueryText(
            @JsonProperty("keywords") List<String> keywords) {
        this.keywords = keywords;
    }

    private final List<String> keywords;
    /**
     * Getter for Keywords.
     * A list of 1, 2, or 3 search keywords. Keywords with fewer than 3 characters are ignored.
     */
    @JsonGetter("keywords")
    public List<String> getKeywords() {
        return this.keywords;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(keywords);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogQueryText)) {
            return false;
        }
        CatalogQueryText catalogQueryText = (CatalogQueryText) obj;
        return Objects.equals(keywords, catalogQueryText.keywords);
    }

    /**
     * Builds a new {@link CatalogQueryText.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQueryText.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(keywords);
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogQueryText}
     */
    public static class Builder {
        private List<String> keywords;

        /**
         * Initialization constructor
         */
        public Builder(List<String> keywords) {
            this.keywords = keywords;
        }

        /**
         * Setter for keywords
         * @param keywords
         * @return Builder
         */
        public Builder keywords(List<String> keywords) {
            this.keywords = keywords;
            return this;
        }

        /**
         * Builds a new {@link CatalogQueryText} object using the set fields.
         * @return {@link CatalogQueryText}
         */
        public CatalogQueryText build() {
            return new CatalogQueryText(keywords);
        }
    }
}
