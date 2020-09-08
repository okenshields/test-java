## Adjust Loyalty Points Request

A request to adjust (add or subtract) points manually.

### Structure

`AdjustLoyaltyPointsRequest`

### Fields

| Name | Type | Description | Getter |
|  --- | --- | --- | --- |
| `IdempotencyKey` | `String` | A unique string that identifies this `AdjustLoyaltyPoints` request. <br>Keys can be any valid string, but must be unique for every request. | String getIdempotencyKey() |
| `AdjustPoints` | [`LoyaltyEventAdjustPoints`](/doc/models/loyalty-event-adjust-points.md) | Provides metadata when the event `type` is `ADJUST_POINTS`. | LoyaltyEventAdjustPoints getAdjustPoints() |

### Example (as JSON)

```json
{
  "idempotency_key": "idempotency_key6",
  "adjust_points": {
    "loyalty_program_id": "loyalty_program_id2",
    "points": 96,
    "reason": "reason2"
  }
}
```

