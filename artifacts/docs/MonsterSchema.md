

# MonsterSchema


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the monster. |  |
|**code** | **String** | The code of the monster. This is the monster&#39;s unique identifier (ID). |  |
|**level** | **Integer** | Monster level. |  |
|**hp** | **Integer** | Monster hit points. |  |
|**attackFire** | **Integer** | Monster fire attack. |  |
|**attackEarth** | **Integer** | Monster earth attack. |  |
|**attackWater** | **Integer** | Monster water attack. |  |
|**attackAir** | **Integer** | Monster air attack. |  |
|**resFire** | **Integer** | Monster % fire resistance. |  |
|**resEarth** | **Integer** | Monster % earth resistance. |  |
|**resWater** | **Integer** | Monster % water resistance. |  |
|**resAir** | **Integer** | Monster % air resistance. |  |
|**criticalStrike** | **Integer** | Monster % critical strike. |  |
|**effects** | [**List&lt;SimpleEffectSchema&gt;**](SimpleEffectSchema.md) | List of effects. |  [optional] |
|**minGold** | **Integer** | Monster minimum gold drop.  |  |
|**maxGold** | **Integer** | Monster maximum gold drop.  |  |
|**drops** | [**List&lt;DropRateSchema&gt;**](DropRateSchema.md) | Monster drops. This is a list of items that the monster drops after killing the monster.  |  |



