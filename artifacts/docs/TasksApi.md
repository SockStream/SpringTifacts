# TasksApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllTasksRewardsTasksRewardsGet**](TasksApi.md#getAllTasksRewardsTasksRewardsGet) | **GET** /tasks/rewards | Get All Tasks Rewards |
| [**getAllTasksTasksListGet**](TasksApi.md#getAllTasksTasksListGet) | **GET** /tasks/list | Get All Tasks |
| [**getTaskTasksListCodeGet**](TasksApi.md#getTaskTasksListCodeGet) | **GET** /tasks/list/{code} | Get Task |
| [**getTasksRewardTasksRewardsCodeGet**](TasksApi.md#getTasksRewardTasksRewardsCodeGet) | **GET** /tasks/rewards/{code} | Get Tasks Reward |


<a id="getAllTasksRewardsTasksRewardsGet"></a>
# **getAllTasksRewardsTasksRewardsGet**
> DataPageDropRateSchema getAllTasksRewardsTasksRewardsGet(page, size)

Get All Tasks Rewards

Fetch the list of all tasks rewards. To obtain these rewards, you must exchange 6 task coins with a tasks master.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.TasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    TasksApi apiInstance = new TasksApi(defaultClient);
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageDropRateSchema result = apiInstance.getAllTasksRewardsTasksRewardsGet(page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TasksApi#getAllTasksRewardsTasksRewardsGet");
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

[**DataPageDropRateSchema**](DataPageDropRateSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched tasks rewards details. |  -  |

<a id="getAllTasksTasksListGet"></a>
# **getAllTasksTasksListGet**
> DataPageTaskFullSchema getAllTasksTasksListGet(minLevel, maxLevel, skill, type, page, size)

Get All Tasks

Fetch the list of all tasks.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.TasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    TasksApi apiInstance = new TasksApi(defaultClient);
    Integer minLevel = 56; // Integer | Minimum level.
    Integer maxLevel = 56; // Integer | Maximum level.
    Skill skill = Skill.fromValue("weaponcrafting"); // Skill | The code of the skill.
    TaskType type = TaskType.fromValue("monsters"); // TaskType | The type of tasks.
    Integer page = 1; // Integer | Page number
    Integer size = 50; // Integer | Page size
    try {
      DataPageTaskFullSchema result = apiInstance.getAllTasksTasksListGet(minLevel, maxLevel, skill, type, page, size);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TasksApi#getAllTasksTasksListGet");
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
| **minLevel** | **Integer**| Minimum level. | [optional] |
| **maxLevel** | **Integer**| Maximum level. | [optional] |
| **skill** | [**Skill**](.md)| The code of the skill. | [optional] [enum: weaponcrafting, gearcrafting, jewelrycrafting, cooking, woodcutting, mining, alchemy, fishing] |
| **type** | [**TaskType**](.md)| The type of tasks. | [optional] [enum: monsters, items] |
| **page** | **Integer**| Page number | [optional] [default to 1] |
| **size** | **Integer**| Page size | [optional] [default to 50] |

### Return type

[**DataPageTaskFullSchema**](DataPageTaskFullSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched tasks details. |  -  |

<a id="getTaskTasksListCodeGet"></a>
# **getTaskTasksListCodeGet**
> TaskFullResponseSchema getTaskTasksListCodeGet(code)

Get Task

Retrieve the details of a task.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.TasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    TasksApi apiInstance = new TasksApi(defaultClient);
    String code = "code_example"; // String | The code of the task.
    try {
      TaskFullResponseSchema result = apiInstance.getTaskTasksListCodeGet(code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TasksApi#getTaskTasksListCodeGet");
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
| **code** | **String**| The code of the task. | |

### Return type

[**TaskFullResponseSchema**](TaskFullResponseSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched task. |  -  |
| **404** | Task not found. |  -  |

<a id="getTasksRewardTasksRewardsCodeGet"></a>
# **getTasksRewardTasksRewardsCodeGet**
> RewardResponseSchema getTasksRewardTasksRewardsCodeGet(code)

Get Tasks Reward

Retrieve the details of a tasks reward.

### Example
```java
// Import classes:
import org.openapitools.ApiClient;
import org.openapitools.ApiException;
import org.openapitools.Configuration;
import org.openapitools.models.*;
import org.openapitools.client.TasksApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    TasksApi apiInstance = new TasksApi(defaultClient);
    String code = "code_example"; // String | The code of the tasks reward.
    try {
      RewardResponseSchema result = apiInstance.getTasksRewardTasksRewardsCodeGet(code);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TasksApi#getTasksRewardTasksRewardsCodeGet");
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
| **code** | **String**| The code of the tasks reward. | |

### Return type

[**RewardResponseSchema**](RewardResponseSchema.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successfully fetched tasks reward. |  -  |
| **404** | Tasks reward not found. |  -  |

