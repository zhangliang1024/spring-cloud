
<a name="paths"></a>
## 资源

<a name="user-controller_resource"></a>
### User-controller
User Controller


<a name="adduserusingpost"></a>
#### 添加用户信息
```
POST /user/add
```


##### 说明
添加用户信息


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|integer (int32)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `application/json;charset=UTF-8`


##### HTTP请求示例

###### 请求 path
```
/user/add
```


##### HTTP响应示例

###### 响应 200
```json
0
```


<a name="findalluserusingget"></a>
#### 查看信息
```
GET /user/all/{pageNum}/{pageSize}
```


##### 说明
查看用户信息


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**pageNum**  <br>*必填*|页码|integer (int32)|
|**Path**|**pageSize**  <br>*必填*|每页个数|integer (int32)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|object|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 生成

* `application/json;charset=UTF-8`


##### HTTP请求示例

###### 请求 path
```
/user/all/0/0
```


##### HTTP响应示例

###### 响应 200
```json
"object"
```



