# MapsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllMapsMapsGet**](MapsApi.md#getAllMapsMapsGet) | **GET** /maps | Get All Maps |
| [**getMapMapsXYGet**](MapsApi.md#getMapMapsXYGet) | **GET** /maps/{x}/{y} | Get Map |


<a id="getAllMapsMapsGet"></a>
# **getAllMapsMapsGet**
> DataPageMapSchema getAllMapsMapsGet(contentType, contentCode, page, size)

Get All Maps

Fetch maps details.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.MapsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    MapsApi apiInstance = new MapsApi(defaultClient);
    MapContentType contentType = MapContentType.fromValue("monster"); // MapContentType | Type of content on the map.
    String contentCode = "contentCode_example"; // String | Content code on the map.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageMapSchema result = apiInstance.getAllMapsMapsGet(contentType, contentCode, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MapsApi#getAllMapsMapsGet");
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
| **contentType** | [**MapContentType**](.md)| Type of content on the map. | [optional] [enum: monster, resource, workshop, bank, grand_exchange, tasks_master, npc] |
| **contentCode** | **String**| Content code on the map. | [optional] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageMapSchema**](DataPageMapSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched maps details. |  -  |

<a id="getMapMapsXYGet"></a>
# **getMapMapsXYGet**
> MapResponseSchema getMapMapsXYGet(x, y)

Get Map

Retrieve the details of a map.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.MapsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    MapsApi apiInstance = new MapsApi(defaultClient);
    Integer x = 56; // Integer | The position x of the map.
    Integer y = 56; // Integer | The position X of the map.
    try {
      MapResponseSchema result = apiInstance.getMapMapsXYGet(x, y);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MapsApi#getMapMapsXYGet");
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
| **x** | **Integer**| The position x of the map. | |
| **y** | **Integer**| The position X of the map. | |

### Return type

[**MapResponseSchema**](MapResponseSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched map. |  -  |
| **404** | Map not found. |  -  |

