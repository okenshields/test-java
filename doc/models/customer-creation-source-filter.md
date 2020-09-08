## Customer Creation Source Filter

Creation source filter.

If one or more creation sources are set, customer profiles are included in,
or excluded from, the result if they match at least one of the filter
criteria.

### Structure

`CustomerCreationSourceFilter`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Values` | [`List<String>`](/doc/models/customer-creation-source.md) | Optional | The list of creation sources used as filtering criteria.<br>See [CustomerCreationSource](#type-customercreationsource) for possible values | List<String> getValues() |
| `Rule` | [`String`](/doc/models/customer-inclusion-exclusion.md) | Optional | Indicates whether customers should be included in, or excluded from,<br>the result set when they match the filtering criteria. | String getRule() |

### Example (as JSON)

```json
{
  "values": [
    "INSTANT_PROFILE",
    "TERMINAL",
    "THIRD_PARTY"
  ],
  "rule": "INCLUDE"
}
```

