# NpcsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllNpcsNpcsGet**](NpcsApi.md#getAllNpcsNpcsGet) | **GET** /npcs | Get All Npcs |
| [**getNpcItemsNpcsCodeItemsGet**](NpcsApi.md#getNpcItemsNpcsCodeItemsGet) | **GET** /npcs/{code}/items | Get Npc Items |
| [**getNpcNpcsCodeGet**](NpcsApi.md#getNpcNpcsCodeGet) | **GET** /npcs/{code} | Get Npc |


<a id="getAllNpcsNpcsGet"></a>
# **getAllNpcsNpcsGet**
> DataPageNPCSchema getAllNpcsNpcsGet(type, page, size)

Get All Npcs

Fetch NPCs details.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.NpcsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    NpcsApi apiInstance = new NpcsApi(defaultClient);
    String type = "type_example"; // String | The type of the NPC.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageNPCSchema result = apiInstance.getAllNpcsNpcsGet(type, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling NpcsApi#getAllNpcsNpcsGet");
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
| **type** | [**String**](.md)| The type of the NPC. | [optional] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageNPCSchema**](DataPageNPCSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched NPCs details. |  -  |

<a id="getNpcItemsNpcsCodeItemsGet"></a>
# **getNpcItemsNpcsCodeItemsGet**
> DataPageNPCItem getNpcItemsNpcsCodeItemsGet(code, page, size)

Get Npc Items

Retrieve the items list of a NPC. If the NPC has items to buy or sell, they will be displayed.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.NpcsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    NpcsApi apiInstance = new NpcsApi(defaultClient);
    String code = "code_example"; // String | The code of the NPC.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageNPCItem result = apiInstance.getNpcItemsNpcsCodeItemsGet(code, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling NpcsApi#getNpcItemsNpcsCodeItemsGet");
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
| **code** | **String**| The code of the NPC. | |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageNPCItem**](DataPageNPCItem.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched NPC. |  -  |
| **404** | NPC not found. |  -  |

<a id="getNpcNpcsCodeGet"></a>
# **getNpcNpcsCodeGet**
> NPCResponseSchema getNpcNpcsCodeGet(code)

Get Npc

Retrieve the details of a NPC.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.NpcsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    NpcsApi apiInstance = new NpcsApi(defaultClient);
    String code = "code_example"; // String | The code of the NPC.
    try {
      NPCResponseSchema result = apiInstance.getNpcNpcsCodeGet(code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling NpcsApi#getNpcNpcsCodeGet");
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
| **code** | **String**| The code of the NPC. | |

### Return type

[**NPCResponseSchema**](NPCResponseSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched NPC. |  -  |
| **404** | NPC not found. |  -  |

