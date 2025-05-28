# LeaderboardApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAccountsLeaderboardLeaderboardAccountsGet**](LeaderboardApi.md#getAccountsLeaderboardLeaderboardAccountsGet) | **GET** /leaderboard/accounts | Get Accounts Leaderboard |
| [**getCharactersLeaderboardLeaderboardCharactersGet**](LeaderboardApi.md#getCharactersLeaderboardLeaderboardCharactersGet) | **GET** /leaderboard/characters | Get Characters Leaderboard |


<a id="getAccountsLeaderboardLeaderboardAccountsGet"></a>
# **getAccountsLeaderboardLeaderboardAccountsGet**
> DataPageAccountLeaderboardSchema getAccountsLeaderboardLeaderboardAccountsGet(sort, name, page, size)

Get Accounts Leaderboard

Fetch leaderboard details.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.LeaderboardApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    LeaderboardApi apiInstance = new LeaderboardApi(defaultClient);
    AccountLeaderboardType sort = AccountLeaderboardType.fromValue("achievements_points"); // AccountLeaderboardType | Default sort by achievements points.
    String name = "name_example"; // String | Find a account by name.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageAccountLeaderboardSchema result = apiInstance.getAccountsLeaderboardLeaderboardAccountsGet(sort, name, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaderboardApi#getAccountsLeaderboardLeaderboardAccountsGet");
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
| **sort** | [**AccountLeaderboardType**](.md)| Default sort by achievements points. | [optional] [enum: achievements_points, gold] |
| **name** | **String**| Find a account by name. | [optional] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageAccountLeaderboardSchema**](DataPageAccountLeaderboardSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched leaderboard. |  -  |

<a id="getCharactersLeaderboardLeaderboardCharactersGet"></a>
# **getCharactersLeaderboardLeaderboardCharactersGet**
> DataPageCharacterLeaderboardSchema getCharactersLeaderboardLeaderboardCharactersGet(sort, name, page, size)

Get Characters Leaderboard

Fetch leaderboard details.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.LeaderboardApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    LeaderboardApi apiInstance = new LeaderboardApi(defaultClient);
    CharacterLeaderboardType sort = CharacterLeaderboardType.fromValue("combat"); // CharacterLeaderboardType | Default sort by combat total XP.
    String name = "name_example"; // String | Find a character by name.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageCharacterLeaderboardSchema result = apiInstance.getCharactersLeaderboardLeaderboardCharactersGet(sort, name, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling LeaderboardApi#getCharactersLeaderboardLeaderboardCharactersGet");
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
| **sort** | [**CharacterLeaderboardType**](.md)| Default sort by combat total XP. | [optional] [enum: combat, woodcutting, mining, fishing, weaponcrafting, gearcrafting, jewelrycrafting, cooking, alchemy] |
| **name** | **String**| Find a character by name. | [optional] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageCharacterLeaderboardSchema**](DataPageCharacterLeaderboardSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched leaderboard. |  -  |

