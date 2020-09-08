## V1 Page

V1Page

### Structure

`V1Page`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The page's unique identifier. | String getId() |
| `Name` | `String` | Optional | The page's name, if any. | String getName() |
| `PageIndex` | `Integer` | Optional | The page's position in the merchant's list of pages. Always an integer between 0 and 6, inclusive. | Integer getPageIndex() |
| `Cells` | [`List<V1PageCell>`](/doc/models/v1-page-cell.md) | Optional | The cells included on the page. | List<V1PageCell> getCells() |

### Example (as JSON)

```json
{
  "id": "id0",
  "name": "name0",
  "page_index": 216,
  "cells": [
    {
      "page_id": "page_id2",
      "row": 10,
      "column": 72,
      "object_type": "ITEM",
      "object_id": "object_id0"
    },
    {
      "page_id": "page_id3",
      "row": 9,
      "column": 73,
      "object_type": "DISCOUNT",
      "object_id": "object_id1"
    },
    {
      "page_id": "page_id4",
      "row": 8,
      "column": 74,
      "object_type": "CATEGORY",
      "object_id": "object_id2"
    }
  ]
}
```

