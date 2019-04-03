package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwich = new JSONObject(json);
            JSONObject name = sandwich.getJSONObject("name");

            String  mainName = name.getString("mainName");
            Log.d("TAG",mainName);

            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAsList = new ArrayList<>();
            for(int i = 0; i < alsoKnownAs.length(); i++){
                alsoKnownAsList.add(alsoKnownAs.getString(i));
            }

            String placeOfOrigin = sandwich.getString("placeOfOrigin");
            String description = sandwich.getString("description");
            String image = sandwich.getString("image");

            JSONArray ingredients = name.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();
            for(int i = 0; i < ingredients.length(); i++){
                ingredientsList.add(ingredients.getString(i));
            }

            return new Sandwich(mainName,alsoKnownAsList,placeOfOrigin,description,image,ingredientsList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}