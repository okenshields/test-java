## Upsert Catalog Object Request

### Structure

`UpsertCatalogObjectRequest`

### Fields

| Name | Type | Description | Getter |
|  --- | --- | --- | --- |
| `IdempotencyKey` | `String` | A value you specify that uniquely identifies this<br>request among all your requests. A common way to create<br>a valid idempotency key is to use a Universally unique<br>identifier (UUID).<br><br>If you're unsure whether a particular request was successful,<br>you can reattempt it with the same idempotency key without<br>worrying about creating duplicate objects.<br><br>See [Idempotency](https://developer.squareup.com/docs/basics/api101/idempotency) for more information. | String getIdempotencyKey() |
| `Object` | [`CatalogObject`](/doc/models/catalog-object.md) | - | CatalogObject getObject() |

### Example (as JSON)

```json
{
  "idempotency_key": "af3d1afc-7212-4300-b463-0bfc5314a5ae",
  "object": {
    "type": "ITEM",
    "id": "#Cocoa",
    "item_data": {
      "name": "Cocoa",
      "description": "Hot chocolate",
      "abbreviation": "Ch"
    }
  }
}
```

