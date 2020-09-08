## Retrieve Inventory Count Request

### Structure

`RetrieveInventoryCountRequest`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `LocationIds` | `String` | Optional | The [Location](#type-location) IDs to look up as a comma-separated<br>list. An empty list queries all locations. | String getLocationIds() |
| `Cursor` | `String` | Optional | A pagination cursor returned by a previous call to this endpoint.<br>Provide this to retrieve the next set of results for the original query.<br><br>See the [Pagination](https://developer.squareup.com/docs/docs/working-with-apis/pagination) guide for more information. | String getCursor() |

### Example (as JSON)

```json
{
  "location_ids": "location_ids0",
  "cursor": "cursor6"
}
```
