## Create Customer Request

Defines the body parameters that can be provided in a request to the
CreateCustomer endpoint.

### Structure

`CreateCustomerRequest`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `IdempotencyKey` | `String` | Optional | The idempotency key for the request. See the<br>[Idempotency](https://developer.squareup.com/docs/working-with-apis/idempotency) guide for more information. | String getIdempotencyKey() |
| `GivenName` | `String` | Optional | The given (i.e., first) name associated with the customer profile. | String getGivenName() |
| `FamilyName` | `String` | Optional | The family (i.e., last) name associated with the customer profile. | String getFamilyName() |
| `CompanyName` | `String` | Optional | A business name associated with the customer profile. | String getCompanyName() |
| `Nickname` | `String` | Optional | A nickname for the customer profile. | String getNickname() |
| `EmailAddress` | `String` | Optional | The email address associated with the customer profile. | String getEmailAddress() |
| `Address` | [`Address`](/doc/models/address.md) | Optional | Represents a physical address. | Address getAddress() |
| `PhoneNumber` | `String` | Optional | The 11-digit phone number associated with the customer profile. | String getPhoneNumber() |
| `ReferenceId` | `String` | Optional | An optional, second ID used to associate the customer profile with an<br>entity in another system. | String getReferenceId() |
| `Note` | `String` | Optional | A custom note associated with the customer profile. | String getNote() |
| `Birthday` | `String` | Optional | The birthday associated with the customer profile, in RFC-3339 format.<br>Year is optional, timezone and times are not allowed.<br>For example: `0000-09-01T00:00:00-00:00` indicates a birthday on September 1st.<br>`1998-09-01T00:00:00-00:00` indications a birthday on September 1st __1998__. | String getBirthday() |

### Example (as JSON)

```json
{
  "given_name": "Amelia",
  "family_name": "Earhart",
  "email_address": "Amelia.Earhart@example.com",
  "address": {
    "address_line_1": "500 Electric Ave",
    "address_line_2": "Suite 600",
    "locality": "New York",
    "administrative_district_level_1": "NY",
    "postal_code": "10003",
    "country": "US"
  },
  "phone_number": "1-212-555-4240",
  "reference_id": "YOUR_REFERENCE_ID",
  "note": "a customer"
}
```

