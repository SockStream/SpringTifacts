

# ItemSchema


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Item name. |  |
|**code** | **String** | Item code. This is the item&#39;s unique identifier (ID). |  |
|**level** | **Integer** | Item level. |  |
|**type** | **String** | Item type. |  |
|**subtype** | **String** | Item subtype. |  |
|**description** | **String** | Item description. |  |
|**effects** | [**List&lt;SimpleEffectSchema&gt;**](SimpleEffectSchema.md) | List of object effects. For equipment, it will include item stats. |  [optional] |
|**craft** | [**CraftSchema**](CraftSchema.md) |  |  [optional] |
|**tradeable** | **Boolean** | Item tradeable status. A non-tradeable item cannot be exchanged or sold. |  |



