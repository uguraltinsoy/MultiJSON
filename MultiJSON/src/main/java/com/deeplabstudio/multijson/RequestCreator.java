package com.deeplabstudio.multijson;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.view.Gravity;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class RequestCreator {
    private final MultiJSON multiJSON;
    private final String url;
    private boolean POST = false;
    private HashMap<String, String> requestProperty = new HashMap<>();
    private JsonObject jsonObjectListener;
    private JsonArray jsonArrayListener;


    RequestCreator(MultiJSON multiJSON, String url) {
        this.multiJSON = multiJSON;
        this.url = url;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public RequestCreator addProperty(HashMap<String, String> requestProperty) {
        if (requestProperty.size() > 0) requestProperty.clear();
        this.requestProperty = requestProperty;
        return this;
    }

    public void setOnListener(@Nullable JsonObject listener) {
        this.jsonObjectListener = listener;
        getObject();
    }

    public void setOnListener(boolean POST, @Nullable JsonObject listener) {
        this.jsonObjectListener = listener;
        this.POST = POST;
        getObject();
    }

    public void setOnListener(JSONObject json, @Nullable JsonObject listener) {
        this.jsonObjectListener = listener;
        getObject(json);
    }

    public void setOnListener(boolean POST, JSONObject json, @Nullable JsonObject listener) {
        this.jsonObjectListener = listener;
        this.POST = POST;
        getObject(json);
    }

    public void setOnListener(JSONArray json, @Nullable JsonObject listener) {
        this.jsonObjectListener = listener;
        getObject(json);
    }

    public void setOnListener(boolean POST, JSONArray json, @Nullable JsonObject listener) {
        this.jsonObjectListener = listener;
        this.POST = POST;
        getObject(json);
    }

    public void setOnListener(@Nullable JsonArray listener) {
        this.jsonArrayListener = listener;
        getArray();
    }

    public void setOnListener(boolean POST, @Nullable JsonArray listener) {
        this.jsonArrayListener = listener;
        this.POST = POST;
        getArray();
    }


    public void setOnListener(JSONObject json, @Nullable JsonArray listener) {
        this.jsonArrayListener = listener;
        getArray(json);
    }

    public void setOnListener(boolean POST, JSONObject json, @Nullable JsonArray listener) {
        this.jsonArrayListener = listener;
        this.POST = POST;
        getArray(json);
    }

    public void setOnListener(JSONArray json, @Nullable JsonArray listener) {
        this.jsonArrayListener = listener;
        getArray(json);
    }

    public void setOnListener(boolean POST, JSONArray json, @Nullable JsonArray listener) {
        this.jsonArrayListener = listener;
        this.POST = POST;
        getArray(json);
    }

    public interface JsonObject {
        void Result(JSONObject jsonObject, String response) throws JSONException;

        void Error(String error);
    }

    public interface JsonArray {
        void Result(JSONArray jsonArray, String response) throws JSONException;

        void Error(String error);
    }

    @SuppressLint("NewApi")
    private void getObject() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuilder result = new StringBuilder();
                    HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                    if (requestProperty.size() > 0) {
                        requestProperty.forEach((key, value) -> {
                            conn.setRequestProperty(key, value);
                        });
                    }
                    if (POST) conn.setRequestMethod("POST");
                    InputStream in = new BufferedInputStream(conn.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    String inputLine;
                    while ((inputLine = reader.readLine()) != null) {
                        result.append(inputLine);
                    }
                    if (jsonObjectListener != null)
                        jsonObjectListener.Result(new JSONObject(result.toString()), result.toString());
                } catch (Exception e) {
                    if (jsonObjectListener != null) jsonObjectListener.Error(e.getMessage());
                }
            }
        }).start();
    }

    @SuppressLint("NewApi")
    private void getObject(JSONObject json) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuilder result = new StringBuilder();
                    HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                    if (requestProperty.size() > 0) {
                        requestProperty.forEach((key, value) -> {
                            conn.setRequestProperty(key, value);
                        });
                    }
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    if (POST) conn.setRequestMethod("POST");

                    OutputStream os = conn.getOutputStream();
                    os.write(json.toString().getBytes("UTF-8"));
                    os.close();

                    InputStream in = new BufferedInputStream(conn.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    String inputLine;
                    while ((inputLine = reader.readLine()) != null) {
                        result.append(inputLine);
                    }
                    if (jsonObjectListener != null)
                        jsonObjectListener.Result(new JSONObject(result.toString()), result.toString());
                } catch (Exception e) {
                    if (jsonObjectListener != null) jsonObjectListener.Error(e.getMessage());
                }
            }
        }).start();
    }

    @SuppressLint("NewApi")
    private void getObject(JSONArray json) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuilder result = new StringBuilder();
                    HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                    if (requestProperty.size() > 0) {
                        requestProperty.forEach((key, value) -> {
                            conn.setRequestProperty(key, value);
                        });
                    }
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    if (POST) conn.setRequestMethod("POST");

                    OutputStream os = conn.getOutputStream();
                    os.write(json.toString().getBytes("UTF-8"));
                    os.close();

                    InputStream in = new BufferedInputStream(conn.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    String inputLine;
                    while ((inputLine = reader.readLine()) != null) {
                        result.append(inputLine);
                    }
                    if (jsonObjectListener != null)
                        jsonObjectListener.Result(new JSONObject(result.toString()), result.toString());
                } catch (Exception e) {
                    if (jsonObjectListener != null) jsonObjectListener.Error(e.getMessage());
                }
            }
        }).start();
    }

    @SuppressLint("NewApi")
    private void getArray() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuilder result = new StringBuilder();
                    HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                    if (requestProperty.size() > 0) {
                        requestProperty.forEach((key, value) -> {
                            conn.setRequestProperty(key, value);
                        });
                    }
                    if (POST) conn.setRequestMethod("POST");

                    InputStream in = new BufferedInputStream(conn.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    String inputLine;
                    while ((inputLine = reader.readLine()) != null) {
                        result.append(inputLine);
                    }
                    if (jsonArrayListener != null)
                        jsonArrayListener.Result(new JSONArray(result.toString()), result.toString());
                } catch (Exception e) {
                    if (jsonArrayListener != null) jsonArrayListener.Error(e.getMessage());
                }
            }
        }).start();
    }

    @SuppressLint("NewApi")
    private void getArray(JSONObject json) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuilder result = new StringBuilder();
                    HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                    if (requestProperty.size() > 0) {
                        requestProperty.forEach((key, value) -> {
                            conn.setRequestProperty(key, value);
                        });
                    }
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    if (POST) conn.setRequestMethod("POST");

                    OutputStream os = conn.getOutputStream();
                    os.write(json.toString().getBytes("UTF-8"));
                    os.close();

                    InputStream in = new BufferedInputStream(conn.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    String inputLine;
                    while ((inputLine = reader.readLine()) != null) {
                        result.append(inputLine);
                    }
                    if (jsonArrayListener != null)
                        jsonArrayListener.Result(new JSONArray(result.toString()), result.toString());
                } catch (Exception e) {
                    if (jsonArrayListener != null) jsonArrayListener.Error(e.getMessage());
                }
            }
        }).start();
    }

    @SuppressLint("NewApi")
    private void getArray(JSONArray json) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuilder result = new StringBuilder();
                    HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                    if (requestProperty.size() > 0) {
                        requestProperty.forEach((key, value) -> {
                            conn.setRequestProperty(key, value);
                        });
                    }
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    if (POST) conn.setRequestMethod("POST");

                    OutputStream os = conn.getOutputStream();
                    os.write(json.toString().getBytes("UTF-8"));
                    os.close();

                    InputStream in = new BufferedInputStream(conn.getInputStream());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    String inputLine;
                    while ((inputLine = reader.readLine()) != null) {
                        result.append(inputLine);
                    }
                    if (jsonArrayListener != null)
                        jsonArrayListener.Result(new JSONArray(result.toString()), result.toString());
                } catch (Exception e) {
                    if (jsonArrayListener != null) jsonArrayListener.Error(e.getMessage());
                }
            }
        }).start();
    }
}
