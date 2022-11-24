package com.deeplabstudio.multiurljson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.deeplabstudio.multijson.MultiJSON;
import com.deeplabstudio.multijson.RequestCreator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}