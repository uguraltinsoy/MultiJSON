# Android MultiJSON

### AndroidManifest
```xml
 <uses-permission android:name="android.permission.INTERNET"/>
```
## Download
### Build Gradle
```css
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
```css
dependencies {
	implementation 'com.github.uguraltinsoy:MultiJSON:1.0.1'
}
```
## Usage Java - Kotlin

## GET DATA

### GET String Json with URL

Java
```Java
MultiJSON.init().load("<Source Url>").setOnListener(new RequestCreator.JsonObject() {  
  @Override  
  public void Result(JSONObject jsonObject, String json) throws JSONException {  
   
  }  
  
  @Override  
  public void Error(String error) {  
   
  }  
});
```
Kotlin
```Kotlin
MultiJSON.init().load("<Source Url>").setOnListener(object : JsonObject {  
    @Throws(JSONException::class)  
    override fun Result(jsonObject: JSONObject, json: String) {  
         
    }  
  
    override fun Error(error: String) {  
           
    }  
})
```
### GET String Json with Request Property or Header
Java
```Java
HashMap<String, String> property = new HashMap<>();  
property.put("X-PCK", "API_KEY");  
property.put("User-Agent", "Mozilla/5.0");  
property.put("Content-type", "application/json");
```
```Java
MultiJSON.init().load("<Source Url>").addProperty(property).setOnListener(new RequestCreator.JsonObject() {  
  @Override  
  public void Result(JSONObject jsonObject, String json) throws JSONException {  
  
  } 
   
  @Override  
  public void Error(String error) {  
  
  }
 });
```
Kotlin
```Kotlin
val property = HashMap<String, String>()  
property["X-PCK"] = "API_KEY"  
property["User-Agent"] = "Mozilla/5.0"  
property["Content-type"] = "application/json"
```
```Kotlin
MultiJSON.init().load("<Source Url>").addProperty(property).setOnListener(object : JsonObject {  
  @Throws(JSONException::class)  
  override fun Result(jsonObject: JSONObject, json: String) {
    
  }  
  
  override fun Error(error: String) {
  
  }  
})
```
## POST DATA
### POST to URL
Java
```Java
MultiJSON.init().load("<Source Url>").setOnListener(true, new RequestCreator.JsonObject() {  
  @Override  
  public void Result(JSONObject jsonObject, String json) throws JSONException {  
  
  }  
  
  @Override  
  public void Error(String error) {  
  
  }
 });
```
Kotlin
```Kotlin
MultiJSON.init().load("<Source Url>").setOnListener(true, object : JsonObject {  
  @Throws(JSONException::class)  
  override fun Result(jsonObject: JSONObject, json: String) {
    
  }  
  
  override fun Error(error: String) {

  }  
})
```
### Send POST with Request Attribute or Header
Java
```Java
HashMap<String, String> property = new HashMap<>();  
property.put("X-PCK", "API_KEY");  
property.put("User-Agent", "Mozilla/5.0");  
property.put("Content-type", "application/json");
```
```Java
MultiJSON.init().load("<Source Url>").addProperty(property).setOnListener(true, new RequestCreator.JsonObject() {  
  @Override  
  public void Result(JSONObject jsonObject, String json) throws JSONException {  
  
  }
  
  @Override  
  public void Error(String error) {  
  
  }
 });
```
Kotlin
```Kotlin
val property = HashMap<String, String>()  
property["X-PCK"] = "API_KEY"  
property["User-Agent"] = "Mozilla/5.0"  
property["Content-type"] = "application/json"
```
```Kotlin
MultiJSON.init().load("<Source Url>").addProperty(property).setOnListener(true, object : JsonObject {  
  @Throws(JSONException::class)  
  override fun Result(jsonObject: JSONObject, json: String) {
    
  }  
  
  override fun Error(error: String) {

  }  
})
```
### Send JSON POST
Java
```Java
// JSON OBJECT
JSONObject json = new JSONObject();  
json.put("param", "value");  
json.put("param", "value");  
json.put("param", "value");
```
OR
```Java
// JSON ARRAY
JSONArray json = new JSONArray(); 
json.put("param", "value");  
json.put("param", "value");  
json.put("param", "value");
```
```Java
MultiJSON.init().load("<Source Url>").setOnListener(true, json, new RequestCreator.JsonObject() {  
  @Override  
  public void Result(JSONObject jsonObject, String json) throws JSONException {  
  
  }  
  
  @Override  
  public void Error(String error) {  
  
  }
 });
