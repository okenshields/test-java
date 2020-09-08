## Tender

Represents a tender (i.e., a method of payment) used in a Square transaction.

### Structure

`Tender`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The tender's unique ID. | String getId() |
| `LocationId` | `String` | Optional | The ID of the transaction's associated location. | String getLocationId() |
| `TransactionId` | `String` | Optional | The ID of the tender's associated transaction. | String getTransactionId() |
| `CreatedAt` | `String` | Optional | The timestamp for when the tender was created, in RFC 3339 format. | String getCreatedAt() |
| `Note` | `String` | Optional | An optional note associated with the tender at the time of payment. | String getNote() |
| `AmountMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getAmountMoney() |
| `TipMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getTipMoney() |
| `ProcessingFeeMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getProcessingFeeMoney() |
| `CustomerId` | `String` | Optional | If the tender is associated with a customer or represents a customer's card on file,<br>this is the ID of the associated customer. | String getCustomerId() |
| `Type` | [`String`](/doc/models/tender-type.md) |  | Indicates a tender's type. | String getType() |
| `CardDetails` | [`TenderCardDetails`](/doc/models/tender-card-details.md) | Optional | Represents additional details of a tender with `type` `CARD` or `SQUARE_GIFT_CARD` | TenderCardDetails getCardDetails() |
| `CashDetails` | [`TenderCashDetails`](/doc/models/tender-cash-details.md) | Optional | Represents the details of a tender with `type` `CASH`. | TenderCashDetails getCashDetails() |
| `BankTransferDetails` | [`TenderBankTransferDetails`](/doc/models/tender-bank-transfer-details.md) | Optional | Represents the details of a tender with `type` `BANK_TRANSFER`.<br><br>See [PaymentBankTransferDetails](#type-paymentbanktransferdetails) for more exposed details of a bank transfer payment. | TenderBankTransferDetails getBankTransferDetails() |
| `AdditionalRecipients` | [`List<AdditionalRecipient>`](/doc/models/additional-recipient.md) | Optional | Additional recipients (other than the merchant) receiving a portion of this tender.<br>For example, fees assessed on the purchase by a third party integration. | List<AdditionalRecipient> getAdditionalRecipients() |
| `PaymentId` | `String` | Optional | The ID of the [Payment](#type-payment) that corresponds to this tender.<br>This value is only present for payments created with the v2 Payments API. | String getPaymentId() |

### Example (as JSON)

```json
{
  "id": "id0",
  "location_id": "location_id4",
  "transaction_id": "transaction_id8",
  "created_at": "created_at2",
  "note": "note4",
  "type": "BANK_TRANSFER"
}
```

