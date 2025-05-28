# MyAccountApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**changePasswordMyChangePasswordPost**](MyAccountApi.md#changePasswordMyChangePasswordPost) | **POST** /my/change_password | Change Password |
| [**getAccountDetailsMyDetailsGet**](MyAccountApi.md#getAccountDetailsMyDetailsGet) | **GET** /my/details | Get Account Details |
| [**getBankDetailsMyBankGet**](MyAccountApi.md#getBankDetailsMyBankGet) | **GET** /my/bank | Get Bank Details |
| [**getBankItemsMyBankItemsGet**](MyAccountApi.md#getBankItemsMyBankItemsGet) | **GET** /my/bank/items | Get Bank Items |
| [**getGeSellHistoryMyGrandexchangeHistoryGet**](MyAccountApi.md#getGeSellHistoryMyGrandexchangeHistoryGet) | **GET** /my/grandexchange/history | Get Ge Sell History |
| [**getGeSellOrdersMyGrandexchangeOrdersGet**](MyAccountApi.md#getGeSellOrdersMyGrandexchangeOrdersGet) | **GET** /my/grandexchange/orders | Get Ge Sell Orders |


<a id="changePasswordMyChangePasswordPost"></a>
# **changePasswordMyChangePasswordPost**
> ResponseSchema changePasswordMyChangePasswordPost(changePassword)

Change Password

Change your account password. Changing the password reset the account token.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyAccountApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyAccountApi apiInstance = new MyAccountApi(defaultClient);
    ChangePassword changePassword = new ChangePassword(); // ChangePassword | 
    try {
      ResponseSchema result = apiInstance.changePasswordMyChangePasswordPost(changePassword);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyAccountApi#changePasswordMyChangePasswordPost");
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
| **changePassword** | [**ChangePassword**](ChangePassword.md)|  | |

### Return type

[**ResponseSchema**](ResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Password changed successfully. |  -  |
| **458** | Use a different password. |  -  |

<a id="getAccountDetailsMyDetailsGet"></a>
# **getAccountDetailsMyDetailsGet**
> MyAccountDetailsSchema getAccountDetailsMyDetailsGet()

Get Account Details

Fetch account details.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyAccountApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyAccountApi apiInstance = new MyAccountApi(defaultClient);
    try {
      MyAccountDetailsSchema result = apiInstance.getAccountDetailsMyDetailsGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyAccountApi#getAccountDetailsMyDetailsGet");
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

[**MyAccountDetailsSchema**](MyAccountDetailsSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched account details. |  -  |

<a id="getBankDetailsMyBankGet"></a>
# **getBankDetailsMyBankGet**
> BankResponseSchema getBankDetailsMyBankGet()

Get Bank Details

Fetch bank details.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyAccountApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyAccountApi apiInstance = new MyAccountApi(defaultClient);
    try {
      BankResponseSchema result = apiInstance.getBankDetailsMyBankGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyAccountApi#getBankDetailsMyBankGet");
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

[**BankResponseSchema**](BankResponseSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched bank details. |  -  |

<a id="getBankItemsMyBankItemsGet"></a>
# **getBankItemsMyBankItemsGet**
> DataPageSimpleItemSchema getBankItemsMyBankItemsGet(itemCode, page, size)

Get Bank Items

Fetch all items in your bank.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyAccountApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyAccountApi apiInstance = new MyAccountApi(defaultClient);
    String itemCode = "itemCode_example"; // String | Item to search in your bank.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageSimpleItemSchema result = apiInstance.getBankItemsMyBankItemsGet(itemCode, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyAccountApi#getBankItemsMyBankItemsGet");
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
| **itemCode** | **String**| Item to search in your bank. | [optional] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageSimpleItemSchema**](DataPageSimpleItemSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched items. |  -  |

<a id="getGeSellHistoryMyGrandexchangeHistoryGet"></a>
# **getGeSellHistoryMyGrandexchangeHistoryGet**
> DataPageGeOrderHistorySchema getGeSellHistoryMyGrandexchangeHistoryGet(id, code, page, size)

Get Ge Sell History

Fetch your sales history of the last 7 days.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyAccountApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyAccountApi apiInstance = new MyAccountApi(defaultClient);
    String id = "id_example"; // String | Order ID to search in your history.
    String code = "code_example"; // String | Item to search in your history.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageGeOrderHistorySchema result = apiInstance.getGeSellHistoryMyGrandexchangeHistoryGet(id, code, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyAccountApi#getGeSellHistoryMyGrandexchangeHistoryGet");
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
| **id** | **String**| Order ID to search in your history. | [optional] |
| **code** | **String**| Item to search in your history. | [optional] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageGeOrderHistorySchema**](DataPageGeOrderHistorySchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched sales history. |  -  |

<a id="getGeSellOrdersMyGrandexchangeOrdersGet"></a>
# **getGeSellOrdersMyGrandexchangeOrdersGet**
> DataPageGEOrderSchema getGeSellOrdersMyGrandexchangeOrdersGet(code, page, size)

Get Ge Sell Orders

Fetch your sell orders details.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.auth.*;
import org.openapitools.models.*;
import org.openapitools.client.MyAccountApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");
    
    // Configure HTTP bearer authorization: JWTBearer
    HttpBearerAuth JWTBearer = (HttpBearerAuth) defaultClient.getAuthentication("JWTBearer");
    JWTBearer.setBearerToken("BEARER TOKEN");

    MyAccountApi apiInstance = new MyAccountApi(defaultClient);
    String code = "code_example"; // String | The code of the item.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageGEOrderSchema result = apiInstance.getGeSellOrdersMyGrandexchangeOrdersGet(code, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MyAccountApi#getGeSellOrdersMyGrandexchangeOrdersGet");
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
| **code** | **String**| The code of the item. | [optional] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageGEOrderSchema**](DataPageGEOrderSchema.md)

### Authorization

[JWTBearer](../README.md#JWTBearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched orders details. |  -  |