```
Kotlin
```Kotlin
// JSON OBJECT
val json = JSONObject()  
json.put("param", "value")  
json.put("param", "value")  
json.put("param", "value")
```
OR
```Kotlin
// JSON ARRAY
val jsonArray = JSONArray()
json.put("param", "value")  
json.put("param", "value")  
json.put("param", "value")
```
```Kotlin
MultiJSON.init().load("<Source Url>").setOnListener(true, json, object : JsonObject {  
  @Throws(JSONException::class)  
  override fun Result(jsonObject: JSONObject, json: String) {  
  
  }  
  override fun Error(error: String) {
  
  }  
})
```
### JSON POST with Request Attribute or Header
Java
```Java
HashMap<String, String> property = new HashMap<>();  
property.put("X-PCK", "API_KEY");  
property.put("User-Agent", "Mozilla/5.0");  
property.put("Content-type", "application/json");
```
AND
```Java
// JSON OBJECT
JSONObject json = new JSONObject();  
json.put("param", "value");  
json.put("param", "value");  
json.put("param", "value");
```
OR
```Java
// JSON ARRAY
JSONArray json = new JSONArray(); 
json.put("param", "value");  
json.put("param", "value");  
json.put("param", "value");
```
```Java
MultiJSON.init().load("<Source Url>").addProperty(property).setOnListener(true, json, new RequestCreator.JsonObject() {  
  @Override  
  public void Result(JSONObject jsonObject, String json) throws JSONException {  
  
  }  
  
  @Override  
  public void Error(String error) {  
  
  }
 });
```
Kotlin
```Kotlin
val property = HashMap<String, String>()  
property["X-PCK"] = "API_KEY"  
property["User-Agent"] = "Mozilla/5.0"  
property["Content-type"] = "application/json"
```
AND
```Kotlin
// JSON OBJECT
val json = JSONObject()  
json.put("param", "value")  
json.put("param", "value")  
json.put("param", "value")
```
OR
```Kotlin
// JSON ARRAY
val jsonArray = JSONArray()
json.put("param", "value")  
json.put("param", "value")  
json.put("param", "value")
```
```Kotlin
MultiJSON.init().load("<Source Url>").addProperty(property).setOnListener(true, json, object : JsonObject {  
  @Throws(JSONException::class)  
  override fun Result(jsonObject: JSONObject, json: String) {  
  
  }  
  override fun Error(error: String) {
  
  }  
})
```
### Developer By
```
Uğur Altınsoy
```

### Donate
```
BTC  : 1N7V3wX4xvGfwgBP1zQrcMSxohKKfiDxyH
ETH  : 0x0df6da87e219fb4854e933f1071ad91d17afa517
XRP  : rEb8TK3gBgk5auZkwc6sHnwrGVJH8DuaLh
DOGE : DKKmSHAa8GhAE5HNjmCXzkXPKTjpybY3mq
DENT : 0x0df6da87e219fb4854e933f1071ad91d17afa517
```

### Social
[![Twitter](https://img.shields.io/badge/twitter-%231DA1F2.svg?&style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/uguraltnsy)
[![Instagram](https://img.shields.io/badge/instagram-%23E4405F.svg?&style=for-the-badge&logo=instagram&logoColor=white)](https://www.instagram.com/ugur.altnsy)
[![Linkedin](https://img.shields.io/badge/linkedin-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/uğur-altınsoy/)
[![Google Play](https://img.shields.io/badge/Google%20Play-414141?logo=google-play&logoColor=white&style=for-the-badge)](https://play.google.com/store/apps/developer?id=DeepLab&hl=tr)
