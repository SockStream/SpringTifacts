# CharactersApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createCharacterCharactersCreatePost**](CharactersApi.md#createCharacterCharactersCreatePost) | **POST** /characters/create | Create Character |
| [**deleteCharacterCharactersDeletePost**](CharactersApi.md#deleteCharacterCharactersDeletePost) | **POST** /characters/delete | Delete Character |
| [**getCharacterCharactersNameGet**](CharactersApi.md#getCharacterCharactersNameGet) | **GET** /characters/{name} | Get Character |


<a id="createCharacterCharactersCreatePost"></a>
# **createCharacterCharactersCreatePost**
> CharacterResponseSchema createCharacterCharactersCreatePost(addCharacterSchema)

Create Character

Create new character on your account. You can create up to 5 characters.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.CharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    CharactersApi apiInstance = new CharactersApi(defaultClient);
    AddCharacterSchema addCharacterSchema = new AddCharacterSchema(); // AddCharacterSchema | 
    try {
      CharacterResponseSchema result = apiInstance.createCharacterCharactersCreatePost(addCharacterSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CharactersApi#createCharacterCharactersCreatePost");
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
| **addCharacterSchema** | [**AddCharacterSchema**](AddCharacterSchema.md)|  | |

### Return type

[**CharacterResponseSchema**](CharacterResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully created character. |  -  |
| **494** | Name already used. |  -  |
| **495** | Maximum characters reached on your account. |  -  |

<a id="deleteCharacterCharactersDeletePost"></a>
# **deleteCharacterCharactersDeletePost**
> CharacterResponseSchema deleteCharacterCharactersDeletePost(deleteCharacterSchema)

Delete Character

Delete character on your account.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.CharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    CharactersApi apiInstance = new CharactersApi(defaultClient);
    DeleteCharacterSchema deleteCharacterSchema = new DeleteCharacterSchema(); // DeleteCharacterSchema | 
    try {
      CharacterResponseSchema result = apiInstance.deleteCharacterCharactersDeletePost(deleteCharacterSchema);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CharactersApi#deleteCharacterCharactersDeletePost");
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
| **deleteCharacterSchema** | [**DeleteCharacterSchema**](DeleteCharacterSchema.md)|  | |

### Return type

[**CharacterResponseSchema**](CharacterResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully deleted character. |  -  |
| **498** | Character not found. |  -  |

<a id="getCharacterCharactersNameGet"></a>
# **getCharacterCharactersNameGet**
> CharacterResponseSchema getCharacterCharactersNameGet(name)

Get Character

Retrieve the details of a character.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.CharactersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    CharactersApi apiInstance = new CharactersApi(defaultClient);
    String name = "name_example"; // String | The character name.
    try {
      CharacterResponseSchema result = apiInstance.getCharacterCharactersNameGet(name);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CharactersApi#getCharacterCharactersNameGet");
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
| **name** | **String**| The character name. | |

### Return type

[**CharacterResponseSchema**](CharacterResponseSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched character. |  -  |
| **404** | Character not found. |  -  |

