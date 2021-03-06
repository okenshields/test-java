## Additional Recipient

Represents an additional recipient (other than the merchant) receiving a portion of this tender.

### Structure

`AdditionalRecipient`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LocationId` | `String` |  | The location ID for a recipient (other than the merchant) receiving a portion of this tender. | String getLocationId() |
| `Description` | `String` |  | The description of the additional recipient. | String getDescription() |
| `AmountMoney` | [`Money`](/doc/models/money.md) |  | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getAmountMoney() |
| `ReceivableId` | `String` | Optional | The unique ID for this [AdditionalRecipientReceivable](#type-additionalrecipientreceivable), assigned by the server. | String getReceivableId() |

### Example (as JSON)

```json
{
  "location_id": "location_id4",
  "description": "description0",
  "amount_money": {
    "amount": 186,
    "currency": "NGN"
  },
  "receivable_id": "receivable_id0"
}
```

