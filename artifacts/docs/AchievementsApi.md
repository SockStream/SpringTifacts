# AchievementsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAchievementAchievementsCodeGet**](AchievementsApi.md#getAchievementAchievementsCodeGet) | **GET** /achievements/{code} | Get Achievement |
| [**getAllAchievementsAchievementsGet**](AchievementsApi.md#getAllAchievementsAchievementsGet) | **GET** /achievements | Get All Achievements |


<a id="getAchievementAchievementsCodeGet"></a>
# **getAchievementAchievementsCodeGet**
> AchievementResponseSchema getAchievementAchievementsCodeGet(code)

Get Achievement

Retrieve the details of a achievement.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.AchievementsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    AchievementsApi apiInstance = new AchievementsApi(defaultClient);
    String code = "code_example"; // String | The code of the achievement.
    try {
      AchievementResponseSchema result = apiInstance.getAchievementAchievementsCodeGet(code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AchievementsApi#getAchievementAchievementsCodeGet");
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

[**AchievementResponseSchema**](AchievementResponseSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched achievement. |  -  |
| **404** | Achievement not found. |  -  |

<a id="getAllAchievementsAchievementsGet"></a>
# **getAllAchievementsAchievementsGet**
> DataPageAchievementSchema getAllAchievementsAchievementsGet(type, page, size)

Get All Achievements

List of all achievements.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.AchievementsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    AchievementsApi apiInstance = new AchievementsApi(defaultClient);
    AchievementType type = AchievementType.fromValue("combat_kill"); // AchievementType | Type of achievements.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageAchievementSchema result = apiInstance.getAllAchievementsAchievementsGet(type, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AchievementsApi#getAllAchievementsAchievementsGet");
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
| **type** | [**AchievementType**](.md)| Type of achievements. | [optional] [enum: combat_kill, combat_drop, combat_level, gathering, crafting, recycling, task, other, use] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageAchievementSchema**](DataPageAchievementSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched achievements. |  -  |

