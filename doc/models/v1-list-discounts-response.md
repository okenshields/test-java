## V1 List Discounts Response

### Structure

`V1ListDiscountsResponse`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Items` | [`List<V1Discount>`](/doc/models/v1-discount.md) | Optional | - | List<V1Discount> getItems() |

### Example (as JSON)

```json
{
  "items": [
    {
      "id": "id7",
      "name": "name7",
      "rate": "rate3",
      "amount_money": {
        "amount": 245,
        "currency_code": "CZK"
      },
      "discount_type": "VARIABLE_PERCENTAGE"
    },
    {
      "id": "id8",
      "name": "name8",
      "rate": "rate2",
      "amount_money": {
        "amount": 246,
        "currency_code": "DJF"
      },
      "discount_type": "VARIABLE_AMOUNT"
    }
  ]
}
```

