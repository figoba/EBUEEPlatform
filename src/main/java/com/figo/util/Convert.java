package com.figo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by FigoBa on 2017/7/31.
 */
public class Convert {
    public static String toJson(Object object){
        Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
        return g.toJson(object);
    }
}
