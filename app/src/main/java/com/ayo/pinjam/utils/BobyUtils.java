package com.ayo.pinjam.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Set;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by yanshihao on 2018/1/16.
 */

public class BobyUtils {

    public static RequestBody getBoby(HashMap<String, Object> map) {
        JSONObject jsonObject = new JSONObject();
        Set<String> strings = map.keySet();
        try {
            for (String s : strings) {
                jsonObject.put(s, map.get(s));
            }
            RequestBody body=RequestBody.create(MediaType.parse("application/json")
                    ,jsonObject.toString());
            return body;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
