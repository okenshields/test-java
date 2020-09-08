# Transactions

```java
TransactionsApi transactionsApi = client.getTransactionsApi();
```

## Class Name

`TransactionsApi`

## Methods

* [List Refunds](/doc/transactions.md#list-refunds)
* [List Transactions](/doc/transactions.md#list-transactions)
* [Charge](/doc/transactions.md#charge)
* [Retrieve Transaction](/doc/transactions.md#retrieve-transaction)
* [Capture Transaction](/doc/transactions.md#capture-transaction)
* [Create Refund](/doc/transactions.md#create-refund)
* [Void Transaction](/doc/transactions.md#void-transaction)

## List Refunds

Lists refunds for one of a business's locations.

In addition to full or partial tender refunds processed through Square APIs,
refunds may result from itemized returns or exchanges through Square's
Point of Sale applications.

Refunds with a `status` of `PENDING` are not currently included in this
endpoint's response.

Max results per [page](#paginatingresults): 50

```java
CompletableFuture<ListRefundsResponse> listRefundsAsync(
    final String locationId,
    final String beginTime,
    final String endTime,
    final String sortOrder,
    final String cursor)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list refunds for. |
| `beginTime` | `String` | Query, Optional | The beginning of the requested reporting period, in RFC 3339 format.<br><br>See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.<br><br>Default value: The current time minus one year. |
| `endTime` | `String` | Query, Optional | The end of the requested reporting period, in RFC 3339 format.<br><br>See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.<br><br>Default value: The current time. |
| `sortOrder` | [`String`](/doc/models/sort-order.md) | Query, Optional | The order in which results are listed in the response (`ASC` for<br>oldest first, `DESC` for newest first).<br><br>Default value: `DESC` |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for your original query.<br><br>See [Paginating results](#paginatingresults) for more information. |

### Response Type

[`ListRefundsResponse`](/doc/models/list-refunds-response.md)

### Example Usage

```java
String locationId = "location_id4";
String beginTime = "begin_time2";
String endTime = "end_time2";
String sortOrder = "DESC";
String cursor = "cursor6";

transactionsApi.listRefundsAsync(locationId, beginTime, endTime, sortOrder, cursor).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## List Transactions

Lists transactions for a particular location.

Transactions include payment information from sales and exchanges and refund
information from returns and exchanges.

Max results per [page](#paginatingresults): 50

```java
CompletableFuture<ListTransactionsResponse> listTransactionsAsync(
    final String locationId,
    final String beginTime,
    final String endTime,
    final String sortOrder,
    final String cursor)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to list transactions for. |
| `beginTime` | `String` | Query, Optional | The beginning of the requested reporting period, in RFC 3339 format.<br><br>See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.<br><br>Default value: The current time minus one year. |
| `endTime` | `String` | Query, Optional | The end of the requested reporting period, in RFC 3339 format.<br><br>See [Date ranges](#dateranges) for details on date inclusivity/exclusivity.<br><br>Default value: The current time. |
| `sortOrder` | [`String`](/doc/models/sort-order.md) | Query, Optional | The order in which results are listed in the response (`ASC` for<br>oldest first, `DESC` for newest first).<br><br>Default value: `DESC` |
| `cursor` | `String` | Query, Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for your original query.<br><br>See [Paginating results](#paginatingresults) for more information. |

### Response Type

[`ListTransactionsResponse`](/doc/models/list-transactions-response.md)

### Example Usage

```java
String locationId = "location_id4";
String beginTime = "begin_time2";
String endTime = "end_time2";
String sortOrder = "DESC";
String cursor = "cursor6";

transactionsApi.listTransactionsAsync(locationId, beginTime, endTime, sortOrder, cursor).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Charge

Charges a card represented by a card nonce or a customer's card on file.

Your request to this endpoint must include _either_:

- A value for the `card_nonce` parameter (to charge a card nonce generated
with the `SqPaymentForm`)
- Values for the `customer_card_id` and `customer_id` parameters (to charge
a customer's card on file)

In order for an eCommerce payment to potentially qualify for
[Square chargeback protection](https://squareup.com/help/article/5394), you
_must_ provide values for the following parameters in your request:

- `buyer_email_address`
- At least one of `billing_address` or `shipping_address`

When this response is returned, the amount of Square's processing fee might not yet be
calculated. To obtain the processing fee, wait about ten seconds and call
[RetrieveTransaction](#endpoint-retrievetransaction). See the `processing_fee_money`
field of each [Tender included](#type-tender) in the transaction.

```java
CompletableFuture<ChargeResponse> chargeAsync(
    final String locationId,
    final ChargeRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to associate the created transaction with. |
| `body` | [`ChargeRequest`](/doc/models/charge-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`ChargeResponse`](/doc/models/charge-response.md)

### Example Usage

```java
String locationId = "location_id4";
Money bodyAmountMoney = new Money.Builder()
    .amount(200L)
    .currency("USD")
    .build();
Address bodyBillingAddress = new Address.Builder()
    .addressLine1("500 Electric Ave")
    .addressLine2("Suite 600")
    .addressLine3("address_line_38")
    .locality("New York")
    .sublocality("sublocality2")
    .administrativeDistrictLevel1("NY")
    .postalCode("10003")
    .country("US")
    .build();
Address bodyShippingAddress = new Address.Builder()
    .addressLine1("123 Main St")
    .addressLine2("address_line_24")
    .addressLine3("address_line_30")
    .locality("San Francisco")
    .sublocality("sublocality4")
    .administrativeDistrictLevel1("CA")
    .postalCode("94114")
    .country("US")
    .build();
List<AdditionalRecipient> bodyAdditionalRecipients = new LinkedList<>();

Money bodyAdditionalRecipients0AmountMoney = new Money.Builder()
    .amount(20L)
    .currency("USD")
    .build();
AdditionalRecipient bodyAdditionalRecipients0 = new AdditionalRecipient.Builder(
        "057P5VYJ4A5X1",
        "Application fees",
        bodyAdditionalRecipients0AmountMoney)
    .receivableId("receivable_id5")
    .build();
bodyAdditionalRecipients.add(bodyAdditionalRecipients0);

ChargeRequest body = new ChargeRequest.Builder(
        "74ae1696-b1e3-4328-af6d-f1e04d947a13",
        bodyAmountMoney)
    .cardNonce("card_nonce_from_square_123")
    .customerCardId("customer_card_id6")
    .delayCapture(false)
    .referenceId("some optional reference id")
    .note("some optional note")
    .billingAddress(bodyBillingAddress)
    .shippingAddress(bodyShippingAddress)
    .additionalRecipients(bodyAdditionalRecipients)
    .build();

transactionsApi.chargeAsync(locationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Transaction

Retrieves details for a single transaction.

```java
CompletableFuture<RetrieveTransactionResponse> retrieveTransactionAsync(
    final String locationId,
    final String transactionId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the transaction's associated location. |
| `transactionId` | `String` | Template, Required | The ID of the transaction to retrieve. |

### Response Type

[`RetrieveTransactionResponse`](/doc/models/retrieve-transaction-response.md)

### Example Usage

```java
String locationId = "location_id4";
String transactionId = "transaction_id8";

transactionsApi.retrieveTransactionAsync(locationId, transactionId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Capture Transaction

Captures a transaction that was created with the [Charge](#endpoint-charge)
endpoint with a `delay_capture` value of `true`.


See [Delayed capture transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
for more information.

```java
CompletableFuture<CaptureTransactionResponse> captureTransactionAsync(
    final String locationId,
    final String transactionId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | - |
| `transactionId` | `String` | Template, Required | - |

### Response Type

[`CaptureTransactionResponse`](/doc/models/capture-transaction-response.md)

### Example Usage

```java
String locationId = "location_id4";
String transactionId = "transaction_id8";

transactionsApi.captureTransactionAsync(locationId, transactionId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Refund

Initiates a refund for a previously charged tender.

You must issue a refund within 120 days of the associated payment. See
[this article](https://squareup.com/help/us/en/article/5060) for more information
on refund behavior.

NOTE: Card-present transactions with Interac credit cards **cannot be
refunded using the Connect API**. Interac transactions must refunded
in-person (e.g., dipping the card using POS app).

```java
CompletableFuture<CreateRefundResponse> createRefundAsync(
    final String locationId,
    final String transactionId,
    final CreateRefundRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the original transaction's associated location. |
| `transactionId` | `String` | Template, Required | The ID of the original transaction that includes the tender to refund. |
| `body` | [`CreateRefundRequest`](/doc/models/create-refund-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`CreateRefundResponse`](/doc/models/create-refund-response.md)

### Example Usage

```java
String locationId = "location_id4";
String transactionId = "transaction_id8";
Money bodyAmountMoney = new Money.Builder()
    .amount(100L)
    .currency("USD")
    .build();
CreateRefundRequest body = new CreateRefundRequest.Builder(
        "86ae1696-b1e3-4328-af6d-f1e04d947ad2",
        "MtZRYYdDrYNQbOvV7nbuBvMF",
        bodyAmountMoney)
    .reason("a reason")
    .build();

transactionsApi.createRefundAsync(locationId, transactionId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Void Transaction

Cancels a transaction that was created with the [Charge](#endpoint-charge)
endpoint with a `delay_capture` value of `true`.


See [Delayed capture transactions](https://developer.squareup.com/docs/payments/transactions/overview#delayed-capture)
for more information.

```java
CompletableFuture<VoidTransactionResponse> voidTransactionAsync(
    final String locationId,
    final String transactionId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | - |
| `transactionId` | `String` | Template, Required | - |

### Response Type

[`VoidTransactionResponse`](/doc/models/void-transaction-response.md)

### Example Usage

```java
String locationId = "location_id4";
String transactionId = "transaction_id8";

transactionsApi.voidTransactionAsync(locationId, transactionId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

