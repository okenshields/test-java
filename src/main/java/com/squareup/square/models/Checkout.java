package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;


/**
 * This is a model class for Checkout type.
 */
public class Checkout {

    /**
     * Initialization constructor.
     * @param id
     * @param checkoutPageUrl
     * @param askForShippingAddress
     * @param merchantSupportEmail
     * @param prePopulateBuyerEmail
     * @param prePopulateShippingAddress
     * @param redirectUrl
     * @param order
     * @param createdAt
     * @param additionalRecipients
     */
    @JsonCreator
    public Checkout(
            @JsonProperty("id") String id,
            @JsonProperty("checkout_page_url") String checkoutPageUrl,
            @JsonProperty("ask_for_shipping_address") Boolean askForShippingAddress,
            @JsonProperty("merchant_support_email") String merchantSupportEmail,
            @JsonProperty("pre_populate_buyer_email") String prePopulateBuyerEmail,
            @JsonProperty("pre_populate_shipping_address") Address prePopulateShippingAddress,
            @JsonProperty("redirect_url") String redirectUrl,
            @JsonProperty("order") Order order,
            @JsonProperty("created_at") String createdAt,
            @JsonProperty("additional_recipients") List<AdditionalRecipient> additionalRecipients) {
        this.id = id;
        this.checkoutPageUrl = checkoutPageUrl;
        this.askForShippingAddress = askForShippingAddress;
        this.merchantSupportEmail = merchantSupportEmail;
        this.prePopulateBuyerEmail = prePopulateBuyerEmail;
        this.prePopulateShippingAddress = prePopulateShippingAddress;
        this.redirectUrl = redirectUrl;
        this.order = order;
        this.createdAt = createdAt;
        this.additionalRecipients = additionalRecipients;
    }

    private final String id;
    private final String checkoutPageUrl;
    private final Boolean askForShippingAddress;
    private final String merchantSupportEmail;
    private final String prePopulateBuyerEmail;
    private final Address prePopulateShippingAddress;
    private final String redirectUrl;
    private final Order order;
    private final String createdAt;
    private final List<AdditionalRecipient> additionalRecipients;
    /**
     * Getter for Id.
     * ID generated by Square Checkout when a new checkout is requested.
     */
    @JsonGetter("id")
    public String getId() {
        return this.id;
    }

    /**
     * Getter for CheckoutPageUrl.
     * The URL that the buyer's browser should be redirected to after the
     * checkout is completed.
     */
    @JsonGetter("checkout_page_url")
    public String getCheckoutPageUrl() {
        return this.checkoutPageUrl;
    }

    /**
     * Getter for AskForShippingAddress.
     * If `true`, Square Checkout will collect shipping information on your
     * behalf and store that information with the transaction information in your
     * Square Dashboard.
     * Default: `false`.
     */
    @JsonGetter("ask_for_shipping_address")
    public Boolean getAskForShippingAddress() {
        return this.askForShippingAddress;
    }

    /**
     * Getter for MerchantSupportEmail.
     * The email address to display on the Square Checkout confirmation page
     * and confirmation email that the buyer can use to contact the merchant.
     * If this value is not set, the confirmation page and email will display the
     * primary email address associated with the merchant's Square account.
     * Default: none; only exists if explicitly set.
     */
    @JsonGetter("merchant_support_email")
    public String getMerchantSupportEmail() {
        return this.merchantSupportEmail;
    }

    /**
     * Getter for PrePopulateBuyerEmail.
     * If provided, the buyer's email is pre-populated on the checkout page
     * as an editable text field.
     * Default: none; only exists if explicitly set.
     */
    @JsonGetter("pre_populate_buyer_email")
    public String getPrePopulateBuyerEmail() {
        return this.prePopulateBuyerEmail;
    }

    /**
     * Getter for PrePopulateShippingAddress.
     * Represents a physical address.
     */
    @JsonGetter("pre_populate_shipping_address")
    public Address getPrePopulateShippingAddress() {
        return this.prePopulateShippingAddress;
    }

    /**
     * Getter for RedirectUrl.
     * The URL to redirect to after checkout is completed with `checkoutId`,
     * Square's `orderId`, `transactionId`, and `referenceId` appended as URL
     * parameters. For example, if the provided redirect_url is
     * `http://www.example.com/order-complete`, a successful transaction redirects
     * the customer to:
     * `http://www.example.com/order-complete?checkoutId=xxxxxx&orderId=xxxxxx&referenceId=xxxxxx&transactionId=xxxxxx`
     * If you do not provide a redirect URL, Square Checkout will display an order
     * confirmation page on your behalf; however Square strongly recommends that
     * you provide a redirect URL so you can verify the transaction results and
     * finalize the order through your existing/normal confirmation workflow.
     */
    @JsonGetter("redirect_url")
    public String getRedirectUrl() {
        return this.redirectUrl;
    }

    /**
     * Getter for Order.
     * Contains all information related to a single order to process with Square,
     * including line items that specify the products to purchase. Order objects also
     * include information on any associated tenders, refunds, and returns.
     * All Connect V2 Transactions have all been converted to Orders including all associated
     * itemization data.
     */
    @JsonGetter("order")
    public Order getOrder() {
        return this.order;
    }

