# ItemsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllItemsItemsGet**](ItemsApi.md#getAllItemsItemsGet) | **GET** /items | Get All Items |
| [**getItemItemsCodeGet**](ItemsApi.md#getItemItemsCodeGet) | **GET** /items/{code} | Get Item |


<a id="getAllItemsItemsGet"></a>
# **getAllItemsItemsGet**
> DataPageItemSchema getAllItemsItemsGet(minLevel, maxLevel, name, type, craftSkill, craftMaterial, page, size)

Get All Items

Fetch items details.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.ItemsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    ItemsApi apiInstance = new ItemsApi(defaultClient);
    Integer minLevel = 56; // Integer | Minimum level items.
    Integer maxLevel = 56; // Integer | Maximum level items.
    String name = "name_example"; // String | Name of the item.
    ItemType type = ItemType.fromValue("utility"); // ItemType | Type of items.
    CraftSkill craftSkill = CraftSkill.fromValue("weaponcrafting"); // CraftSkill | Skill to craft items.
    String craftMaterial = "craftMaterial_example"; // String | Item code of items used as material for crafting.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageItemSchema result = apiInstance.getAllItemsItemsGet(minLevel, maxLevel, name, type, craftSkill, craftMaterial, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ItemsApi#getAllItemsItemsGet");
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
| **minLevel** | **Integer**| Minimum level items. | [optional] |
| **maxLevel** | **Integer**| Maximum level items. | [optional] |
| **name** | **String**| Name of the item. | [optional] |
| **type** | [**ItemType**](.md)| Type of items. | [optional] [enum: utility, body_armor, weapon, resource, leg_armor, helmet, boots, shield, amulet, ring, artifact, currency, consumable, rune, bag] |
| **craftSkill** | [**CraftSkill**](.md)| Skill to craft items. | [optional] [enum: weaponcrafting, gearcrafting, jewelrycrafting, cooking, woodcutting, mining, alchemy] |
| **craftMaterial** | **String**| Item code of items used as material for crafting. | [optional] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageItemSchema**](DataPageItemSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Fetch items details. |  -  |

<a id="getItemItemsCodeGet"></a>
# **getItemItemsCodeGet**
> ItemResponseSchema getItemItemsCodeGet(code)

Get Item

Retrieve the details of a item.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.ItemsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    ItemsApi apiInstance = new ItemsApi(defaultClient);
    String code = "code_example"; // String | The code of the item.
    try {
      ItemResponseSchema result = apiInstance.getItemItemsCodeGet(code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ItemsApi#getItemItemsCodeGet");
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
| **code** | **String**| The code of the item. | |

### Return type

[**ItemResponseSchema**](ItemResponseSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched item. |  -  |
| **404** | Item not found. |  -  |

