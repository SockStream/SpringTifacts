

# CharacterSchema


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Name of the character. |  |
|**account** | **String** | Account name. |  |
|**skin** | **CharacterSkin** | Character skin code. |  |
|**level** | **Integer** | Combat level. |  |
|**xp** | **Integer** | The current xp level of the combat level. |  |
|**maxXp** | **Integer** | XP required to level up the character. |  |
|**gold** | **Integer** | The numbers of gold on this character. |  |
|**speed** | **Integer** | *Not available, on the roadmap. Character movement speed. |  |
|**miningLevel** | **Integer** | Mining level. |  |
|**miningXp** | **Integer** | The current xp level of the Mining skill. |  |
|**miningMaxXp** | **Integer** | Mining XP required to level up the skill. |  |
|**woodcuttingLevel** | **Integer** | Woodcutting level. |  |
|**woodcuttingXp** | **Integer** | The current xp level of the Woodcutting skill. |  |
|**woodcuttingMaxXp** | **Integer** | Woodcutting XP required to level up the skill. |  |
|**fishingLevel** | **Integer** | Fishing level. |  |
|**fishingXp** | **Integer** | The current xp level of the Fishing skill. |  |
|**fishingMaxXp** | **Integer** | Fishing XP required to level up the skill. |  |
|**weaponcraftingLevel** | **Integer** | Weaponcrafting level. |  |
|**weaponcraftingXp** | **Integer** | The current xp level of the Weaponcrafting skill. |  |
|**weaponcraftingMaxXp** | **Integer** | Weaponcrafting XP required to level up the skill. |  |
|**gearcraftingLevel** | **Integer** | Gearcrafting level. |  |
|**gearcraftingXp** | **Integer** | The current xp level of the Gearcrafting skill. |  |
|**gearcraftingMaxXp** | **Integer** | Gearcrafting XP required to level up the skill. |  |
|**jewelrycraftingLevel** | **Integer** | Jewelrycrafting level. |  |
|**jewelrycraftingXp** | **Integer** | The current xp level of the Jewelrycrafting skill. |  |
|**jewelrycraftingMaxXp** | **Integer** | Jewelrycrafting XP required to level up the skill. |  |
|**cookingLevel** | **Integer** | The current xp level of the Cooking skill. |  |
|**cookingXp** | **Integer** | Cooking XP. |  |
|**cookingMaxXp** | **Integer** | Cooking XP required to level up the skill. |  |
|**alchemyLevel** | **Integer** | Alchemy level. |  |
|**alchemyXp** | **Integer** | Alchemy XP. |  |
|**alchemyMaxXp** | **Integer** | Alchemy XP required to level up the skill. |  |
|**hp** | **Integer** | Character actual HP. |  |
|**maxHp** | **Integer** | Character max HP. |  |
|**haste** | **Integer** | *Increase speed attack (reduce fight cooldown) |  |
|**criticalStrike** | **Integer** | % Critical strike. Critical strikes adds 50% extra damage to an attack (1.5x). |  |
|**wisdom** | **Integer** | Wisdom increases the amount of XP gained from fights (1% extra per 10 wisdom). |  |
|**prospecting** | **Integer** | Prospecting increases the chances of getting better loot (1% extra per 10 PP). |  |
|**attackFire** | **Integer** | Fire attack. |  |
|**attackEarth** | **Integer** | Earth attack. |  |
|**attackWater** | **Integer** | Water attack. |  |
|**attackAir** | **Integer** | Air attack. |  |
|**dmg** | **Integer** | % Damage. Damage increases your attack in all elements. |  |
|**dmgFire** | **Integer** | % Fire damage. Damage increases your fire attack. |  |
|**dmgEarth** | **Integer** | % Earth damage. Damage increases your earth attack. |  |
|**dmgWater** | **Integer** | % Water damage. Damage increases your water attack. |  |
|**dmgAir** | **Integer** | % Air damage. Damage increases your air attack. |  |
|**resFire** | **Integer** | % Fire resistance. Reduces fire attack. |  |
|**resEarth** | **Integer** | % Earth resistance. Reduces earth attack. |  |
|**resWater** | **Integer** | % Water resistance. Reduces water attack. |  |
|**resAir** | **Integer** | % Air resistance. Reduces air attack. |  |
|**x** | **Integer** | Character x coordinate. |  |
|**y** | **Integer** | Character y coordinate. |  |
|**cooldown** | **Integer** | Cooldown in seconds. |  |
|**cooldownExpiration** | **OffsetDateTime** | Datetime Cooldown expiration. |  [optional] |
|**weaponSlot** | **String** | Weapon slot. |  |
|**runeSlot** | **String** | Rune slot. |  |
|**shieldSlot** | **String** | Shield slot. |  |
|**helmetSlot** | **String** | Helmet slot. |  |
|**bodyArmorSlot** | **String** | Body armor slot. |  |
|**legArmorSlot** | **String** | Leg armor slot. |  |
|**bootsSlot** | **String** | Boots slot. |  |
|**ring1Slot** | **String** | Ring 1 slot. |  |
|**ring2Slot** | **String** | Ring 2 slot. |  |
|**amuletSlot** | **String** | Amulet slot. |  |
|**artifact1Slot** | **String** | Artifact 1 slot. |  |
|**artifact2Slot** | **String** | Artifact 2 slot. |  |
|**artifact3Slot** | **String** | Artifact 3 slot. |  |
|**utility1Slot** | **String** | Utility 1 slot. |  |
|**utility1SlotQuantity** | **Integer** | Utility 1 quantity. |  |
|**utility2Slot** | **String** | Utility 2 slot. |  |
|**utility2SlotQuantity** | **Integer** | Utility 2 quantity. |  |
|**bagSlot** | **String** | Bag slot. |  |
|**task** | **String** | Task in progress. |  |
|**taskType** | **String** | Task type. |  |
|**taskProgress** | **Integer** | Task progression. |  |
|**taskTotal** | **Integer** | Task total objective. |  |
|**inventoryMaxItems** | **Integer** | Inventory max items. |  |
|**inventory** | [**List&lt;InventorySlot&gt;**](InventorySlot.md) | List of inventory slots. |  [optional] |



