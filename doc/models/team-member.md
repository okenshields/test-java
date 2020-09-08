## Team Member

A record representing an individual team member for a business.

### Structure

`TeamMember`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Id` | `String` | Optional | The unique ID for the team member. | String getId() |
| `ReferenceId` | `String` | Optional | A second ID used to associate the team member with an entity in another system. | String getReferenceId() |
| `IsOwner` | `Boolean` | Optional | Whether the team member is the owner of the Square account. | Boolean getIsOwner() |
| `Status` | [`String`](/doc/models/team-member-status.md) | Optional | Enumerates the possible statuses the team member can have within a business. | String getStatus() |
| `GivenName` | `String` | Optional | The given (i.e., first) name associated with the team member. | String getGivenName() |
| `FamilyName` | `String` | Optional | The family (i.e., last) name associated with the team member. | String getFamilyName() |
| `EmailAddress` | `String` | Optional | The email address associated with the team member. | String getEmailAddress() |
| `PhoneNumber` | `String` | Optional | The team member's phone number in E.164 format. Examples:<br>+14155552671 - the country code is 1 for US<br>+551155256325 - the country code is 55 for BR | String getPhoneNumber() |
| `CreatedAt` | `String` | Optional | The timestamp in RFC 3339 format describing when the team member was created.<br>Ex: "2018-10-04T04:00:00-07:00" or "2019-02-05T12:00:00Z" | String getCreatedAt() |
| `UpdatedAt` | `String` | Optional | The timestamp in RFC 3339 format describing when the team member was last updated.<br>Ex: "2018-10-04T04:00:00-07:00" or "2019-02-05T12:00:00Z" | String getUpdatedAt() |
| `AssignedLocations` | [`TeamMemberAssignedLocations`](/doc/models/team-member-assigned-locations.md) | Optional | An object that represents a team member's assignment to locations. | TeamMemberAssignedLocations getAssignedLocations() |

### Example (as JSON)

```json
{
  "id": "id0",
  "reference_id": "reference_id2",
  "is_owner": false,
  "status": "ACTIVE",
  "given_name": "given_name2"
}
```

