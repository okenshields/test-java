## Create Break Type Request

A request to create a new `BreakType`

### Structure

`CreateBreakTypeRequest`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `IdempotencyKey` | `String` | Optional | Unique string value to insure idempotency of the operation | String getIdempotencyKey() |
| `BreakType` | [`BreakType`](/doc/models/break-type.md) |  | A defined break template that sets an expectation for possible `Break`<br>instances on a `Shift`. | BreakType getBreakType() |

### Example (as JSON)

```json
{
  "idempotency_key": "PAD3NG5KSN2GL",
  "break_type": {
    "location_id": "CGJN03P1D08GF",
    "break_name": "Lunch Break",
    "expected_duration": "PT30M",
    "is_paid": true
  }
}
```

