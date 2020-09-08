package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for UpdateInvoiceRequest type.
 */
public class UpdateInvoiceRequest {

    /**
     * Initialization constructor.
     * @param invoice
     * @param idempotencyKey
     * @param fieldsToClear
     */
    @JsonCreator
    public UpdateInvoiceRequest(
            @JsonProperty("invoice") Invoice invoice,
            @JsonProperty("idempotency_key") String idempotencyKey,
            @JsonProperty("fields_to_clear") List<String> fieldsToClear) {
        this.invoice = invoice;
        this.idempotencyKey = idempotencyKey;
        this.fieldsToClear = fieldsToClear;
    }

    private final Invoice invoice;
    private final String idempotencyKey;
    private final List<String> fieldsToClear;
    /**
     * Getter for Invoice.
     * Stores information about an invoice. You use the Invoices API to create and process
     * invoices. For more information, see [Manage Invoices Using the Invoices API](https://developer.squareup.com/docs/docs/invoices-api/overview).
     */
    @JsonGetter("invoice")
    public Invoice getInvoice() {
        return this.invoice;
    }

    /**
     * Getter for IdempotencyKey.
     * A unique string that identifies the `UpdateInvoice` request. If you do not
     * provide `idempotency_key` (or provide an empty string as the value), the endpoint
     * treats each request as independent.
     * For more information, see [Idempotency](https://developer.squareup.com/docs/docs/working-with-apis/idempotency).
     */
    @JsonGetter("idempotency_key")
    public String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /**
     * Getter for FieldsToClear.
     * List of fields to clear.
     * For examples, see [Update an invoice](https://developer.squareup.com/docs/docs/invoices-api/overview#update-an-invoice).
     */
    @JsonGetter("fields_to_clear")
    public List<String> getFieldsToClear() {
        return this.fieldsToClear;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(invoice, idempotencyKey, fieldsToClear);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof UpdateInvoiceRequest)) {
            return false;
        }
        UpdateInvoiceRequest updateInvoiceRequest = (UpdateInvoiceRequest) obj;
        return Objects.equals(invoice, updateInvoiceRequest.invoice) &&
            Objects.equals(idempotencyKey, updateInvoiceRequest.idempotencyKey) &&
            Objects.equals(fieldsToClear, updateInvoiceRequest.fieldsToClear);
    }

    /**
     * Builds a new {@link UpdateInvoiceRequest.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link UpdateInvoiceRequest.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder(invoice)
            .idempotencyKey(getIdempotencyKey())
            .fieldsToClear(getFieldsToClear());
            return builder;
    }

    /**
     * Class to build instances of {@link UpdateInvoiceRequest}
     */
    public static class Builder {
        private Invoice invoice;
        private String idempotencyKey;
        private List<String> fieldsToClear;

        /**
         * Initialization constructor
         */
        public Builder(Invoice invoice) {
            this.invoice = invoice;
        }

        /**
         * Setter for invoice
         * @param invoice
         * @return Builder
         */
        public Builder invoice(Invoice invoice) {
            this.invoice = invoice;
            return this;
        }
        /**
         * Setter for idempotencyKey
         * @param idempotencyKey
         * @return Builder
         */
        public Builder idempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }
        /**
         * Setter for fieldsToClear
         * @param fieldsToClear
         * @return Builder
         */
        public Builder fieldsToClear(List<String> fieldsToClear) {
            this.fieldsToClear = fieldsToClear;
            return this;
        }

        /**
         * Builds a new {@link UpdateInvoiceRequest} object using the set fields.
         * @return {@link UpdateInvoiceRequest}
         */
        public UpdateInvoiceRequest build() {
            return new UpdateInvoiceRequest(invoice,
                idempotencyKey,
                fieldsToClear);
        }
    }
}
