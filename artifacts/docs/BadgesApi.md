# BadgesApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllBadgesBadgesGet**](BadgesApi.md#getAllBadgesBadgesGet) | **GET** /badges | Get All Badges |
| [**getBadgeBadgesCodeGet**](BadgesApi.md#getBadgeBadgesCodeGet) | **GET** /badges/{code} | Get Badge |


<a id="getAllBadgesBadgesGet"></a>
# **getAllBadgesBadgesGet**
> DataPageBadgeSchema getAllBadgesBadgesGet(page, size)

Get All Badges

List of all badges.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.BadgesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    BadgesApi apiInstance = new BadgesApi(defaultClient);
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageBadgeSchema result = apiInstance.getAllBadgesBadgesGet(page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BadgesApi#getAllBadgesBadgesGet");
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

[**DataPageBadgeSchema**](DataPageBadgeSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched badges. |  -  |

<a id="getBadgeBadgesCodeGet"></a>
# **getBadgeBadgesCodeGet**
> BadgeResponseSchema getBadgeBadgesCodeGet(code)

Get Badge

Retrieve the details of a badge.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.BadgesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    BadgesApi apiInstance = new BadgesApi(defaultClient);
    String code = "code_example"; // String | The code of the achievement.
    try {
      BadgeResponseSchema result = apiInstance.getBadgeBadgesCodeGet(code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling BadgesApi#getBadgeBadgesCodeGet");
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

[**BadgeResponseSchema**](BadgeResponseSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched badge. |  -  |
| **404** | badge not found. |  -  |

