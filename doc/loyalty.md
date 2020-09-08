# Loyalty

```java
LoyaltyApi loyaltyApi = client.getLoyaltyApi();
```

## Class Name

`LoyaltyApi`

## Methods

* [Create Loyalty Account](/doc/loyalty.md#create-loyalty-account)
* [Search Loyalty Accounts](/doc/loyalty.md#search-loyalty-accounts)
* [Retrieve Loyalty Account](/doc/loyalty.md#retrieve-loyalty-account)
* [Accumulate Loyalty Points](/doc/loyalty.md#accumulate-loyalty-points)
* [Adjust Loyalty Points](/doc/loyalty.md#adjust-loyalty-points)
* [Search Loyalty Events](/doc/loyalty.md#search-loyalty-events)
* [List Loyalty Programs](/doc/loyalty.md#list-loyalty-programs)
* [Calculate Loyalty Points](/doc/loyalty.md#calculate-loyalty-points)
* [Create Loyalty Reward](/doc/loyalty.md#create-loyalty-reward)
* [Search Loyalty Rewards](/doc/loyalty.md#search-loyalty-rewards)
* [Delete Loyalty Reward](/doc/loyalty.md#delete-loyalty-reward)
* [Retrieve Loyalty Reward](/doc/loyalty.md#retrieve-loyalty-reward)
* [Redeem Loyalty Reward](/doc/loyalty.md#redeem-loyalty-reward)

## Create Loyalty Account

Creates a loyalty account. For more information, see 
[Create a loyalty account](https://developer.squareup.com/docs/docs/loyalty-api/overview/#loyalty-overview-create-account).

```java
CompletableFuture<CreateLoyaltyAccountResponse> createLoyaltyAccountAsync(
    final CreateLoyaltyAccountRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateLoyaltyAccountRequest`](/doc/models/create-loyalty-account-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`CreateLoyaltyAccountResponse`](/doc/models/create-loyalty-account-response.md)

### Example Usage

```java
List<LoyaltyAccountMapping> bodyLoyaltyAccountMappings = new LinkedList<>();

LoyaltyAccountMapping bodyLoyaltyAccountMappings0 = new LoyaltyAccountMapping.Builder(
        "PHONE",
        "+14155551234")
    .id("id0")
    .createdAt("created_at8")
    .build();
bodyLoyaltyAccountMappings.add(bodyLoyaltyAccountMappings0);

LoyaltyAccount bodyLoyaltyAccount = new LoyaltyAccount.Builder(
        bodyLoyaltyAccountMappings,
        "d619f755-2d17-41f3-990d-c04ecedd64dd")
    .id("id2")
    .balance(14)
    .lifetimePoints(38)
    .customerId("customer_id0")
    .enrolledAt("enrolled_at2")
    .build();
CreateLoyaltyAccountRequest body = new CreateLoyaltyAccountRequest.Builder(
        bodyLoyaltyAccount,
        "ec78c477-b1c3-4899-a209-a4e71337c996")
    .build();

loyaltyApi.createLoyaltyAccountAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Search Loyalty Accounts

Searches for loyalty accounts. 
In the current implementation, you can search for a loyalty account using the phone number associated with the account. 
If no phone number is provided, all loyalty accounts are returned.

```java
CompletableFuture<SearchLoyaltyAccountsResponse> searchLoyaltyAccountsAsync(
    final SearchLoyaltyAccountsRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchLoyaltyAccountsRequest`](/doc/models/search-loyalty-accounts-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`SearchLoyaltyAccountsResponse`](/doc/models/search-loyalty-accounts-response.md)

### Example Usage

```java
List<LoyaltyAccountMapping> bodyQueryMappings = new LinkedList<>();

LoyaltyAccountMapping bodyQueryMappings0 = new LoyaltyAccountMapping.Builder(
        "PHONE",
        "+14155551234")
    .id("id4")
    .createdAt("created_at8")
    .build();
bodyQueryMappings.add(bodyQueryMappings0);

SearchLoyaltyAccountsRequestLoyaltyAccountQuery bodyQuery = new SearchLoyaltyAccountsRequestLoyaltyAccountQuery.Builder()
    .mappings(bodyQueryMappings)
    .build();
SearchLoyaltyAccountsRequest body = new SearchLoyaltyAccountsRequest.Builder()
    .query(bodyQuery)
    .limit(10)
    .cursor("cursor0")
    .build();

loyaltyApi.searchLoyaltyAccountsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Loyalty Account

Retrieves a loyalty account.

```java
CompletableFuture<RetrieveLoyaltyAccountResponse> retrieveLoyaltyAccountAsync(
    final String accountId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `accountId` | `String` | Template, Required | The ID of the [loyalty account](#type-LoyaltyAccount) to retrieve. |

### Response Type

[`RetrieveLoyaltyAccountResponse`](/doc/models/retrieve-loyalty-account-response.md)

### Example Usage

```java
String accountId = "account_id2";

loyaltyApi.retrieveLoyaltyAccountAsync(accountId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Accumulate Loyalty Points

Adds points to a loyalty account.

- If you are using the Orders API to manage orders, you only provide the `order_id`. 
The endpoint reads the order to compute points to add to the buyer's account.
- If you are not using the Orders API to manage orders, 
you first perform a client-side computation to compute the points.  
For spend-based and visit-based programs, you can call 
`CalculateLoyaltyPoints` to compute the points. For more information, 
see [Loyalty Program Overview](https://developer.squareup.com/docs/docs/loyalty/overview). 
You then provide the points in a request to this endpoint. 

For more information, see [Accumulate points](https://developer.squareup.com/docs/docs/loyalty-api/overview/#accumulate-points).

```java
CompletableFuture<AccumulateLoyaltyPointsResponse> accumulateLoyaltyPointsAsync(
    final String accountId,
    final AccumulateLoyaltyPointsRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `accountId` | `String` | Template, Required | The [loyalty account](#type-LoyaltyAccount) ID to which to add the points. |
| `body` | [`AccumulateLoyaltyPointsRequest`](/doc/models/accumulate-loyalty-points-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`AccumulateLoyaltyPointsResponse`](/doc/models/accumulate-loyalty-points-response.md)

### Example Usage

```java
String accountId = "account_id2";
LoyaltyEventAccumulatePoints bodyAccumulatePoints = new LoyaltyEventAccumulatePoints.Builder()
    .loyaltyProgramId("loyalty_program_id8")
    .points(90)
    .orderId("RFZfrdtm3mhO1oGzf5Cx7fEMsmGZY")
    .build();
AccumulateLoyaltyPointsRequest body = new AccumulateLoyaltyPointsRequest.Builder(
        bodyAccumulatePoints,
        "58b90739-c3e8-4b11-85f7-e636d48d72cb",
        "P034NEENMD09F")
    .build();

loyaltyApi.accumulateLoyaltyPointsAsync(accountId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Adjust Loyalty Points

Adds points to or subtracts points from a buyer's account. 

Use this endpoint only when you need to manually adjust points. Otherwise, in your application flow, you call 
[AccumulateLoyaltyPoints](https://developer.squareup.com/docs/reference/square/loyalty-api/accumulate-loyalty-points) 
to add points when a buyer pays for the purchase.

```java
CompletableFuture<AdjustLoyaltyPointsResponse> adjustLoyaltyPointsAsync(
    final String accountId,
    final AdjustLoyaltyPointsRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `accountId` | `String` | Template, Required | The ID of the [loyalty account](#type-LoyaltyAccount) in which to adjust the points. |
| `body` | [`AdjustLoyaltyPointsRequest`](/doc/models/adjust-loyalty-points-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`AdjustLoyaltyPointsResponse`](/doc/models/adjust-loyalty-points-response.md)

### Example Usage

```java
String accountId = "account_id2";
LoyaltyEventAdjustPoints bodyAdjustPoints = new LoyaltyEventAdjustPoints.Builder(
        112)
    .loyaltyProgramId("loyalty_program_id4")
    .reason("reason0")
    .build();
AdjustLoyaltyPointsRequest body = new AdjustLoyaltyPointsRequest.Builder(
        "idempotency_key2",
        bodyAdjustPoints)
    .build();

loyaltyApi.adjustLoyaltyPointsAsync(accountId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Search Loyalty Events

Searches for loyalty events.

A Square loyalty program maintains a ledger of events that occur during the lifetime of a 
buyer's loyalty account. Each change in the point balance 
(for example, points earned, points redeemed, and points expired) is 
recorded in the ledger. Using this endpoint, you can search the ledger for events. 
For more information, see 
[Loyalty events](https://developer.squareup.com/docs/docs/loyalty-api/overview/#loyalty-events).

```java
CompletableFuture<SearchLoyaltyEventsResponse> searchLoyaltyEventsAsync(
    final SearchLoyaltyEventsRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchLoyaltyEventsRequest`](/doc/models/search-loyalty-events-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`SearchLoyaltyEventsResponse`](/doc/models/search-loyalty-events-response.md)

### Example Usage

```java
LoyaltyEventLoyaltyAccountFilter bodyQueryFilterLoyaltyAccountFilter = new LoyaltyEventLoyaltyAccountFilter.Builder(
        "loyalty_account_id6")
    .build();
List<String> bodyQueryFilterTypeFilterTypes = new LinkedList<>();
bodyQueryFilterTypeFilterTypes.add("DELETE_REWARD");
bodyQueryFilterTypeFilterTypes.add("ADJUST_POINTS");
bodyQueryFilterTypeFilterTypes.add("EXPIRE_POINTS");
LoyaltyEventTypeFilter bodyQueryFilterTypeFilter = new LoyaltyEventTypeFilter.Builder(
        bodyQueryFilterTypeFilterTypes)
    .build();
TimeRange bodyQueryFilterDateTimeFilterCreatedAt = new TimeRange.Builder()
    .startAt("start_at8")
    .endAt("end_at4")
    .build();
LoyaltyEventDateTimeFilter bodyQueryFilterDateTimeFilter = new LoyaltyEventDateTimeFilter.Builder(
        bodyQueryFilterDateTimeFilterCreatedAt)
    .build();
List<String> bodyQueryFilterLocationFilterLocationIds = new LinkedList<>();
bodyQueryFilterLocationFilterLocationIds.add("location_ids2");
bodyQueryFilterLocationFilterLocationIds.add("location_ids3");
bodyQueryFilterLocationFilterLocationIds.add("location_ids4");
LoyaltyEventLocationFilter bodyQueryFilterLocationFilter = new LoyaltyEventLocationFilter.Builder(
        bodyQueryFilterLocationFilterLocationIds)
    .build();
LoyaltyEventOrderFilter bodyQueryFilterOrderFilter = new LoyaltyEventOrderFilter.Builder(
        "PyATxhYLfsMqpVkcKJITPydgEYfZY")
    .build();
LoyaltyEventFilter bodyQueryFilter = new LoyaltyEventFilter.Builder()
    .loyaltyAccountFilter(bodyQueryFilterLoyaltyAccountFilter)
    .typeFilter(bodyQueryFilterTypeFilter)
    .dateTimeFilter(bodyQueryFilterDateTimeFilter)
    .locationFilter(bodyQueryFilterLocationFilter)
    .orderFilter(bodyQueryFilterOrderFilter)
    .build();
LoyaltyEventQuery bodyQuery = new LoyaltyEventQuery.Builder()
    .filter(bodyQueryFilter)
    .build();
SearchLoyaltyEventsRequest body = new SearchLoyaltyEventsRequest.Builder()
    .query(bodyQuery)
    .limit(30)
    .cursor("cursor0")
    .build();

loyaltyApi.searchLoyaltyEventsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## List Loyalty Programs

Returns a list of loyalty programs in the seller's account.
Currently, a seller can only have one loyalty program. For more information, see 
[Loyalty Overview](https://developer.squareup.com/docs/docs/loyalty/overview).
.

```java
CompletableFuture<ListLoyaltyProgramsResponse> listLoyaltyProgramsAsync()
```

### Response Type

[`ListLoyaltyProgramsResponse`](/doc/models/list-loyalty-programs-response.md)

### Example Usage

```java
loyaltyApi.listLoyaltyProgramsAsync().thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Calculate Loyalty Points

Calculates the points a purchase earns.

- If you are using the Orders API to manage orders, you provide `order_id` in the request. The 
endpoint calculates the points by reading the order.
- If you are not using the Orders API to manage orders, you provide the purchase amount in 
the request for the endpoint to calculate the points.

An application might call this endpoint to show the points that a buyer can earn with the 
specific purchase.

```java
CompletableFuture<CalculateLoyaltyPointsResponse> calculateLoyaltyPointsAsync(
    final String programId,
    final CalculateLoyaltyPointsRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `programId` | `String` | Template, Required | The [loyalty program](#type-LoyaltyProgram) ID, which defines the rules for accruing points. |
| `body` | [`CalculateLoyaltyPointsRequest`](/doc/models/calculate-loyalty-points-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`CalculateLoyaltyPointsResponse`](/doc/models/calculate-loyalty-points-response.md)

### Example Usage

```java
String programId = "program_id0";
Money bodyTransactionAmountMoney = new Money.Builder()
    .amount(72L)
    .currency("UZS")
    .build();
CalculateLoyaltyPointsRequest body = new CalculateLoyaltyPointsRequest.Builder()
    .orderId("RFZfrdtm3mhO1oGzf5Cx7fEMsmGZY")
    .transactionAmountMoney(bodyTransactionAmountMoney)
    .build();

loyaltyApi.calculateLoyaltyPointsAsync(programId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Create Loyalty Reward

Creates a loyalty reward. In the process, the endpoint does following:

- Uses the `reward_tier_id` in the request to determine the number of points 
to lock for this reward. 
- If the request includes `order_id`, it adds the reward and related discount to the order. 

After a reward is created, the points are locked and 
not available for the buyer to redeem another reward. 
For more information, see 
[Loyalty rewards](https://developer.squareup.com/docs/docs/loyalty-api/overview/#loyalty-overview-loyalty-rewards).

```java
CompletableFuture<CreateLoyaltyRewardResponse> createLoyaltyRewardAsync(
    final CreateLoyaltyRewardRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`CreateLoyaltyRewardRequest`](/doc/models/create-loyalty-reward-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`CreateLoyaltyRewardResponse`](/doc/models/create-loyalty-reward-response.md)

### Example Usage

```java
LoyaltyReward bodyReward = new LoyaltyReward.Builder(
        "5adcb100-07f1-4ee7-b8c6-6bb9ebc474bd",
        "e1b39225-9da5-43d1-a5db-782cdd8ad94f")
    .id("id4")
    .status("REDEEMED")
    .points(230)
    .orderId("RFZfrdtm3mhO1oGzf5Cx7fEMsmGZY")
    .createdAt("created_at2")
    .build();
CreateLoyaltyRewardRequest body = new CreateLoyaltyRewardRequest.Builder(
        bodyReward,
        "18c2e5ea-a620-4b1f-ad60-7b167285e451")
    .build();

loyaltyApi.createLoyaltyRewardAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Search Loyalty Rewards

Searches for loyalty rewards in a loyalty account. 

In the current implementation, the endpoint supports search by the reward `status`.

If you know a reward ID, use the 
[RetrieveLoyaltyReward](https://developer.squareup.com/docs/reference/square/loyalty-api/retrieve-loyalty-reward) endpoint.

For more information about loyalty rewards, see 
[Loyalty Rewards](https://developer.squareup.com/docs/docs/loyalty-api/overview/#loyalty-rewards).

```java
CompletableFuture<SearchLoyaltyRewardsResponse> searchLoyaltyRewardsAsync(
    final SearchLoyaltyRewardsRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `body` | [`SearchLoyaltyRewardsRequest`](/doc/models/search-loyalty-rewards-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`SearchLoyaltyRewardsResponse`](/doc/models/search-loyalty-rewards-response.md)

### Example Usage

```java
SearchLoyaltyRewardsRequestLoyaltyRewardQuery bodyQuery = new SearchLoyaltyRewardsRequestLoyaltyRewardQuery.Builder(
        "5adcb100-07f1-4ee7-b8c6-6bb9ebc474bd")
    .status("REDEEMED")
    .build();
SearchLoyaltyRewardsRequest body = new SearchLoyaltyRewardsRequest.Builder()
    .query(bodyQuery)
    .limit(10)
    .cursor("cursor0")
    .build();

loyaltyApi.searchLoyaltyRewardsAsync(body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Delete Loyalty Reward

Deletes a loyalty reward by doing the following:

- Returns the loyalty points back to the loyalty account.
- If an order ID was specified when the reward was created 
(see [CreateLoyaltyReward](https://developer.squareup.com/docs/reference/square/loyalty-api/create-loyalty-reward)), 
it updates the order by removing the reward and related 
discounts.

You cannot delete a reward that has reached the terminal state (REDEEMED). 
For more information, see 
[Loyalty rewards](https://developer.squareup.com/docs/docs/loyalty-api/overview/#loyalty-overview-loyalty-rewards).

```java
CompletableFuture<DeleteLoyaltyRewardResponse> deleteLoyaltyRewardAsync(
    final String rewardId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `rewardId` | `String` | Template, Required | The ID of the [loyalty reward](#type-LoyaltyReward) to delete. |

### Response Type

[`DeleteLoyaltyRewardResponse`](/doc/models/delete-loyalty-reward-response.md)

### Example Usage

```java
String rewardId = "reward_id4";

loyaltyApi.deleteLoyaltyRewardAsync(rewardId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Retrieve Loyalty Reward

Retrieves a loyalty reward.

```java
CompletableFuture<RetrieveLoyaltyRewardResponse> retrieveLoyaltyRewardAsync(
    final String rewardId)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `rewardId` | `String` | Template, Required | The ID of the [loyalty reward](#type-LoyaltyReward) to retrieve. |

### Response Type

[`RetrieveLoyaltyRewardResponse`](/doc/models/retrieve-loyalty-reward-response.md)

### Example Usage

```java
String rewardId = "reward_id4";

loyaltyApi.retrieveLoyaltyRewardAsync(rewardId).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

## Redeem Loyalty Reward

Redeems a loyalty reward.

The endpoint sets the reward to the terminal state (`REDEEMED`). 

If you are using your own order processing system (not using the 
Orders API), you call this endpoint after the buyer paid for the 
purchase.

After the reward reaches the terminal state, it cannot be deleted. 
In other words, points used for the reward cannot be returned 
to the account.

For more information, see 
[Loyalty rewards](https://developer.squareup.com/docs/docs/loyalty-api/overview/#loyalty-overview-loyalty-rewards).

```java
CompletableFuture<RedeemLoyaltyRewardResponse> redeemLoyaltyRewardAsync(
    final String rewardId,
    final RedeemLoyaltyRewardRequest body)
```

### Parameters

| Parameter | Type | Tags | Description |
|  --- | --- | --- | --- |
| `rewardId` | `String` | Template, Required | The ID of the [loyalty reward](#type-LoyaltyReward) to redeem. |
| `body` | [`RedeemLoyaltyRewardRequest`](/doc/models/redeem-loyalty-reward-request.md) | Body, Required | An object containing the fields to POST for the request.<br><br>See the corresponding object definition for field details. |

### Response Type

[`RedeemLoyaltyRewardResponse`](/doc/models/redeem-loyalty-reward-response.md)

### Example Usage

```java
String rewardId = "reward_id4";
RedeemLoyaltyRewardRequest body = new RedeemLoyaltyRewardRequest.Builder(
        "98adc7f7-6963-473b-b29c-f3c9cdd7d994",
        "P034NEENMD09F")
    .build();

loyaltyApi.redeemLoyaltyRewardAsync(rewardId, body).thenAccept(result -> {
    // TODO success callback handler
}).exceptionally(exception -> {
    // TODO failure callback handler
    return null;
});
```

