## Catalog Item Variation

An item variation (i.e., product) in the Catalog object model. Each item
may have a maximum of 250 item variations.

### Structure

`CatalogItemVariation`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `ItemId` | `String` | Optional | The ID of the `CatalogItem` associated with this item variation. | String getItemId() |
| `Name` | `String` | Optional | The item variation's name. This is a searchable attribute for use in applicable query filters, and its value length is of Unicode code points. | String getName() |
| `Sku` | `String` | Optional | The item variation's SKU, if any. This is a searchable attribute for use in applicable query filters. | String getSku() |
| `Upc` | `String` | Optional | The item variation's UPC, if any. This is a searchable attribute for use in applicable query filters.<br>It is only accessible through the Square API, and not exposed in the Square Seller Dashboard,<br>Square Point of Sale or Retail Point of Sale apps. | String getUpc() |
| `Ordinal` | `Integer` | Optional | The order in which this item variation should be displayed. This value is read-only. On writes, the ordinal<br>for each item variation within a parent `CatalogItem` is set according to the item variations's<br>position. On reads, the value is not guaranteed to be sequential or unique. | Integer getOrdinal() |
| `PricingType` | [`String`](/doc/models/catalog-pricing-type.md) | Optional | Indicates whether the price of a CatalogItemVariation should be entered manually at the time of sale. | String getPricingType() |
| `PriceMoney` | [`Money`](/doc/models/money.md) | Optional | Represents an amount of money. `Money` fields can be signed or unsigned.<br>Fields that do not explicitly define whether they are signed or unsigned are<br>considered unsigned and can only hold positive amounts. For signed fields, the<br>sign of the value indicates the purpose of the money transfer. See<br>[Working with Monetary Amounts](https://developer.squareup.com/docs/build-basics/working-with-monetary-amounts)<br>for more information. | Money getPriceMoney() |
| `LocationOverrides` | [`List<ItemVariationLocationOverrides>`](/doc/models/item-variation-location-overrides.md) | Optional | Per-location price and inventory overrides. | List<ItemVariationLocationOverrides> getLocationOverrides() |
| `TrackInventory` | `Boolean` | Optional | If `true`, inventory tracking is active for the variation. | Boolean getTrackInventory() |
| `InventoryAlertType` | [`String`](/doc/models/inventory-alert-type.md) | Optional | Indicates whether Square should alert the merchant when the inventory quantity of a CatalogItemVariation is low. | String getInventoryAlertType() |
| `InventoryAlertThreshold` | `Long` | Optional | If the inventory quantity for the variation is less than or equal to this value and `inventory_alert_type`<br>is `LOW_QUANTITY`, the variation displays an alert in the merchant dashboard.<br><br>This value is always an integer. | Long getInventoryAlertThreshold() |
| `UserData` | `String` | Optional | Arbitrary user metadata to associate with the item variation. This attribute value length is of Unicode code points. | String getUserData() |
| `ServiceDuration` | `Long` | Optional | If the `CatalogItem` that owns this item variation is of type<br>`APPOINTMENTS_SERVICE`, then this is the duration of the service in milliseconds. For<br>example, a 30 minute appointment would have the value `1800000`, which is equal to<br>30 (minutes) * 60 (seconds per minute) * 1000 (milliseconds per second). | Long getServiceDuration() |
| `ItemOptionValues` | [`List<CatalogItemOptionValueForItemVariation>`](/doc/models/catalog-item-option-value-for-item-variation.md) | Optional | List of item option values associated with this item variation. Listed<br>in the same order as the item options of the parent item. | List<CatalogItemOptionValueForItemVariation> getItemOptionValues() |
| `MeasurementUnitId` | `String` | Optional | ID of the ‘CatalogMeasurementUnit’ that is used to measure the quantity<br>sold of this item variation. If left unset, the item will be sold in<br>whole quantities. | String getMeasurementUnitId() |

### Example (as JSON)

```json
{
  "item_id": "item_id0",
  "name": "name0",
  "sku": "sku4",
  "upc": "upc2",
  "ordinal": 80
}
```

