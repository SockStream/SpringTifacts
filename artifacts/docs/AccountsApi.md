# AccountsApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createAccountAccountsCreatePost**](AccountsApi.md#createAccountAccountsCreatePost) | **POST** /accounts/create | Create Account |
| [**getAccountAccountsAccountGet**](AccountsApi.md#getAccountAccountsAccountGet) | **GET** /accounts/{account} | Get Account |
| [**getAccountAchievementsAccountsAccountAchievementsGet**](AccountsApi.md#getAccountAchievementsAccountsAccountAchievementsGet) | **GET** /accounts/{account}/achievements | Get Account Achievements |
| [**getAccountCharactersAccountsAccountCharactersGet**](AccountsApi.md#getAccountCharactersAccountsAccountCharactersGet) | **GET** /accounts/{account}/characters | Get Account Characters |


<a id="createAccountAccountsCreatePost"></a>
# **createAccountAccountsCreatePost**
> ResponseSchema createAccountAccountsCreatePost(addAccountSchema)

Create Account

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.AccountsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    AccountsApi apiInstance = new AccountsApi(defaultClient);
    AddAccountSchema addAccountSchema = new AddAccountSchema(); // AddAccountSchema | 
    try {
      ResponseSchema result = apiInstance.createAccountAccountsCreatePost(addAccountSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AccountsApi#createAccountAccountsCreatePost");
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
| **addAccountSchema** | [**AddAccountSchema**](AddAccountSchema.md)|  | |

### Return type

[**ResponseSchema**](ResponseSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Account created successfully. |  -  |
| **456** | Username already used. |  -  |
| **457** | Email already used. |  -  |

<a id="getAccountAccountsAccountGet"></a>
# **getAccountAccountsAccountGet**
> AccountDetailsSchema getAccountAccountsAccountGet(account)

Get Account

Retrieve the details of a character.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.AccountsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    AccountsApi apiInstance = new AccountsApi(defaultClient);
    String account = "account_example"; // String | The account name.
    try {
      AccountDetailsSchema result = apiInstance.getAccountAccountsAccountGet(account);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AccountsApi#getAccountAccountsAccountGet");
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
| **account** | **String**| The account name. | |

### Return type

[**AccountDetailsSchema**](AccountDetailsSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched account. |  -  |
| **404** | Account not found. |  -  |

<a id="getAccountAchievementsAccountsAccountAchievementsGet"></a>
# **getAccountAchievementsAccountsAccountAchievementsGet**
> DataPageAccountAchievementSchema getAccountAchievementsAccountsAccountAchievementsGet(account, type, completed, page, size)

Get Account Achievements

Retrieve the achievements of a account.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.AccountsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    AccountsApi apiInstance = new AccountsApi(defaultClient);
    String account = "account_example"; // String | The character name.
    AchievementType type = AchievementType.fromValue("combat_kill"); // AchievementType | Type of achievements.
    Boolean completed = true; // Boolean | Filter by completed achievements.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageAccountAchievementSchema result = apiInstance.getAccountAchievementsAccountsAccountAchievementsGet(account, type, completed, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AccountsApi#getAccountAchievementsAccountsAccountAchievementsGet");
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
| **account** | **String**| The character name. | |
| **type** | [**AchievementType**](.md)| Type of achievements. | [optional] [enum: combat_kill, combat_drop, combat_level, gathering, crafting, recycling, task, other, use] |
| **completed** | **Boolean**| Filter by completed achievements. | [optional] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageAccountAchievementSchema**](DataPageAccountAchievementSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched achievements. |  -  |
| **404** | Account not found. |  -  |

<a id="getAccountCharactersAccountsAccountCharactersGet"></a>
# **getAccountCharactersAccountsAccountCharactersGet**
> CharactersListSchema getAccountCharactersAccountsAccountCharactersGet(account)

Get Account Characters

Account character lists.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.AccountsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    AccountsApi apiInstance = new AccountsApi(defaultClient);
    String account = "account_example"; // String | The character name.
    try {
      CharactersListSchema result = apiInstance.getAccountCharactersAccountsAccountCharactersGet(account);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling AccountsApi#getAccountCharactersAccountsAccountCharactersGet");
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
| **account** | **String**| The character name. | |

### Return type

[**CharactersListSchema**](CharactersListSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched characters. |  -  |

