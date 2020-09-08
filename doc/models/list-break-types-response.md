## List Break Types Response

The response to a request for a set of `BreakTypes`. Contains
the requested `BreakType` objects. May contain a set of `Error` objects if
the request resulted in errors.

### Structure

`ListBreakTypesResponse`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `BreakTypes` | [`List<BreakType>`](/doc/models/break-type.md) | Optional | A page of `BreakType` results. | List<BreakType> getBreakTypes() |
| `Cursor` | `String` | Optional | Value supplied in the subsequent request to fetch the next next page<br>of Break Type results. | String getCursor() |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |

### Example (as JSON)

```json
{
  "break_types": [
    {
      "id": "REGS1EQR1TPZ5",
      "location_id": "PAA1RJZZKXBFG",
      "break_name": "Coffee Break",
      "expected_duration": "PT5M",
      "is_paid": false,
      "version": 1,
      "created_at": "2019-01-22T20:47:37Z",
      "updated_at": "2019-01-22T20:47:37Z"
    },
    {
      "id": "92EPDRQKJ5088",
      "location_id": "PAA1RJZZKXBFG",
      "break_name": "Lunch Break",
      "expected_duration": "PT1H",
      "is_paid": true,
      "version": 3,
      "created_at": "2019-01-25T19:26:30Z",
      "updated_at": "2019-01-25T19:26:30Z"
    }
  ],
  "cursor": "2fofTniCgT0yIPAq26kmk0YyFQJZfbWkh73OOnlTHmTAx13NgED"
}
```

