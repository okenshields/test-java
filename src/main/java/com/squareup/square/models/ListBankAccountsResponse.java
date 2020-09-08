package com.squareup.square.models;

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.squareup.square.http.client.HttpContext;


/**
 * This is a model class for ListBankAccountsResponse type.
 */
public class ListBankAccountsResponse {

    /**
     * Initialization constructor.
     * @param errors
     * @param bankAccounts
     * @param cursor
     */
    @JsonCreator
    public ListBankAccountsResponse(
            @JsonProperty("errors") List<Error> errors,
            @JsonProperty("bank_accounts") List<BankAccount> bankAccounts,
            @JsonProperty("cursor") String cursor) {
        this.errors = errors;
        this.bankAccounts = bankAccounts;
        this.cursor = cursor;
    }

    private HttpContext httpContext;
    private final List<Error> errors;
    private final List<BankAccount> bankAccounts;
    private final String cursor;

    public HttpContext getContext() {
        return httpContext;
    }

    /**
     * Getter for Errors.
     * Information on errors encountered during the request.
     */
    @JsonGetter("errors")
    public List<Error> getErrors() {
        return this.errors;
    }

    /**
     * Getter for BankAccounts.
     * List of BankAccounts associated with this account.
     */
    @JsonGetter("bank_accounts")
    public List<BankAccount> getBankAccounts() {
        return this.bankAccounts;
    }

    /**
     * Getter for Cursor.
     * When a response is truncated, it includes a cursor that you can 
     * use in a subsequent request to fetch next set of bank accounts.
     * If empty, this is the final response.
     * For more information, see [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination).
     */
    @JsonGetter("cursor")
    public String getCursor() {
        return this.cursor;
    }

 
    @Override
    public int hashCode() {
        return Objects.hash(errors, bankAccounts, cursor);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof ListBankAccountsResponse)) {
            return false;
        }
        ListBankAccountsResponse listBankAccountsResponse = (ListBankAccountsResponse) obj;
        return Objects.equals(errors, listBankAccountsResponse.errors) &&
            Objects.equals(bankAccounts, listBankAccountsResponse.bankAccounts) &&
            Objects.equals(cursor, listBankAccountsResponse.cursor);
    }

    /**
     * Builds a new {@link ListBankAccountsResponse.Builder} object.
     * Creates the instance with the state of the current model.
     * @return a new {@link ListBankAccountsResponse.Builder} object
     */
    public Builder toBuilder() {
        Builder builder = new Builder()
            .errors(getErrors())
            .bankAccounts(getBankAccounts())
            .cursor(getCursor());
            return builder;
    }

    /**
     * Class to build instances of {@link ListBankAccountsResponse}
     */
    public static class Builder {
        private HttpContext httpContext;
        private List<Error> errors;
        private List<BankAccount> bankAccounts;
        private String cursor;

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
         * Setter for bankAccounts
         * @param bankAccounts
         * @return Builder
         */
        public Builder bankAccounts(List<BankAccount> bankAccounts) {
            this.bankAccounts = bankAccounts;
            return this;
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
         * Builds a new {@link ListBankAccountsResponse} object using the set fields.
         * @return {@link ListBankAccountsResponse}
         */
        public ListBankAccountsResponse build() {
            ListBankAccountsResponse model = new ListBankAccountsResponse(errors,
                bankAccounts,
                cursor);
            model.httpContext = httpContext;
            return model;
        }
    }
}
