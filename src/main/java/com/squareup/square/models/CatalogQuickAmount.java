package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CatalogQuickAmount type.
 */
public class CatalogQuickAmount {

    /**
     * Initialization constructor.
     * @param type
     * @param amount
     * @param score
     * @param ordinal
     */
    @JsonCreator
    public CatalogQuickAmount(
            @JsonProperty("type") String type,
            @JsonProperty("amount") Money amount,
            @JsonProperty("score") Long score,
            @JsonProperty("ordinal") Long ordinal) {
        this.type = type;
        this.amount = amount;
        this.score = score;
        this.ordinal = ordinal;
    }

    private final String type;
    private final Money amount;
    private final Long score;
    private final Long ordinal;
    /**
     * Getter for Type.
     * Determines the type of a specific Quick Amount.
     */
    @JsonGetter("type")
    public String getType() {
        return this.type;
    }

    /**
     * Getter for Amount.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("amount")
    public Money getAmount() {
        return this.amount;
    }

    /**
     * Getter for Score.
     * Describes the ranking of the Quick Amount provided by machine learning model, in the range [0, 100].
     * MANUAL type amount will always have score = 100.
     */
    @JsonGetter("score")
    public Long getScore() {
        return this.score;
    }

    /**
     * Getter for Ordinal.
     * The order in which this Quick Amount should be displayed.
     */
    @JsonGetter("ordinal")
    public Long getOrdinal() {
        return this.ordinal;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(type, amount, score, ordinal);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CatalogQuickAmount)) {
            return false;
        }
        CatalogQuickAmount catalogQuickAmount = (CatalogQuickAmount) obj;
        return Objects.equals(type, catalogQuickAmount.type) &&
            Objects.equals(amount, catalogQuickAmount.amount) &&
            Objects.equals(score, catalogQuickAmount.score) &&
            Objects.equals(ordinal, catalogQuickAmount.ordinal);
    }

    /**
     * Builds a new {@link CatalogQuickAmount.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CatalogQuickAmount.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(type,
            amount)
            .score(getScore())
            .ordinal(getOrdinal());
            return builder;
    }

    /**
     * Class to build instances of {@link CatalogQuickAmount}
     */
    public static class Builder {
        private String type;
        private Money amount;
        private Long score;
        private Long ordinal;

        /**
         * Initialization constructor
         */
        public Builder(String type,
                Money amount) {
            this.type = type;
            this.amount = amount;
        }

        /**
         * Setter for type
         * @param type
         * @return Builder
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }
        /**
         * Setter for amount
         * @param amount
         * @return Builder
         */
        public Builder amount(Money amount) {
            this.amount = amount;
            return this;
        }
        /**
         * Setter for score
         * @param score
         * @return Builder
         */
        public Builder score(Long score) {
            this.score = score;
            return this;
        }
        /**
         * Setter for ordinal
         * @param ordinal
         * @return Builder
         */
        public Builder ordinal(Long ordinal) {
            this.ordinal = ordinal;
            return this;
        }

        /**
         * Builds a new {@link CatalogQuickAmount} object using the set fields.
         * @return {@link CatalogQuickAmount}
         */
        public CatalogQuickAmount build() {
            return new CatalogQuickAmount(type,
                amount,
                score,
                ordinal);
        }
    }
}
