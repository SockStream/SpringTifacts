# TokenApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**generateTokenTokenPost**](TokenApi.md#generateTokenTokenPost) | **POST** /token | Generate Token |


<a id="generateTokenTokenPost"></a>
# **generateTokenTokenPost**
> TokenResponseSchema generateTokenTokenPost()

Generate Token

Use your account as HTTPBasic Auth to generate your token to use the API. You can also generate your token directly on the website.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.TokenApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP basic authorization: HTTPBasic
    HttpBasicAuth HTTPBasic = (HttpBasicAuth) defaultClient.getAuthentication("HTTPBasic");
    HTTPBasic.setUsername("YOUR USERNAME");
    HTTPBasic.setPassword("YOUR PASSWORD");

    TokenApi apiInstance = new TokenApi(defaultClient);
    try {
      TokenResponseSchema result = apiInstance.generateTokenTokenPost();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TokenApi#generateTokenTokenPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**TokenResponseSchema**](TokenResponseSchema.md)

### Authorization

[HTTPBasic](../README.md#HTTPBasic)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Token generated successfully |  -  |
| **455** | Token generation failed. |  -  |

