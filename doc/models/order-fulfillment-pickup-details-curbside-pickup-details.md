## Order Fulfillment Pickup Details Curbside Pickup Details

Specific details for curbside pickup.

### Structure

`OrderFulfillmentPickupDetailsCurbsidePickupDetails`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `CurbsideDetails` | `String` | Optional | Specific details for curbside pickup, such as parking number, vehicle model, etc. | String getCurbsideDetails() |
| `BuyerArrivedAt` | `String` | Optional | The [timestamp](#workingwithdates) in RFC 3339 timestamp format, e.g., "2016-09-04T23:59:33.123Z",<br>indicating when the buyer arrived and is waiting for pickup. | String getBuyerArrivedAt() |

### Example (as JSON)

```json
{
  "curbside_details": "curbside_details6",
  "buyer_arrived_at": "buyer_arrived_at2"
}
```

