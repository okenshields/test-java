## Create Dispute Evidence File Response

Defines fields in a CreateDisputeEvidenceFile response.

### Structure

`CreateDisputeEvidenceFileResponse`

### Fields

| Name | Type | Tags | Description | Getter |
|  --- | --- | --- | --- | --- |
| `Errors` | [`List<Error>`](/doc/models/error.md) | Optional | Any errors that occurred during the request. | List<Error> getErrors() |
| `Evidence` | [`DisputeEvidence`](/doc/models/dispute-evidence.md) | Optional | - | DisputeEvidence getEvidence() |

### Example (as JSON)

```json
{
  "evidence": {
    "evidence_id": "TOomLInj6iWmP3N8qfCXrB",
    "dispute_id": "bVTprrwk0gygTLZ96VX1oB",
    "evidence_file": {
      "filename": "evidence.tiff",
      "filetype": "image/tiff"
    },
    "uploaded_at": "2018-10-18T16:01:10.000Z"
  }
}
```

