# Locations

```java
LocationsApi locationsApi = client.getLocationsApi();
```

## Class Name

`LocationsApi`

## Methods

* [List Locations](/doc/locations.md#list-locations)
* [Create Location](/doc/locations.md#create-location)
* [Retrieve Location](/doc/locations.md#retrieve-location)
* [Update Location](/doc/locations.md#update-location)

## List Locations

Provides information of all locations of a business.

Most other Connect API endpoints have a required `location_id` path parameter.
The `id` field of the [`Location`](#type-location) objects returned by this
endpoint correspond to that `location_id` parameter.

```java
CompletableFuture<ListLocationsResponse> listLocationsAsync()
```

### Response Type

[`ListLocationsResponse`](/doc/models/list-locations-response.md)

### Example Usage

```java
locationsApi.listLocationsAsync().thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Location

Creates a location.
For more information about locations, see [Locations API Overview](https://developer.squareup.com/docs/locations-api).

```java
CompletableFuture<CreateLocationResponse> createLocationAsync(
    final CreateLocationRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateLocationRequest`](/doc/models/create-location-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`CreateLocationResponse`](/doc/models/create-location-response.md)

### Example Usage

```java
Address bodyLocationAddress = new Address.Builder()
    .addressLine1("1234 Peachtree St. NE")
    .addressLine2("address_line_26")
    .addressLine3("address_line_32")
    .locality("Atlanta")
    .sublocality("sublocality6")
    .administrativeDistrictLevel1("GA")
    .postalCode("30309")
    .build();
List<String> bodyLocationCapabilities = new LinkedList<>();
bodyLocationCapabilities.add("CREDIT_CARD_PROCESSING");
bodyLocationCapabilities.add("CREDIT_CARD_PROCESSING");
bodyLocationCapabilities.add("CREDIT_CARD_PROCESSING");
Location bodyLocation = new Location.Builder()
    .id("id0")
    .name("New location name")
    .address(bodyLocationAddress)
    .timezone("timezone0")
    .capabilities(bodyLocationCapabilities)
    .description("My new location.")
    .facebookUrl("null")
    .build();
CreateLocationRequest body = new CreateLocationRequest.Builder()
    .location(bodyLocation)
    .build();

locationsApi.createLocationAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Location

Retrieves details of a location. You can specify "main" 
as the location ID to retrieve details of the 
main location. For more information, 
see [Locations API Overview](https://developer.squareup.com/docs/docs/locations-api).

```java
CompletableFuture<RetrieveLocationResponse> retrieveLocationAsync(
    final String locationId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to retrieve. If you specify the string "main",<br>then the endpoint returns the main location. |

### Response Type

[`RetrieveLocationResponse`](/doc/models/retrieve-location-response.md)

### Example Usage

```java
String locationId = "location_id4";

locationsApi.retrieveLocationAsync(locationId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Update Location

Updates a location.

```java
CompletableFuture<UpdateLocationResponse> updateLocationAsync(
    final String locationId,
    final UpdateLocationRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `locationId` | `String` | Template, Required | The ID of the location to update. |
| `body` | [`UpdateLocationRequest`](/doc/models/update-location-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`UpdateLocationResponse`](/doc/models/update-location-response.md)

### Example Usage

```java
String locationId = "location_id4";
Address bodyLocationAddress = new Address.Builder()
    .addressLine1("1234 Peachtree St. NE")
    .addressLine2("address_line_26")
    .addressLine3("address_line_32")
    .locality("Atlanta")
    .sublocality("sublocality6")
    .administrativeDistrictLevel1("GA")
    .postalCode("30309")
    .build();
List<String> bodyLocationCapabilities = new LinkedList<>();
bodyLocationCapabilities.add("CREDIT_CARD_PROCESSING");
bodyLocationCapabilities.add("CREDIT_CARD_PROCESSING");
bodyLocationCapabilities.add("CREDIT_CARD_PROCESSING");
List<BusinessHoursPeriod> bodyLocationBusinessHoursPeriods = new LinkedList<>();

BusinessHoursPeriod bodyLocationBusinessHoursPeriods0 = new BusinessHoursPeriod.Builder()
    .dayOfWeek("MON")
    .startLocalTime("09:00")
    .endLocalTime("17:00")
    .build();
bodyLocationBusinessHoursPeriods.add(bodyLocationBusinessHoursPeriods0);

BusinessHours bodyLocationBusinessHours = new BusinessHours.Builder()
    .periods(bodyLocationBusinessHoursPeriods)
    .build();
Location bodyLocation = new Location.Builder()
    .id("id0")
    .name("Updated nickname")
    .address(bodyLocationAddress)
    .timezone("timezone0")
    .capabilities(bodyLocationCapabilities)
    .businessHours(bodyLocationBusinessHours)
    .description("Updated description")
    .twitterUsername("twitter")
    .instagramUsername("instagram")
    .facebookUrl("null")
    .build();
UpdateLocationRequest body = new UpdateLocationRequest.Builder()
    .location(bodyLocation)
    .build();

locationsApi.updateLocationAsync(locationId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

