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

        try{
            JSONObject jsonObject  = new JSONObject();
            jsonObject.put("name", "ugur");
            jsonObject.put("surname", "Altinsoy");
            MultiJSON.init().load("https://api.deeplabstudio.com/test.php").setOnListener(jsonObject, new RequestCreator.JsonObject() {
                @Override
                public void Result(JSONObject jsonObject, String json) throws JSONException {
                    System.out.println("BB " + json);
                }

                @Override
                public void Error(String error) {
                    System.out.println("BB ER " + error);
                }
            });
        }catch (Exception e){

        }
    }
}