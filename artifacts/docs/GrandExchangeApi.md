# GrandExchangeApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getGeSellHistoryGrandexchangeHistoryCodeGet**](GrandExchangeApi.md#getGeSellHistoryGrandexchangeHistoryCodeGet) | **GET** /grandexchange/history/{code} | Get Ge Sell History |
| [**getGeSellOrderGrandexchangeOrdersIdGet**](GrandExchangeApi.md#getGeSellOrderGrandexchangeOrdersIdGet) | **GET** /grandexchange/orders/{id} | Get Ge Sell Order |
| [**getGeSellOrdersGrandexchangeOrdersGet**](GrandExchangeApi.md#getGeSellOrdersGrandexchangeOrdersGet) | **GET** /grandexchange/orders | Get Ge Sell Orders |


<a id="getGeSellHistoryGrandexchangeHistoryCodeGet"></a>
# **getGeSellHistoryGrandexchangeHistoryCodeGet**
> DataPageGeOrderHistorySchema getGeSellHistoryGrandexchangeHistoryCodeGet(code, seller, buyer, page, size)

Get Ge Sell History

Fetch the sales history of the item for the last 7 days.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.GrandExchangeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    GrandExchangeApi apiInstance = new GrandExchangeApi(defaultClient);
    String code = "code_example"; // String | The code of the item.
    String seller = "seller_example"; // String | The seller (account name) of the item.
    String buyer = "buyer_example"; // String | The buyer (account name) of the item.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageGeOrderHistorySchema result = apiInstance.getGeSellHistoryGrandexchangeHistoryCodeGet(code, seller, buyer, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GrandExchangeApi#getGeSellHistoryGrandexchangeHistoryCodeGet");
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
| **code** | **String**| The code of the item. | |
| **seller** | **String**| The seller (account name) of the item. | [optional] |
| **buyer** | **String**| The buyer (account name) of the item. | [optional] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageGeOrderHistorySchema**](DataPageGeOrderHistorySchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched orders history. |  -  |
| **404** | Item not found. |  -  |

<a id="getGeSellOrderGrandexchangeOrdersIdGet"></a>
# **getGeSellOrderGrandexchangeOrdersIdGet**
> GEOrderReponseSchema getGeSellOrderGrandexchangeOrdersIdGet(id)

Get Ge Sell Order

Retrieve the sell order of a item.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.GrandExchangeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    GrandExchangeApi apiInstance = new GrandExchangeApi(defaultClient);
    String id = "id_example"; // String | The id of the order.
    try {
      GEOrderReponseSchema result = apiInstance.getGeSellOrderGrandexchangeOrdersIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GrandExchangeApi#getGeSellOrderGrandexchangeOrdersIdGet");
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
| **id** | **String**| The id of the order. | |

### Return type

[**GEOrderReponseSchema**](GEOrderReponseSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched order. |  -  |
| **404** | Order not found. |  -  |

<a id="getGeSellOrdersGrandexchangeOrdersGet"></a>
# **getGeSellOrdersGrandexchangeOrdersGet**
> DataPageGEOrderSchema getGeSellOrdersGrandexchangeOrdersGet(code, seller, page, size)

Get Ge Sell Orders

Fetch all sell orders.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.GrandExchangeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    GrandExchangeApi apiInstance = new GrandExchangeApi(defaultClient);
    String code = "code_example"; // String | The code of the item.
    String seller = "seller_example"; // String | The seller (account name) of the item.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageGEOrderSchema result = apiInstance.getGeSellOrdersGrandexchangeOrdersGet(code, seller, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling GrandExchangeApi#getGeSellOrdersGrandexchangeOrdersGet");
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
| **seller** | **String**| The seller (account name) of the item. | [optional] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageGEOrderSchema**](DataPageGEOrderSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched orders details. |  -  |

