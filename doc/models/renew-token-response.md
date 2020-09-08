## Renew Token Response

### Structure

`RenewTokenResponse`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `AccessToken` | `String` | Optional | The renewed access token.<br>This value might be different from the `access_token` you provided in your request.<br>You provide this token in a header with every request to Connect API endpoints.<br>See [Request and response headers](https://developer.squareup.com/docs/api/connect/v2/#requestandresponseheaders) for the format of this header. | String getAccessToken() |
| `TokenType` | `String` | Optional | This value is always _bearer_. | String getTokenType() |
| `ExpiresAt` | `String` | Optional | The date when access_token expires, in [ISO 8601](http://www.iso.org/iso/home/standards/iso8601.htm) format. | String getExpiresAt() |
| `MerchantId` | `String` | Optional | The ID of the authorizing merchant's business. | String getMerchantId() |
| `SubscriptionId` | `String` | Optional | __LEGACY FIELD__. The ID of the merchant subscription associated with<br>the authorization. Only present if the merchant signed up for a subscription<br>during authorization.. | String getSubscriptionId() |
| `PlanId` | `String` | Optional | __LEGACY FIELD__. The ID of the subscription plan the merchant signed<br>up for. Only present if the merchant signed up for a subscription during<br>authorization. | String getPlanId() |

### Example (as JSON)

```json
{
  "access_token": "ACCESS_TOKEN",
  "token_type": "bearer",
  "expires_at": "2006-01-02T15:04:05Z",
  "merchant_id": "MERCHANT_ID"
}
```

