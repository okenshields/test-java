package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for InvoicePaymentRequest type.
 */
public class InvoicePaymentRequest {

    /**
     * Initialization constructor.
     * @param uid
     * @param requestMethod
     * @param requestType
     * @param dueDate
     * @param fixedAmountRequestedMoney
     * @param percentageRequested
     * @param tippingEnabled
     * @param cardId
     * @param reminders
     * @param computedAmountMoney
     * @param totalCompletedAmountMoney
     * @param roundingAdjustmentIncludedMoney
     */
    @JsonCreator
    public InvoicePaymentRequest(
            @JsonProperty("uid") String uid,
            @JsonProperty("request_method") String requestMethod,
            @JsonProperty("request_type") String requestType,
            @JsonProperty("due_date") String dueDate,
            @JsonProperty("fixed_amount_requested_money") Money fixedAmountRequestedMoney,
            @JsonProperty("percentage_requested") String percentageRequested,
            @JsonProperty("tipping_enabled") Boolean tippingEnabled,
            @JsonProperty("card_id") String cardId,
            @JsonProperty("reminders") List<InvoicePaymentReminder> reminders,
            @JsonProperty("computed_amount_money") Money computedAmountMoney,
            @JsonProperty("total_completed_amount_money") Money totalCompletedAmountMoney,
            @JsonProperty("rounding_adjustment_included_money") Money roundingAdjustmentIncludedMoney) {
        this.uid = uid;
        this.requestMethod = requestMethod;
        this.requestType = requestType;
        this.dueDate = dueDate;
        this.fixedAmountRequestedMoney = fixedAmountRequestedMoney;
        this.percentageRequested = percentageRequested;
        this.tippingEnabled = tippingEnabled;
        this.cardId = cardId;
        this.reminders = reminders;
        this.computedAmountMoney = computedAmountMoney;
        this.totalCompletedAmountMoney = totalCompletedAmountMoney;
        this.roundingAdjustmentIncludedMoney = roundingAdjustmentIncludedMoney;
    }

    private final String uid;
    private final String requestMethod;
    private final String requestType;
    private final String dueDate;
    private final Money fixedAmountRequestedMoney;
    private final String percentageRequested;
    private final Boolean tippingEnabled;
    private final String cardId;
    private final List<InvoicePaymentReminder> reminders;
    private final Money computedAmountMoney;
    private final Money totalCompletedAmountMoney;
    private final Money roundingAdjustmentIncludedMoney;
    /**
     * Getter for Uid.
     * The Square-generated ID of the payment request in an [invoice](#type-invoice).
     */
    @JsonGetter("uid")
    public String getUid() {
        return this.uid;
    }

    /**
     * Getter for RequestMethod.
     * Specifies the action for Square to take for processing the invoice. For example, 
     * email the invoice, charge a customer's card on file, or do nothing.
     */
    @JsonGetter("request_method")
    public String getRequestMethod() {
        return this.requestMethod;
    }

    /**
     * Getter for RequestType.
     * Identifies the type of the payment request. For more information, 
     * see [Payment request](TBD).
     */
    @JsonGetter("request_type")
    public String getRequestType() {
        return this.requestType;
    }

    /**
     * Getter for DueDate.
     * The due date (in the invoice location's time zone) for the payment request. 
     * After this date, the invoice becomes overdue.
     */
    @JsonGetter("due_date")
    public String getDueDate() {
        return this.dueDate;
    }

    /**
     * Getter for FixedAmountRequestedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("fixed_amount_requested_money")
    public Money getFixedAmountRequestedMoney() {
        return this.fixedAmountRequestedMoney;
    }

    /**
     * Getter for PercentageRequested.
     * Specifies the amount for the payment request in percentage:
     * - When the payment `request_type` is `DEPOSIT`, it is the percentage of the order total amount.
     * - When the payment `request_type` is `INSTALLMENT`, it is the percentage of the order total less 
     * the deposit, if requested. The sum of the `percentage_requested` in all installment 
     * payment requests must be equal to 100.
     * You cannot specify this when the payment `request_type` is `BALANCE` or when the 
     * payment request specifies the `fixed_amount_requested_money` field.
     */
    @JsonGetter("percentage_requested")
    public String getPercentageRequested() {
        return this.percentageRequested;
    }

