package com.deeplabstudio.multiurljson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.deeplabstudio.multijson.MultiJSON
import com.deeplabstudio.multijson.RequestCreator.JsonObject
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class KotlinMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_main)
    }
}