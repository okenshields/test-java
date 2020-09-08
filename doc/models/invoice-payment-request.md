## Invoice Payment Request

Describes a specific payment request in an invoice. You can have 
up to nine payment requests for an invoice.

### Structure

`InvoicePaymentRequest`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Uid` | `String` | Optional | The Square-generated ID of the payment request in an [invoice](#type-invoice). | String getUid() |
| `RequestMethod` | [`String`](/doc/models/invoice-request-method.md) | Optional | Specifies the action for Square to take for processing the invoice. For example, <br>email the invoice, charge a customer's card on file, or do nothing. | String getRequestMethod() |
| `RequestType` | [`String`](/doc/models/invoice-request-type.md) | Optional | Identifies the type of the payment request. For more information, <br>see [Payment request](TBD). | String getRequestType() |
| `DueDate` | `String` | Optional | The due date (in the invoice location's time zone) for the payment request. <br>After this date, the invoice becomes overdue. | String getDueDate() |
| `FixedAmountRequestedMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getFixedAmountRequestedMoney() |
| `PercentageRequested` | `String` | Optional | Specifies the amount for the payment request in percentage:<br><br>- When the payment `request_type` is `DEPOSIT`, it is the percentage of the order total amount.<br>- When the payment `request_type` is `INSTALLMENT`, it is the percentage of the order total less <br>the deposit, if requested. The sum of the `percentage_requested` in all installment <br>payment requests must be equal to 100.<br><br>You cannot specify this when the payment `request_type` is `BALANCE` or when the <br>payment request specifies the `fixed_amount_requested_money` field. | String getPercentageRequested() |
| `TippingEnabled` | `Boolean` | Optional | If set to true, the Square-hosted invoice page (the `public_url` field of the invoice) <br>provides a place for the customer to pay a tip. <br><br>This field is allowed only on the final payment request  <br>and the payment `request_type` must be `BALANCE` or `INSTALLMENT`. | Boolean getTippingEnabled() |
| `CardId` | `String` | Optional | If the request method is `CHARGE_CARD_ON_FILE`, this field provides the <br>card to charge. | String getCardId() |
| `Reminders` | [`List<InvoicePaymentReminder>`](/doc/models/invoice-payment-reminder.md) | Optional | A list of one or more reminders to send for the payment request. | List<InvoicePaymentReminder> getReminders() |
| `ComputedAmountMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getComputedAmountMoney() |
| `TotalCompletedAmountMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getTotalCompletedAmountMoney() |
| `RoundingAdjustmentIncludedMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getRoundingAdjustmentIncludedMoney() |

### Example (as JSON)

```json
{
  "uid": "uid0",
  "request_method": "CHARGE_CARD_ON_FILE",
  "request_type": "BALANCE",
  "due_date": "due_date8",
  "fixed_amount_requested_money": {
    "amount": 162,
    "currency": "TOP"
  }
}
```

