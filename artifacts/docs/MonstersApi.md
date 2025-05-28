# MonstersApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllMonstersMonstersGet**](MonstersApi.md#getAllMonstersMonstersGet) | **GET** /monsters | Get All Monsters |
| [**getMonsterMonstersCodeGet**](MonstersApi.md#getMonsterMonstersCodeGet) | **GET** /monsters/{code} | Get Monster |


<a id="getAllMonstersMonstersGet"></a>
# **getAllMonstersMonstersGet**
> DataPageMonsterSchema getAllMonstersMonstersGet(minLevel, maxLevel, drop, page, size)

Get All Monsters

Fetch monsters details.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.MonstersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    MonstersApi apiInstance = new MonstersApi(defaultClient);
    Integer minLevel = 56; // Integer | Monster minimum level.
    Integer maxLevel = 56; // Integer | Monster maximum level.
    String drop = "drop_example"; // String | Item code of the drop.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageMonsterSchema result = apiInstance.getAllMonstersMonstersGet(minLevel, maxLevel, drop, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MonstersApi#getAllMonstersMonstersGet");
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
| **minLevel** | **Integer**| Monster minimum level. | [optional] |
| **maxLevel** | **Integer**| Monster maximum level. | [optional] |
| **drop** | **String**| Item code of the drop. | [optional] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageMonsterSchema**](DataPageMonsterSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched monsters details. |  -  |

<a id="getMonsterMonstersCodeGet"></a>
# **getMonsterMonstersCodeGet**
> MonsterResponseSchema getMonsterMonstersCodeGet(code)

Get Monster

Retrieve the details of a monster.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.MonstersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    MonstersApi apiInstance = new MonstersApi(defaultClient);
    String code = "code_example"; // String | The code of the monster.
    try {
      MonsterResponseSchema result = apiInstance.getMonsterMonstersCodeGet(code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MonstersApi#getMonsterMonstersCodeGet");
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
| **code** | **String**| The code of the monster. | |

### Return type

[**MonsterResponseSchema**](MonsterResponseSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched monster. |  -  |
| **404** | Monster not found. |  -  |