    /**
     * Getter for CreatedAt.
     * The time when the checkout was created, in RFC 3339 format.
     */
    @JsonGetter("created_at")
    public String getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Getter for AdditionalRecipients.
     * Additional recipients (other than the merchant) receiving a portion of this checkout.
     * For example, fees assessed on the purchase by a third party integration.
     */
    @JsonGetter("additional_recipients")
    public List<AdditionalRecipient> getAdditionalRecipients() {
        return this.additionalRecipients;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(id, checkoutPageUrl, askForShippingAddress, merchantSupportEmail,
            prePopulateBuyerEmail, prePopulateShippingAddress, redirectUrl, order, createdAt,
            additionalRecipients);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Checkout)) {
            return false;
        }
        Checkout checkout = (Checkout) obj;
        return Objects.equals(id, checkout.id) &&
            Objects.equals(checkoutPageUrl, checkout.checkoutPageUrl) &&
            Objects.equals(askForShippingAddress, checkout.askForShippingAddress) &&
            Objects.equals(merchantSupportEmail, checkout.merchantSupportEmail) &&
            Objects.equals(prePopulateBuyerEmail, checkout.prePopulateBuyerEmail) &&
            Objects.equals(prePopulateShippingAddress, checkout.prePopulateShippingAddress) &&
            Objects.equals(redirectUrl, checkout.redirectUrl) &&
            Objects.equals(order, checkout.order) &&
            Objects.equals(createdAt, checkout.createdAt) &&
            Objects.equals(additionalRecipients, checkout.additionalRecipients);
    }

    /**
     * Builds a new {@link Checkout.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link Checkout.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .id(getId())
            .checkoutPageUrl(getCheckoutPageUrl())
            .askForShippingAddress(getAskForShippingAddress())
            .merchantSupportEmail(getMerchantSupportEmail())
            .prePopulateBuyerEmail(getPrePopulateBuyerEmail())
            .prePopulateShippingAddress(getPrePopulateShippingAddress())
            .redirectUrl(getRedirectUrl())
            .order(getOrder())
            .createdAt(getCreatedAt())
            .additionalRecipients(getAdditionalRecipients());
            return builder;
    }

    /**
     * Class to build instances of {@link Checkout}
     */
    public static class Builder {
        private String id;
        private String checkoutPageUrl;
        private Boolean askForShippingAddress;
        private String merchantSupportEmail;
        private String prePopulateBuyerEmail;
        private Address prePopulateShippingAddress;
        private String redirectUrl;
        private Order order;
        private String createdAt;
        private List<AdditionalRecipient> additionalRecipients;

        /**
         * Initialization constructor
         */
        public Builder() {
           
        }

        /**
         * Setter for id
         * @param id
         * @return Builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        /**
         * Setter for checkoutPageUrl
         * @param checkoutPageUrl
         * @return Builder
         */
        public Builder checkoutPageUrl(String checkoutPageUrl) {
            this.checkoutPageUrl = checkoutPageUrl;
            return this;
        }
        /**
         * Setter for askForShippingAddress
         * @param askForShippingAddress
         * @return Builder
         */
        public Builder askForShippingAddress(Boolean askForShippingAddress) {
            this.askForShippingAddress = askForShippingAddress;
            return this;
        }
        /**
         * Setter for merchantSupportEmail
         * @param merchantSupportEmail
         * @return Builder
         */
        public Builder merchantSupportEmail(String merchantSupportEmail) {
            this.merchantSupportEmail = merchantSupportEmail;
            return this;
        }
        /**
         * Setter for prePopulateBuyerEmail
         * @param prePopulateBuyerEmail
         * @return Builder
         */
        public Builder prePopulateBuyerEmail(String prePopulateBuyerEmail) {
            this.prePopulateBuyerEmail = prePopulateBuyerEmail;
            return this;
        }
        /**
         * Setter for prePopulateShippingAddress
         * @param prePopulateShippingAddress
         * @return Builder
         */
        public Builder prePopulateShippingAddress(Address prePopulateShippingAddress) {
            this.prePopulateShippingAddress = prePopulateShippingAddress;
            return this;
        }
        /**
         * Setter for redirectUrl
         * @param redirectUrl
         * @return Builder
         */
        public Builder redirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
            return this;
        }
        /**
         * Setter for order
         * @param order
         * @return Builder
         */
        public Builder order(Order order) {
            this.order = order;
            return this;
        }
        /**
         * Setter for createdAt
         * @param createdAt
         * @return Builder
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        /**
         * Setter for additionalRecipients
         * @param additionalRecipients
         * @return Builder
         */
        public Builder additionalRecipients(List<AdditionalRecipient> additionalRecipients) {
            this.additionalRecipients = additionalRecipients;
            return this;
        }

        /**
         * Builds a new {@link Checkout} object using the set fields.
         * @return {@link Checkout}
         */
        public Checkout build() {
            return new Checkout(id,
                checkoutPageUrl,
                askForShippingAddress,
                merchantSupportEmail,
                prePopulateBuyerEmail,
                prePopulateShippingAddress,
                redirectUrl,
                order,
                createdAt,
                additionalRecipients);
        }
    }
}