## Update Break Type Request

A request to update a `BreakType`

### Structure

`UpdateBreakTypeRequest`

### Fields

| Name | Type | Description | Getter |
|  --- | --- | --- | --- |
| `BreakType` | [`BreakType`](/doc/models/break-type.md) | A defined break template that sets an expectation for possible `Break`<br>instances on a `Shift`. | BreakType getBreakType() |

### Example (as JSON)

```json
{
  "break_type": {
    "location_id": "26M7H24AZ9N6R",
    "break_name": "Lunch",
    "expected_duration": "PT50M",
    "is_paid": true,
    "version": 1
  }
}
```

