# EventsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllActiveEventsEventsActiveGet**](EventsApi.md#getAllActiveEventsEventsActiveGet) | **GET** /events/active | Get All Active Events |
| [**getAllEventsEventsGet**](EventsApi.md#getAllEventsEventsGet) | **GET** /events | Get All Events |


<a id="getAllActiveEventsEventsActiveGet"></a>
# **getAllActiveEventsEventsActiveGet**
> DataPageActiveEventSchema getAllActiveEventsEventsActiveGet(page, size)

Get All Active Events

Fetch active events details.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.EventsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    EventsApi apiInstance = new EventsApi(defaultClient);
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageActiveEventSchema result = apiInstance.getAllActiveEventsEventsActiveGet(page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EventsApi#getAllActiveEventsEventsActiveGet");
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

[**DataPageActiveEventSchema**](DataPageActiveEventSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched events details. |  -  |

<a id="getAllEventsEventsGet"></a>
# **getAllEventsEventsGet**
> DataPageEventSchema getAllEventsEventsGet(type, page, size)

Get All Events

Fetch events details.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.EventsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    EventsApi apiInstance = new EventsApi(defaultClient);
    MapContentType type = MapContentType.fromValue("monster"); // MapContentType | Type of event.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageEventSchema result = apiInstance.getAllEventsEventsGet(type, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling EventsApi#getAllEventsEventsGet");
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
| **type** | [**MapContentType**](.md)| Type of event. | [optional] [enum: monster, resource, workshop, bank, grand_exchange, tasks_master, npc] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageEventSchema**](DataPageEventSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched events details. |  -  |

