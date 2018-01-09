package com.cognizance.cognizance18.utilities;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by arihant on 9/1/18.
 */

public class StateWiseCollegeProvider {

    private String loadJSONFromAsset(Context ctx) {
        String json;
        try {
            InputStream is = ctx.getAssets().open("college.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public ArrayList<String> getStateList(Context ctx){
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(ctx));
            ArrayList<String> list = new ArrayList<>();
            Iterator<String> keys = obj.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                list.add(key);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> getCollegesFromState(Context ctx, String state) {
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(ctx));
            JSONArray array = obj.getJSONArray(state);
            ArrayList<String> list = new ArrayList<>();
            for(int i=0;i<array.length();i++){
                list.add(array.getString(i));

            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
