package com.deeplabstudio.multijson;

import androidx.annotation.Nullable;

public class MultiJSON {
    private static MultiJSON multiJSON;
    private String url;

    public static MultiJSON init() {
        multiJSON = new MultiJSON();
        return multiJSON;
    }


    public RequestCreator load(@Nullable String url) {
        return new RequestCreator(this, url);
    }
}
