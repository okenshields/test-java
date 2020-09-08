## Workweek Config

Sets the Day of the week and hour of the day that a business starts a
work week. Used for the calculation of overtime pay.

### Structure

`WorkweekConfig`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | UUID for this object | String getId() |
| `StartOfWeek` | [`String`](/doc/models/weekday.md) |  | The days of the week. | String getStartOfWeek() |
| `StartOfDayLocalTime` | `String` |  | The local time at which a business week cuts over. Represented as a<br>string in `HH:MM` format (`HH:MM:SS` is also accepted, but seconds are<br>truncated). | String getStartOfDayLocalTime() |
| `Version` | `Integer` | Optional | Used for resolving concurrency issues; request will fail if version<br>provided does not match server version at time of request. If not provided,<br>Square executes a blind write; potentially overwriting data from another<br>write. | Integer getVersion() |
| `CreatedAt` | `String` | Optional | A read-only timestamp in RFC 3339 format; presented in UTC | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | A read-only timestamp in RFC 3339 format; presented in UTC | String getUpdatedAt() |

### Example (as JSON)

```json
{
  "id": "id0",
  "start_of_week": "MON",
  "start_of_day_local_time": "start_of_day_local_time6",
  "version": 172,
  "created_at": "created_at2",
  "updated_at": "updated_at4"
}
```

