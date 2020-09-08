## Order Created

### Structure

`OrderCreated`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `OrderId` | `String` | Optional | The order's unique ID. | String getOrderId() |
| `Version` | `Integer` | Optional | Version number which is incremented each time an update is committed to the order.<br>Orders that were not created through the API will not include a version and<br>thus cannot be updated.<br><br>[Read more about working with versions](https://developer.squareup.com/docs/docs/orders-api/manage-orders#update-orders) | Integer getVersion() |
| `LocationId` | `String` | Optional | The ID of the merchant location this order is associated with. | String getLocationId() |
| `State` | [`String`](/doc/models/order-state.md) | Optional | The state of the order. | String getState() |
| `CreatedAt` | `String` | Optional | Timestamp for when the order was created in RFC 3339 format. | String getCreatedAt() |

### Example (as JSON)

```json
{
  "order_id": "order_id6",
  "version": 172,
  "location_id": "location_id4",
  "state": "CANCELED",
  "created_at": "created_at2"
}
```

