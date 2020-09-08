package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for SubscriptionPhase type.
 */
public class SubscriptionPhase {

    /**
     * Initialization constructor.
     * @param cadence
     * @param recurringPriceMoney
     * @param uid
     * @param periods
     * @param ordinal
     */
    @JsonCreator
    public SubscriptionPhase(
            @JsonProperty("cadence") String cadence,
            @JsonProperty("recurring_price_money") Money recurringPriceMoney,
            @JsonProperty("uid") String uid,
            @JsonProperty("periods") Integer periods,
            @JsonProperty("ordinal") Long ordinal) {
        this.uid = uid;
        this.cadence = cadence;
        this.periods = periods;
        this.recurringPriceMoney = recurringPriceMoney;
        this.ordinal = ordinal;
    }

    private final String uid;
    private final String cadence;
    private final Integer periods;
    private final Money recurringPriceMoney;
    private final Long ordinal;
    /**
     * Getter for Uid.
     * The Square-assigned ID of the subscription phase. This field cannot be changed after a `SubscriptionPhase` is created.
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
    }

    /**
     * Getter for Cadence.
     * Determines the billing cadence of a [Subscription](#type-Subscription)
     */
    @JsonGetter("cadence")
    public String getCadence() {
        return this.cadence;
    }

    /**
     * Getter for Periods.
     * The number of `cadence`s the phase lasts. If not set, the phase never ends. Only the last phase can be indefinite. This field cannot be changed after a `SubscriptionPhase` is created.
     */
    @JsonGetter("periods")
    public Integer getPeriods() {
        return this.periods;
    }

    /**
     * Getter for RecurringPriceMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("recurring_price_money")
    public Money getRecurringPriceMoney() {
        return this.recurringPriceMoney;
    }

    /**
     * Getter for Ordinal.
     * The position this phase appears in the sequence of phases defined for the plan, indexed from 0. This field cannot be changed after a `SubscriptionPhase` is created.
     */
    @JsonGetter("ordinal")
    public Long getOrdinal() {
        return this.ordinal;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(uid, cadence, periods, recurringPriceMoney, ordinal);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof SubscriptionPhase)) {
            return false;
        }
        SubscriptionPhase subscriptionPhase = (SubscriptionPhase) obj;
        return Objects.equals(uid, subscriptionPhase.uid) &&
            Objects.equals(cadence, subscriptionPhase.cadence) &&
            Objects.equals(periods, subscriptionPhase.periods) &&
            Objects.equals(recurringPriceMoney, subscriptionPhase.recurringPriceMoney) &&
            Objects.equals(ordinal, subscriptionPhase.ordinal);
    }

    /**
     * Builds a new {@link SubscriptionPhase.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link SubscriptionPhase.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(cadence,
            recurringPriceMoney)
            .uid(getUid())
            .periods(getPeriods())
            .ordinal(getOrdinal());
            return builder;
    }

    /**
     * Class to build instances of {@link SubscriptionPhase}
     */
    public static class Builder {
        private String cadence;
        private Money recurringPriceMoney;
        private String uid;
        private Integer periods;
        private Long ordinal;

        /**
         * Initialization constructor
         */
        public Builder(String cadence,
                Money recurringPriceMoney) {
            this.cadence = cadence;
            this.recurringPriceMoney = recurringPriceMoney;
        }

        /**
         * Setter for cadence
         * @param cadence
         * @return Builder
         */
        public Builder cadence(String cadence) {
            this.cadence = cadence;
            return this;
        }
        /**
         * Setter for recurringPriceMoney
         * @param recurringPriceMoney
         * @return Builder
         */
        public Builder recurringPriceMoney(Money recurringPriceMoney) {
            this.recurringPriceMoney = recurringPriceMoney;
            return this;
        }
        /**
         * Setter for uid
         * @param uid
         * @return Builder
         */
        public Builder uid(String uid) {
            this.uid = uid;
            return this;
        }
        /**
         * Setter for periods
         * @param periods
         * @return Builder
         */
        public Builder periods(Integer periods) {
            this.periods = periods;
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
         * Builds a new {@link SubscriptionPhase} object using the set fields.
         * @return {@link SubscriptionPhase}
         */
        public SubscriptionPhase build() {
            return new SubscriptionPhase(cadence,
                recurringPriceMoney,
                uid,
                periods,
                ordinal);
        }
    }
}
