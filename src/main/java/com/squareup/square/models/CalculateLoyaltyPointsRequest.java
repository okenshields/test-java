package com.squareup.square.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for CalculateLoyaltyPointsRequest type.
 */
public class CalculateLoyaltyPointsRequest {

    /**
     * Initialization constructor.
     * @param orderId
     * @param transactionAmountMoney
     */
    @JsonCreator
    public CalculateLoyaltyPointsRequest(
            @JsonProperty("order_id") String orderId,
            @JsonProperty("transaction_amount_money") Money transactionAmountMoney) {
        this.orderId = orderId;
        this.transactionAmountMoney = transactionAmountMoney;
    }

    private final String orderId;
    private final Money transactionAmountMoney;
    /**
     * Getter for OrderId.
     * The [order](#type-Order) ID for which to calculate the points.
     * Specify this field if your application uses the Orders API to process orders.
     * Otherwise, specify the `transaction_amount`.
     */
    @JsonGetter("order_id")
    public String getOrderId() {
        return this.orderId;
    }

    /**
     * Getter for TransactionAmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("transaction_amount_money")
    public Money getTransactionAmountMoney() {
        return this.transactionAmountMoney;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(orderId, transactionAmountMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof CalculateLoyaltyPointsRequest)) {
            return false;
        }
        CalculateLoyaltyPointsRequest calculateLoyaltyPointsRequest = (CalculateLoyaltyPointsRequest) obj;
        return Objects.equals(orderId, calculateLoyaltyPointsRequest.orderId) &&
            Objects.equals(transactionAmountMoney, calculateLoyaltyPointsRequest.transactionAmountMoney);
    }

    /**
     * Builds a new {@link CalculateLoyaltyPointsRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link CalculateLoyaltyPointsRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .orderId(getOrderId())
            .transactionAmountMoney(getTransactionAmountMoney());
            return builder;
    }

    /**
     * Class to build instances of {@link CalculateLoyaltyPointsRequest}
     */
    public static class Builder {
        private String orderId;
        private Money transactionAmountMoney;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for orderId
         * @param orderId
         * @return Builder
         */
        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }
        /**
         * Setter for transactionAmountMoney
         * @param transactionAmountMoney
         * @return Builder
         */
        public Builder transactionAmountMoney(Money transactionAmountMoney) {
            this.transactionAmountMoney = transactionAmountMoney;
            return this;
        }

        /**
         * Builds a new {@link CalculateLoyaltyPointsRequest} object using the set fields.
         * @return {@link CalculateLoyaltyPointsRequest}
         */
        public CalculateLoyaltyPointsRequest build() {
            return new CalculateLoyaltyPointsRequest(orderId,
                transactionAmountMoney);
        }
    }
}
