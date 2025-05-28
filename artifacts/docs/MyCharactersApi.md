# MyCharactersApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**actionAcceptNewTaskMyNameActionTaskNewPost**](MyCharactersApi.md#actionAcceptNewTaskMyNameActionTaskNewPost) | **POST** /my/{name}/action/task/new | Action Accept New Task |
| [**actionBuyBankExpansionMyNameActionBankBuyExpansionPost**](MyCharactersApi.md#actionBuyBankExpansionMyNameActionBankBuyExpansionPost) | **POST** /my/{name}/action/bank/buy_expansion | Action Buy Bank Expansion |
| [**actionCompleteTaskMyNameActionTaskCompletePost**](MyCharactersApi.md#actionCompleteTaskMyNameActionTaskCompletePost) | **POST** /my/{name}/action/task/complete | Action Complete Task |
| [**actionCraftingMyNameActionCraftingPost**](MyCharactersApi.md#actionCraftingMyNameActionCraftingPost) | **POST** /my/{name}/action/crafting | Action Crafting |
| [**actionDeleteItemMyNameActionDeletePost**](MyCharactersApi.md#actionDeleteItemMyNameActionDeletePost) | **POST** /my/{name}/action/delete | Action Delete Item |
| [**actionDepositBankGoldMyNameActionBankDepositGoldPost**](MyCharactersApi.md#actionDepositBankGoldMyNameActionBankDepositGoldPost) | **POST** /my/{name}/action/bank/deposit/gold | Action Deposit Bank Gold |
| [**actionDepositBankMyNameActionBankDepositPost**](MyCharactersApi.md#actionDepositBankMyNameActionBankDepositPost) | **POST** /my/{name}/action/bank/deposit | Action Deposit Bank |
| [**actionEquipItemMyNameActionEquipPost**](MyCharactersApi.md#actionEquipItemMyNameActionEquipPost) | **POST** /my/{name}/action/equip | Action Equip Item |
| [**actionFightMyNameActionFightPost**](MyCharactersApi.md#actionFightMyNameActionFightPost) | **POST** /my/{name}/action/fight | Action Fight |
| [**actionGatheringMyNameActionGatheringPost**](MyCharactersApi.md#actionGatheringMyNameActionGatheringPost) | **POST** /my/{name}/action/gathering | Action Gathering |
| [**actionGeBuyItemMyNameActionGrandexchangeBuyPost**](MyCharactersApi.md#actionGeBuyItemMyNameActionGrandexchangeBuyPost) | **POST** /my/{name}/action/grandexchange/buy | Action Ge Buy Item |
| [**actionGeCancelSellOrderMyNameActionGrandexchangeCancelPost**](MyCharactersApi.md#actionGeCancelSellOrderMyNameActionGrandexchangeCancelPost) | **POST** /my/{name}/action/grandexchange/cancel | Action Ge Cancel Sell Order |
| [**actionGeCreateSellOrderMyNameActionGrandexchangeSellPost**](MyCharactersApi.md#actionGeCreateSellOrderMyNameActionGrandexchangeSellPost) | **POST** /my/{name}/action/grandexchange/sell | Action Ge Create Sell Order |
| [**actionMoveMyNameActionMovePost**](MyCharactersApi.md#actionMoveMyNameActionMovePost) | **POST** /my/{name}/action/move | Action Move |
| [**actionNpcBuyItemMyNameActionNpcBuyPost**](MyCharactersApi.md#actionNpcBuyItemMyNameActionNpcBuyPost) | **POST** /my/{name}/action/npc/buy | Action Npc Buy Item |
| [**actionNpcSellItemMyNameActionNpcSellPost**](MyCharactersApi.md#actionNpcSellItemMyNameActionNpcSellPost) | **POST** /my/{name}/action/npc/sell | Action Npc Sell Item |
| [**actionRecyclingMyNameActionRecyclingPost**](MyCharactersApi.md#actionRecyclingMyNameActionRecyclingPost) | **POST** /my/{name}/action/recycling | Action Recycling |
| [**actionRestMyNameActionRestPost**](MyCharactersApi.md#actionRestMyNameActionRestPost) | **POST** /my/{name}/action/rest | Action Rest |
| [**actionTaskCancelMyNameActionTaskCancelPost**](MyCharactersApi.md#actionTaskCancelMyNameActionTaskCancelPost) | **POST** /my/{name}/action/task/cancel | Action Task Cancel |
| [**actionTaskExchangeMyNameActionTaskExchangePost**](MyCharactersApi.md#actionTaskExchangeMyNameActionTaskExchangePost) | **POST** /my/{name}/action/task/exchange | Action Task Exchange |
| [**actionTaskTradeMyNameActionTaskTradePost**](MyCharactersApi.md#actionTaskTradeMyNameActionTaskTradePost) | **POST** /my/{name}/action/task/trade | Action Task Trade |
| [**actionUnequipItemMyNameActionUnequipPost**](MyCharactersApi.md#actionUnequipItemMyNameActionUnequipPost) | **POST** /my/{name}/action/unequip | Action Unequip Item |
| [**actionUseItemMyNameActionUsePost**](MyCharactersApi.md#actionUseItemMyNameActionUsePost) | **POST** /my/{name}/action/use | Action Use Item |
| [**actionWithdrawBankGoldMyNameActionBankWithdrawGoldPost**](MyCharactersApi.md#actionWithdrawBankGoldMyNameActionBankWithdrawGoldPost) | **POST** /my/{name}/action/bank/withdraw/gold | Action Withdraw Bank Gold |
| [**actionWithdrawBankMyNameActionBankWithdrawPost**](MyCharactersApi.md#actionWithdrawBankMyNameActionBankWithdrawPost) | **POST** /my/{name}/action/bank/withdraw | Action Withdraw Bank |
| [**getAllCharactersLogsMyLogsGet**](MyCharactersApi.md#getAllCharactersLogsMyLogsGet) | **GET** /my/logs | Get All Characters Logs |
| [**getMyCharactersMyCharactersGet**](MyCharactersApi.md#getMyCharactersMyCharactersGet) | **GET** /my/characters | Get My Characters |


<a id="actionAcceptNewTaskMyNameActionTaskNewPost"></a>
# **actionAcceptNewTaskMyNameActionTaskNewPost**
> TaskResponseSchema actionAcceptNewTaskMyNameActionTaskNewPost(name)

Action Accept New Task

Accepting a new task.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    try {
      TaskResponseSchema result = apiInstance.actionAcceptNewTaskMyNameActionTaskNewPost(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionAcceptNewTaskMyNameActionTaskNewPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |

### Return type

[**TaskResponseSchema**](TaskResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | New task successfully accepted. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **598** | Tasks Master not found on this map. |  -  |
| **489** | Character already has a task. |  -  |

<a id="actionBuyBankExpansionMyNameActionBankBuyExpansionPost"></a>
# **actionBuyBankExpansionMyNameActionBankBuyExpansionPost**
> BankExtensionTransactionResponseSchema actionBuyBankExpansionMyNameActionBankBuyExpansionPost(name)

Action Buy Bank Expansion

Buy a 20 slots bank expansion.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    try {
      BankExtensionTransactionResponseSchema result = apiInstance.actionBuyBankExpansionMyNameActionBankBuyExpansionPost(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionBuyBankExpansionMyNameActionBankBuyExpansionPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |

### Return type

[**BankExtensionTransactionResponseSchema**](BankExtensionTransactionResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Bank expansion successfully bought. |  -  |
| **598** | Bank not found on this map. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **492** | Insufficient gold on your character. |  -  |

<a id="actionCompleteTaskMyNameActionTaskCompletePost"></a>
# **actionCompleteTaskMyNameActionTaskCompletePost**
> RewardDataResponseSchema actionCompleteTaskMyNameActionTaskCompletePost(name)

Action Complete Task

Complete a task.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    try {
      RewardDataResponseSchema result = apiInstance.actionCompleteTaskMyNameActionTaskCompletePost(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionCompleteTaskMyNameActionTaskCompletePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |

### Return type

[**RewardDataResponseSchema**](RewardDataResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The task has been successfully completed. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **598** | Tasks Master not found on this map. |  -  |
| **488** | Character has not completed the task. |  -  |
| **487** | Character has no task. |  -  |
| **497** | Character inventory is full. |  -  |

<a id="actionCraftingMyNameActionCraftingPost"></a>
# **actionCraftingMyNameActionCraftingPost**
> SkillResponseSchema actionCraftingMyNameActionCraftingPost(name, craftingSchema)

Action Crafting

Crafting an item. The character must be on a map with a workshop.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    CraftingSchema craftingSchema = new CraftingSchema(); // CraftingSchema | 
    try {
      SkillResponseSchema result = apiInstance.actionCraftingMyNameActionCraftingPost(name, craftingSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionCraftingMyNameActionCraftingPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **craftingSchema** | [**CraftingSchema**](CraftingSchema.md)|  | |

### Return type

[**SkillResponseSchema**](SkillResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The item was successfully crafted. |  -  |
| **404** | Craft not found. |  -  |
| **598** | Workshop not found on this map. |  -  |
| **498** | Character not found. |  -  |
| **497** | Character inventory is full. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **493** | Not skill level required. |  -  |
| **478** | Missing item or insufficient quantity. |  -  |

<a id="actionDeleteItemMyNameActionDeletePost"></a>
# **actionDeleteItemMyNameActionDeletePost**
> DeleteItemResponseSchema actionDeleteItemMyNameActionDeletePost(name, simpleItemSchema)

Action Delete Item

Delete an item from your character&#39;s inventory.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    SimpleItemSchema simpleItemSchema = new SimpleItemSchema(); // SimpleItemSchema | 
    try {
      DeleteItemResponseSchema result = apiInstance.actionDeleteItemMyNameActionDeletePost(name, simpleItemSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionDeleteItemMyNameActionDeletePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **simpleItemSchema** | [**SimpleItemSchema**](SimpleItemSchema.md)|  | |

### Return type

[**DeleteItemResponseSchema**](DeleteItemResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Item successfully deleted from your character. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **478** | Missing item or insufficient quantity. |  -  |

<a id="actionDepositBankGoldMyNameActionBankDepositGoldPost"></a>
# **actionDepositBankGoldMyNameActionBankDepositGoldPost**
> BankGoldTransactionResponseSchema actionDepositBankGoldMyNameActionBankDepositGoldPost(name, depositWithdrawGoldSchema)

Action Deposit Bank Gold

Deposit gold in a bank on the character&#39;s map.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    DepositWithdrawGoldSchema depositWithdrawGoldSchema = new DepositWithdrawGoldSchema(); // DepositWithdrawGoldSchema | 
    try {
      BankGoldTransactionResponseSchema result = apiInstance.actionDepositBankGoldMyNameActionBankDepositGoldPost(name, depositWithdrawGoldSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionDepositBankGoldMyNameActionBankDepositGoldPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **depositWithdrawGoldSchema** | [**DepositWithdrawGoldSchema**](DepositWithdrawGoldSchema.md)|  | |

### Return type

[**BankGoldTransactionResponseSchema**](BankGoldTransactionResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Golds successfully deposited in your bank. |  -  |
| **598** | Bank not found on this map. |  -  |
| **492** | Insufficient gold on your character. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **461** | A transaction is already in progress with this item/your gold in your bank. |  -  |
| **486** | An action is already in progress by your character. |  -  |

<a id="actionDepositBankMyNameActionBankDepositPost"></a>
# **actionDepositBankMyNameActionBankDepositPost**
> BankItemTransactionResponseSchema actionDepositBankMyNameActionBankDepositPost(name, simpleItemSchema)

Action Deposit Bank

Deposit an item in a bank on the character&#39;s map.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    SimpleItemSchema simpleItemSchema = new SimpleItemSchema(); // SimpleItemSchema | 
    try {
      BankItemTransactionResponseSchema result = apiInstance.actionDepositBankMyNameActionBankDepositPost(name, simpleItemSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionDepositBankMyNameActionBankDepositPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **simpleItemSchema** | [**SimpleItemSchema**](SimpleItemSchema.md)|  | |

### Return type

[**BankItemTransactionResponseSchema**](BankItemTransactionResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Item successfully deposited in your bank. |  -  |
| **598** | Bank not found on this map. |  -  |
| **404** | Item not found. |  -  |
| **461** | A transaction is already in progress with this item/your gold in your bank. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **478** | Missing item or insufficient quantity. |  -  |
| **462** | Your bank is full. |  -  |

<a id="actionEquipItemMyNameActionEquipPost"></a>
# **actionEquipItemMyNameActionEquipPost**
> EquipmentResponseSchema actionEquipItemMyNameActionEquipPost(name, equipSchema)

Action Equip Item

Equip an item on your character.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    EquipSchema equipSchema = new EquipSchema(); // EquipSchema | 
    try {
      EquipmentResponseSchema result = apiInstance.actionEquipItemMyNameActionEquipPost(name, equipSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionEquipItemMyNameActionEquipPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **equipSchema** | [**EquipSchema**](EquipSchema.md)|  | |

### Return type

[**EquipmentResponseSchema**](EquipmentResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The item has been successfully equipped on your character. |  -  |
| **404** | Item not found. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **478** | Missing item or insufficient quantity. |  -  |
| **496** | Character level is insufficient. |  -  |
| **491** | Slot is not empty. |  -  |
| **485** | This item is already equipped. |  -  |
| **484** | Character can&#39;t equip more than 100 utilities in the same slot. |  -  |
| **497** | Character inventory is full. |  -  |

<a id="actionFightMyNameActionFightPost"></a>
# **actionFightMyNameActionFightPost**
> CharacterFightResponseSchema actionFightMyNameActionFightPost(name)

Action Fight

Start a fight against a monster on the character&#39;s map.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    try {
      CharacterFightResponseSchema result = apiInstance.actionFightMyNameActionFightPost(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionFightMyNameActionFightPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |

### Return type

[**CharacterFightResponseSchema**](CharacterFightResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The fight ended successfully. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **598** | Monster not found on this map. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **497** | Character inventory is full. |  -  |

<a id="actionGatheringMyNameActionGatheringPost"></a>
# **actionGatheringMyNameActionGatheringPost**
> SkillResponseSchema actionGatheringMyNameActionGatheringPost(name)

Action Gathering

Harvest a resource on the character&#39;s map.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    try {
      SkillResponseSchema result = apiInstance.actionGatheringMyNameActionGatheringPost(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionGatheringMyNameActionGatheringPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |

### Return type

[**SkillResponseSchema**](SkillResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The resource has been successfully gathered. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **598** | Resource not found on this map. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **493** | Not skill level required. |  -  |
| **497** | Character inventory is full. |  -  |

<a id="actionGeBuyItemMyNameActionGrandexchangeBuyPost"></a>
# **actionGeBuyItemMyNameActionGrandexchangeBuyPost**
> GETransactionResponseSchema actionGeBuyItemMyNameActionGrandexchangeBuyPost(name, geBuyOrderSchema)

Action Ge Buy Item

Buy an item at the Grand Exchange on the character&#39;s map.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    GEBuyOrderSchema geBuyOrderSchema = new GEBuyOrderSchema(); // GEBuyOrderSchema | 
    try {
      GETransactionResponseSchema result = apiInstance.actionGeBuyItemMyNameActionGrandexchangeBuyPost(name, geBuyOrderSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionGeBuyItemMyNameActionGrandexchangeBuyPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **geBuyOrderSchema** | [**GEBuyOrderSchema**](GEBuyOrderSchema.md)|  | |

### Return type

[**GETransactionResponseSchema**](GETransactionResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Item successfully buy from the Grand Exchange. |  -  |
| **598** | Grand Exchange not found on this map. |  -  |
| **498** | Character not found. |  -  |
| **497** | Character inventory is full. |  -  |
| **499** | Character in cooldown. |  -  |
| **436** | A transaction is already in progress on this order by a another character. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **492** | Insufficient gold on your character. |  -  |
| **434** | This offer does not contain as many items. |  -  |
| **435** | You can&#39;t buy to yourself. |  -  |
| **404** | Order not found. |  -  |

<a id="actionGeCancelSellOrderMyNameActionGrandexchangeCancelPost"></a>
# **actionGeCancelSellOrderMyNameActionGrandexchangeCancelPost**
> GETransactionResponseSchema actionGeCancelSellOrderMyNameActionGrandexchangeCancelPost(name, geCancelOrderSchema)

Action Ge Cancel Sell Order

Cancel a sell order at the Grand Exchange on the character&#39;s map.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    GECancelOrderSchema geCancelOrderSchema = new GECancelOrderSchema(); // GECancelOrderSchema | 
    try {
      GETransactionResponseSchema result = apiInstance.actionGeCancelSellOrderMyNameActionGrandexchangeCancelPost(name, geCancelOrderSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionGeCancelSellOrderMyNameActionGrandexchangeCancelPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **geCancelOrderSchema** | [**GECancelOrderSchema**](GECancelOrderSchema.md)|  | |

### Return type

[**GETransactionResponseSchema**](GETransactionResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Your sell order has been successfully cancelled. |  -  |
| **598** | Grand Exchange not found on this map. |  -  |
| **498** | Character not found. |  -  |
| **497** | Character inventory is full. |  -  |
| **499** | Character in cooldown. |  -  |
| **436** | A transaction is already in progress on this order by a another character. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **438** | You can&#39;t cancel an order that is not yours. |  -  |
| **404** | Order not found. |  -  |

<a id="actionGeCreateSellOrderMyNameActionGrandexchangeSellPost"></a>
# **actionGeCreateSellOrderMyNameActionGrandexchangeSellPost**
> GECreateOrderTransactionResponseSchema actionGeCreateSellOrderMyNameActionGrandexchangeSellPost(name, geOrderCreationrSchema)

Action Ge Create Sell Order

Create a sell order at the Grand Exchange on the character&#39;s map. Please note there is a 3% listing tax, charged at the time of posting, on the total price.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    GEOrderCreationrSchema geOrderCreationrSchema = new GEOrderCreationrSchema(); // GEOrderCreationrSchema | 
    try {
      GECreateOrderTransactionResponseSchema result = apiInstance.actionGeCreateSellOrderMyNameActionGrandexchangeSellPost(name, geOrderCreationrSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionGeCreateSellOrderMyNameActionGrandexchangeSellPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **geOrderCreationrSchema** | [**GEOrderCreationrSchema**](GEOrderCreationrSchema.md)|  | |

### Return type

[**GECreateOrderTransactionResponseSchema**](GECreateOrderTransactionResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The sell order has been successfully created. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **404** | Item not found. |  -  |
| **478** | Missing item or insufficient quantity. |  -  |
| **492** | Insufficient gold on your character. |  -  |
| **433** | You can&#39;t create more than 100 orders at the same time. |  -  |
| **437** | This item cannot be sold. |  -  |
| **598** | Grand Exchange not found on this map. |  -  |

<a id="actionMoveMyNameActionMovePost"></a>
# **actionMoveMyNameActionMovePost**
> CharacterMovementResponseSchema actionMoveMyNameActionMovePost(name, destinationSchema)

Action Move

Moves a character on the map using the map&#39;s X and Y position.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    DestinationSchema destinationSchema = new DestinationSchema(); // DestinationSchema | 
    try {
      CharacterMovementResponseSchema result = apiInstance.actionMoveMyNameActionMovePost(name, destinationSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionMoveMyNameActionMovePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **destinationSchema** | [**DestinationSchema**](DestinationSchema.md)|  | |

### Return type

[**CharacterMovementResponseSchema**](CharacterMovementResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The character has moved successfully. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **490** | Character already at destination. |  -  |
| **404** | Map not found. |  -  |
| **486** | An action is already in progress by your character. |  -  |

<a id="actionNpcBuyItemMyNameActionNpcBuyPost"></a>
# **actionNpcBuyItemMyNameActionNpcBuyPost**
> NpcMerchantTransactionResponseSchema actionNpcBuyItemMyNameActionNpcBuyPost(name, npcMerchantBuySchema)

Action Npc Buy Item

Buy an item from an NPC on the character&#39;s map.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    NpcMerchantBuySchema npcMerchantBuySchema = new NpcMerchantBuySchema(); // NpcMerchantBuySchema | 
    try {
      NpcMerchantTransactionResponseSchema result = apiInstance.actionNpcBuyItemMyNameActionNpcBuyPost(name, npcMerchantBuySchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionNpcBuyItemMyNameActionNpcBuyPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **npcMerchantBuySchema** | [**NpcMerchantBuySchema**](NpcMerchantBuySchema.md)|  | |

### Return type

[**NpcMerchantTransactionResponseSchema**](NpcMerchantTransactionResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Item successfully bought from the NPC. |  -  |
| **598** | NPC not found on this map. |  -  |
| **498** | Character not found. |  -  |
| **497** | Character inventory is full. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **492** | Insufficient gold on your character. |  -  |
| **441** | This item cannot be purchased. |  -  |
| **404** | Item not found. |  -  |

<a id="actionNpcSellItemMyNameActionNpcSellPost"></a>
# **actionNpcSellItemMyNameActionNpcSellPost**
> NpcMerchantTransactionResponseSchema actionNpcSellItemMyNameActionNpcSellPost(name, npcMerchantBuySchema)

Action Npc Sell Item

Sell an item to an NPC on the character&#39;s map.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    NpcMerchantBuySchema npcMerchantBuySchema = new NpcMerchantBuySchema(); // NpcMerchantBuySchema | 
    try {
      NpcMerchantTransactionResponseSchema result = apiInstance.actionNpcSellItemMyNameActionNpcSellPost(name, npcMerchantBuySchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionNpcSellItemMyNameActionNpcSellPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **npcMerchantBuySchema** | [**NpcMerchantBuySchema**](NpcMerchantBuySchema.md)|  | |

### Return type

[**NpcMerchantTransactionResponseSchema**](NpcMerchantTransactionResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Item successfully sold to the NPC. |  -  |
| **598** | NPC not found on this map. |  -  |
| **498** | Character not found. |  -  |
| **497** | Character inventory is full. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **478** | Missing item or insufficient quantity. |  -  |
| **442** | This item cannot be sold. |  -  |
| **404** | Item not found. |  -  |

<a id="actionRecyclingMyNameActionRecyclingPost"></a>
# **actionRecyclingMyNameActionRecyclingPost**
> RecyclingResponseSchema actionRecyclingMyNameActionRecyclingPost(name, recyclingSchema)

Action Recycling

Recycling an item. The character must be on a map with a workshop (only for equipments and weapons).

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    RecyclingSchema recyclingSchema = new RecyclingSchema(); // RecyclingSchema | 
    try {
      RecyclingResponseSchema result = apiInstance.actionRecyclingMyNameActionRecyclingPost(name, recyclingSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionRecyclingMyNameActionRecyclingPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **recyclingSchema** | [**RecyclingSchema**](RecyclingSchema.md)|  | |

### Return type

[**RecyclingResponseSchema**](RecyclingResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The items were successfully recycled. |  -  |
| **404** | Item not found. |  -  |
| **598** | Workshop not found on this map. |  -  |
| **498** | Character not found. |  -  |
| **497** | Character inventory is full. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **493** | Not skill level required. |  -  |
| **478** | Missing item or insufficient quantity. |  -  |
| **473** | This item cannot be recycled. |  -  |

<a id="actionRestMyNameActionRestPost"></a>
# **actionRestMyNameActionRestPost**
> CharacterRestResponseSchema actionRestMyNameActionRestPost(name)

Action Rest

Recovers hit points by resting. (1 second per 5 HP, minimum 3 seconds)

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    try {
      CharacterRestResponseSchema result = apiInstance.actionRestMyNameActionRestPost(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionRestMyNameActionRestPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |

### Return type

[**CharacterRestResponseSchema**](CharacterRestResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The character has rested successfully. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |

<a id="actionTaskCancelMyNameActionTaskCancelPost"></a>
# **actionTaskCancelMyNameActionTaskCancelPost**
> TaskCancelledResponseSchema actionTaskCancelMyNameActionTaskCancelPost(name)

Action Task Cancel

Cancel a task for 1 tasks coin.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    try {
      TaskCancelledResponseSchema result = apiInstance.actionTaskCancelMyNameActionTaskCancelPost(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionTaskCancelMyNameActionTaskCancelPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |

### Return type

[**TaskCancelledResponseSchema**](TaskCancelledResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The task has been successfully cancelled. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **598** | Tasks Master not found on this map. |  -  |
| **478** | Missing item or insufficient quantity. |  -  |

<a id="actionTaskExchangeMyNameActionTaskExchangePost"></a>
# **actionTaskExchangeMyNameActionTaskExchangePost**
> RewardDataResponseSchema actionTaskExchangeMyNameActionTaskExchangePost(name)

Action Task Exchange

Exchange 6 tasks coins for a random reward. Rewards are exclusive items or resources.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    try {
      RewardDataResponseSchema result = apiInstance.actionTaskExchangeMyNameActionTaskExchangePost(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionTaskExchangeMyNameActionTaskExchangePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |

### Return type

[**RewardDataResponseSchema**](RewardDataResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The tasks coins have been successfully exchanged. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **598** | Tasks Master not found on this map. |  -  |
| **478** | Missing item or insufficient quantity. |  -  |
| **497** | Character inventory is full. |  -  |

<a id="actionTaskTradeMyNameActionTaskTradePost"></a>
# **actionTaskTradeMyNameActionTaskTradePost**
> TaskTradeResponseSchema actionTaskTradeMyNameActionTaskTradePost(name, simpleItemSchema)

Action Task Trade

Trading items with a Tasks Master.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    SimpleItemSchema simpleItemSchema = new SimpleItemSchema(); // SimpleItemSchema | 
    try {
      TaskTradeResponseSchema result = apiInstance.actionTaskTradeMyNameActionTaskTradePost(name, simpleItemSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionTaskTradeMyNameActionTaskTradePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **simpleItemSchema** | [**SimpleItemSchema**](SimpleItemSchema.md)|  | |

### Return type

[**TaskTradeResponseSchema**](TaskTradeResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | You have successfully trade items to a Tasks Master. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **598** | Tasks Master not found on this map. |  -  |
| **475** | Character have already completed the task or are trying to trade too many items. |  -  |
| **474** | Character does not have this task. |  -  |
| **478** | Missing item or insufficient quantity. |  -  |

<a id="actionUnequipItemMyNameActionUnequipPost"></a>
# **actionUnequipItemMyNameActionUnequipPost**
> EquipmentResponseSchema actionUnequipItemMyNameActionUnequipPost(name, unequipSchema)

Action Unequip Item

Unequip an item on your character.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    UnequipSchema unequipSchema = new UnequipSchema(); // UnequipSchema | 
    try {
      EquipmentResponseSchema result = apiInstance.actionUnequipItemMyNameActionUnequipPost(name, unequipSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionUnequipItemMyNameActionUnequipPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **unequipSchema** | [**UnequipSchema**](UnequipSchema.md)|  | |

### Return type

[**EquipmentResponseSchema**](EquipmentResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The item has been successfully unequipped and added in their inventory. |  -  |
| **404** | Item not found. |  -  |
| **498** | Character not found. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **491** | Slot is empty. |  -  |
| **497** | Character inventory is full. |  -  |
| **478** | Missing item or insufficient quantity. |  -  |
| **483** | Character has no enough HP to unequip this item. |  -  |
| **499** | Character in cooldown. |  -  |

<a id="actionUseItemMyNameActionUsePost"></a>
# **actionUseItemMyNameActionUsePost**
> UseItemResponseSchema actionUseItemMyNameActionUsePost(name, simpleItemSchema)

Action Use Item

Use an item as a consumable.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    SimpleItemSchema simpleItemSchema = new SimpleItemSchema(); // SimpleItemSchema | 
    try {
      UseItemResponseSchema result = apiInstance.actionUseItemMyNameActionUsePost(name, simpleItemSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionUseItemMyNameActionUsePost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **simpleItemSchema** | [**SimpleItemSchema**](SimpleItemSchema.md)|  | |

### Return type

[**UseItemResponseSchema**](UseItemResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The item has been successfully used. |  -  |
| **404** | Item not found. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **476** | This item is not a consumable. |  -  |
| **478** | Missing item or insufficient quantity. |  -  |
| **496** | Character level is insufficient. |  -  |

<a id="actionWithdrawBankGoldMyNameActionBankWithdrawGoldPost"></a>
# **actionWithdrawBankGoldMyNameActionBankWithdrawGoldPost**
> BankGoldTransactionResponseSchema actionWithdrawBankGoldMyNameActionBankWithdrawGoldPost(name, depositWithdrawGoldSchema)

Action Withdraw Bank Gold

Withdraw gold from your bank.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    DepositWithdrawGoldSchema depositWithdrawGoldSchema = new DepositWithdrawGoldSchema(); // DepositWithdrawGoldSchema | 
    try {
      BankGoldTransactionResponseSchema result = apiInstance.actionWithdrawBankGoldMyNameActionBankWithdrawGoldPost(name, depositWithdrawGoldSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionWithdrawBankGoldMyNameActionBankWithdrawGoldPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **depositWithdrawGoldSchema** | [**DepositWithdrawGoldSchema**](DepositWithdrawGoldSchema.md)|  | |

### Return type

[**BankGoldTransactionResponseSchema**](BankGoldTransactionResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Golds successfully withdraw from your bank. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **461** | A transaction is already in progress with this item/your gold in your bank. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **598** | Bank not found on this map. |  -  |
| **460** | Insufficient gold in your bank. |  -  |

<a id="actionWithdrawBankMyNameActionBankWithdrawPost"></a>
# **actionWithdrawBankMyNameActionBankWithdrawPost**
> BankItemTransactionResponseSchema actionWithdrawBankMyNameActionBankWithdrawPost(name, simpleItemSchema)

Action Withdraw Bank

Take an item from your bank and put it in the character&#39;s inventory.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    String name = "name_example"; // String | Name of your character.
    SimpleItemSchema simpleItemSchema = new SimpleItemSchema(); // SimpleItemSchema | 
    try {
      BankItemTransactionResponseSchema result = apiInstance.actionWithdrawBankMyNameActionBankWithdrawPost(name, simpleItemSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#actionWithdrawBankMyNameActionBankWithdrawPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **name** | **String**| Name of your character. | |
| **simpleItemSchema** | [**SimpleItemSchema**](SimpleItemSchema.md)|  | |

### Return type

[**BankItemTransactionResponseSchema**](BankItemTransactionResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Item successfully withdraw from your bank. |  -  |
| **404** | Item not found. |  -  |
| **498** | Character not found. |  -  |
| **499** | Character in cooldown. |  -  |
| **461** | A transaction is already in progress with this item/your gold in your bank. |  -  |
| **486** | An action is already in progress by your character. |  -  |
| **497** | Character inventory is full. |  -  |
| **598** | Bank not found on this map. |  -  |
| **478** | Missing item or insufficient quantity. |  -  |

<a id="getAllCharactersLogsMyLogsGet"></a>
# **getAllCharactersLogsMyLogsGet**
> DataPageLogSchema getAllCharactersLogsMyLogsGet(page, size)

Get All Characters Logs

History of the last 100 actions of all your characters.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageLogSchema result = apiInstance.getAllCharactersLogsMyLogsGet(page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#getAllCharactersLogsMyLogsGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageLogSchema**](DataPageLogSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched logs. |  -  |
| **404** | Logs not found. |  -  |
| **498** | Character not found. |  -  |

<a id="getMyCharactersMyCharactersGet"></a>
# **getMyCharactersMyCharactersGet**
> MyCharactersListSchema getMyCharactersMyCharactersGet()

Get My Characters

List of your characters. This endpoint is deprecated and will be removed in a future version. Please use accounts/{account}/characters.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyCharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyCharactersApi apiInstance = new MyCharactersApi(defaultClient);
    try {
      MyCharactersListSchema result = apiInstance.getMyCharactersMyCharactersGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyCharactersApi#getMyCharactersMyCharactersGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**MyCharactersListSchema**](MyCharactersListSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched characters. |  -  |

