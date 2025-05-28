# ResourcesApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllResourcesResourcesGet**](ResourcesApi.md#getAllResourcesResourcesGet) | **GET** /resources | Get All Resources |
| [**getResourceResourcesCodeGet**](ResourcesApi.md#getResourceResourcesCodeGet) | **GET** /resources/{code} | Get Resource |


<a id="getAllResourcesResourcesGet"></a>
# **getAllResourcesResourcesGet**
> DataPageResourceSchema getAllResourcesResourcesGet(minLevel, maxLevel, skill, drop, page, size)

Get All Resources

Fetch resources details.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.ResourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    ResourcesApi apiInstance = new ResourcesApi(defaultClient);
    Integer minLevel = 56; // Integer | Skill minimum level.
    Integer maxLevel = 56; // Integer | Skill maximum level.
    GatheringSkill skill = GatheringSkill.fromValue("mining"); // GatheringSkill | The code of the skill.
    String drop = "drop_example"; // String | Item code of the drop.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageResourceSchema result = apiInstance.getAllResourcesResourcesGet(minLevel, maxLevel, skill, drop, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#getAllResourcesResourcesGet");
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
| **minLevel** | **Integer**| Skill minimum level. | [optional] |
| **maxLevel** | **Integer**| Skill maximum level. | [optional] |
| **skill** | [**GatheringSkill**](.md)| The code of the skill. | [optional] [enum: mining, woodcutting, fishing, alchemy] |
| **drop** | **String**| Item code of the drop. | [optional] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageResourceSchema**](DataPageResourceSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched resources details. |  -  |

<a id="getResourceResourcesCodeGet"></a>
# **getResourceResourcesCodeGet**
> ResourceResponseSchema getResourceResourcesCodeGet(code)

Get Resource

Retrieve the details of a resource.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.ResourcesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    ResourcesApi apiInstance = new ResourcesApi(defaultClient);
    String code = "copper_rocks"; // String | The code of the resource.
    try {
      ResourceResponseSchema result = apiInstance.getResourceResourcesCodeGet(code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ResourcesApi#getResourceResourcesCodeGet");
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
| **code** | **String**| The code of the resource. | |

### Return type

[**ResourceResponseSchema**](ResourceResponseSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched resource. |  -  |
| **404** | Resource not found. |  -  |

