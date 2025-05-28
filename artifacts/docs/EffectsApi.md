# EffectsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllEffectsEffectsGet**](EffectsApi.md#getAllEffectsEffectsGet) | **GET** /effects | Get All Effects |
| [**getEffectEffectsCodeGet**](EffectsApi.md#getEffectEffectsCodeGet) | **GET** /effects/{code} | Get Effect |


<a id="getAllEffectsEffectsGet"></a>
# **getAllEffectsEffectsGet**
> DataPageEffectSchema getAllEffectsEffectsGet(page, size)

Get All Effects

List of all effects. Effects are used by equipment, tools, runes, consumables and monsters. An effect is an action that produces an effect on the game.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.EffectsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    EffectsApi apiInstance = new EffectsApi(defaultClient);
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageEffectSchema result = apiInstance.getAllEffectsEffectsGet(page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EffectsApi#getAllEffectsEffectsGet");
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

[**DataPageEffectSchema**](DataPageEffectSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched effects. |  -  |

<a id="getEffectEffectsCodeGet"></a>
# **getEffectEffectsCodeGet**
> EffectResponseSchema getEffectEffectsCodeGet(code)

Get Effect

Retrieve the details of a badge.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.EffectsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    EffectsApi apiInstance = new EffectsApi(defaultClient);
    String code = "code_example"; // String | The code of the achievement.
    try {
      EffectResponseSchema result = apiInstance.getEffectEffectsCodeGet(code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EffectsApi#getEffectEffectsCodeGet");
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
| **code** | **String**| The code of the achievement. | |

### Return type

[**EffectResponseSchema**](EffectResponseSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched effect. |  -  |
| **404** | effect not found. |  -  |