    /**
     * Getter for TippingEnabled.
     * If set to true, the Square-hosted invoice page (the `public_url` field of the invoice) 
     * provides a place for the customer to pay a tip. 
     * This field is allowed only on the final payment request  
     * and the payment `request_type` must be `BALANCE` or `INSTALLMENT`.
     */
    @JsonGetter("tipping_enabled")
    public Boolean getTippingEnabled() {
        return this.tippingEnabled;
    }

    /**
     * Getter for CardId.
     * If the request method is `CHARGE_CARD_ON_FILE`, this field provides the 
     * card to charge.
     */
    @JsonGetter("card_id")
    public String getCardId() {
        return this.cardId;
    }

    /**
     * Getter for Reminders.
     * A list of one or more reminders to send for the payment request.
     */
    @JsonGetter("reminders")
    public List<InvoicePaymentReminder> getReminders() {
        return this.reminders;
    }

    /**
     * Getter for ComputedAmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("computed_amount_money")
    public Money getComputedAmountMoney() {
        return this.computedAmountMoney;
    }

    /**
     * Getter for TotalCompletedAmountMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("total_completed_amount_money")
    public Money getTotalCompletedAmountMoney() {
        return this.totalCompletedAmountMoney;
    }

    /**
     * Getter for RoundingAdjustmentIncludedMoney.
     * Represents an amount of money. `Money` fields can be signed or unsigned.
     * Fields that do not explicitly define whether they are signed or unsigned are
     * considered unsigned and can only hold positive amounts. For signed fields, the
     * sign of the value indicates the purpose of the money transfer. See
     * [Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)
     * for more information.
     */
    @JsonGetter("rounding_adjustment_included_money")
    public Money getRoundingAdjustmentIncludedMoney() {
        return this.roundingAdjustmentIncludedMoney;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(uid, requestMethod, requestType, dueDate, fixedAmountRequestedMoney,
            percentageRequested, tippingEnabled, cardId, reminders, computedAmountMoney,
            totalCompletedAmountMoney, roundingAdjustmentIncludedMoney);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof InvoicePaymentRequest)) {
            return false;
        }
        InvoicePaymentRequest invoicePaymentRequest = (InvoicePaymentRequest) obj;
        return Objects.equals(uid, invoicePaymentRequest.uid) &&
            Objects.equals(requestMethod, invoicePaymentRequest.requestMethod) &&
            Objects.equals(requestType, invoicePaymentRequest.requestType) &&
            Objects.equals(dueDate, invoicePaymentRequest.dueDate) &&
            Objects.equals(fixedAmountRequestedMoney, invoicePaymentRequest.fixedAmountRequestedMoney) &&
            Objects.equals(percentageRequested, invoicePaymentRequest.percentageRequested) &&
            Objects.equals(tippingEnabled, invoicePaymentRequest.tippingEnabled) &&
            Objects.equals(cardId, invoicePaymentRequest.cardId) &&
            Objects.equals(reminders, invoicePaymentRequest.reminders) &&
            Objects.equals(computedAmountMoney, invoicePaymentRequest.computedAmountMoney) &&
            Objects.equals(totalCompletedAmountMoney, invoicePaymentRequest.totalCompletedAmountMoney) &&
            Objects.equals(roundingAdjustmentIncludedMoney, invoicePaymentRequest.roundingAdjustmentIncludedMoney);
    }

    /**
     * Builds a new {@link InvoicePaymentRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link InvoicePaymentRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .uid(getUid())
            .requestMethod(getRequestMethod())
            .requestType(getRequestType())
            .dueDate(getDueDate())
            .fixedAmountRequestedMoney(getFixedAmountRequestedMoney())
            .percentageRequested(getPercentageRequested())
            .tippingEnabled(getTippingEnabled())
            .cardId(getCardId())
            .reminders(getReminders())
            .computedAmountMoney(getComputedAmountMoney())
            .totalCompletedAmountMoney(getTotalCompletedAmountMoney())
            .roundingAdjustmentIncludedMoney(getRoundingAdjustmentIncludedMoney());
            return builder;
    }

    /**
     * Class to build instances of {@link InvoicePaymentRequest}
     */
    public static class Builder {
        private String uid;
        private String requestMethod;
        private String requestType;
        private String dueDate;
        private Money fixedAmountRequestedMoney;
        private String percentageRequested;
        private Boolean tippingEnabled;
        private String cardId;
        private List<InvoicePaymentReminder> reminders;
        private Money computedAmountMoney;
        private Money totalCompletedAmountMoney;
        private Money roundingAdjustmentIncludedMoney;

        /**
         * Initialization constructor
         */
        public Builder() {
           
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
         * Setter for requestMethod
         * @param requestMethod
         * @return Builder
         */
        public Builder requestMethod(String requestMethod) {
            this.requestMethod = requestMethod;
            return this;
        }
        /**
         * Setter for requestType
         * @param requestType
         * @return Builder
         */
        public Builder requestType(String requestType) {
            this.requestType = requestType;
            return this;
        }
        /**
         * Setter for dueDate
         * @param dueDate
         * @return Builder
         */
        public Builder dueDate(String dueDate) {
            this.dueDate = dueDate;
            return this;
        }
        /**
         * Setter for fixedAmountRequestedMoney
         * @param fixedAmountRequestedMoney
         * @return Builder
         */
        public Builder fixedAmountRequestedMoney(Money fixedAmountRequestedMoney) {
            this.fixedAmountRequestedMoney = fixedAmountRequestedMoney;
            return this;
        }
        /**
         * Setter for percentageRequested
         * @param percentageRequested
         * @return Builder
         */
        public Builder percentageRequested(String percentageRequested) {
            this.percentageRequested = percentageRequested;
            return this;
        }
        /**
         * Setter for tippingEnabled
         * @param tippingEnabled
         * @return Builder
         */
        public Builder tippingEnabled(Boolean tippingEnabled) {
            this.tippingEnabled = tippingEnabled;
            return this;
        }
        /**
         * Setter for cardId
         * @param cardId
         * @return Builder
         */
        public Builder cardId(String cardId) {
            this.cardId = cardId;
            return this;
        }
        /**
         * Setter for reminders
         * @param reminders
         * @return Builder
         */
        public Builder reminders(List<InvoicePaymentReminder> reminders) {
            this.reminders = reminders;
            return this;
        }
        /**
         * Setter for computedAmountMoney
         * @param computedAmountMoney
         * @return Builder
         */
        public Builder computedAmountMoney(Money computedAmountMoney) {
            this.computedAmountMoney = computedAmountMoney;
            return this;
        }
        /**
         * Setter for totalCompletedAmountMoney
         * @param totalCompletedAmountMoney
         * @return Builder
         */
        public Builder totalCompletedAmountMoney(Money totalCompletedAmountMoney) {
            this.totalCompletedAmountMoney = totalCompletedAmountMoney;
            return this;
        }
        /**
         * Setter for roundingAdjustmentIncludedMoney
         * @param roundingAdjustmentIncludedMoney
         * @return Builder
         */
        public Builder roundingAdjustmentIncludedMoney(Money roundingAdjustmentIncludedMoney) {
            this.roundingAdjustmentIncludedMoney = roundingAdjustmentIncludedMoney;
            return this;
        }

        /**
         * Builds a new {@link InvoicePaymentRequest} object using the set fields.
         * @return {@link InvoicePaymentRequest}
         */
        public InvoicePaymentRequest build() {
            return new InvoicePaymentRequest(uid,
                requestMethod,
                requestType,
                dueDate,
                fixedAmountRequestedMoney,
                percentageRequested,
                tippingEnabled,
                cardId,
                reminders,
                computedAmountMoney,
                totalCompletedAmountMoney,
                roundingAdjustmentIncludedMoney);
        }
    }
}
