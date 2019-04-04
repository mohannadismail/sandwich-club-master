package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static final String KEY_MAIN_NAME = "mainName";
    public static final String KEY_ALSO_KNOWN_AS = "alsoKnownAs";
    public static final String KEY_PLACE_OF_ORIGIN = "placeOfOrigin";
    public static final String KEY_DESCRIPTION= "description";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject sandwich = new JSONObject(json);
            JSONObject name = sandwich.getJSONObject("name");

            String  mainName = name.getString(KEY_MAIN_NAME);

            JSONArray alsoKnownAs = name.getJSONArray(KEY_ALSO_KNOWN_AS);
            ArrayList<String> alsoKnownAsList = new ArrayList<>();
            for(int i = 0; i < alsoKnownAs.length(); i++){
                alsoKnownAsList.add(alsoKnownAs.getString(i));
            }


            String placeOfOrigin = sandwich.getString(KEY_PLACE_OF_ORIGIN);
            String description = sandwich.getString(KEY_DESCRIPTION);
            String image = sandwich.getString(KEY_IMAGE);

            JSONArray ingredients = sandwich.getJSONArray(KEY_INGREDIENTS);
            ArrayList<String> ingredientsList = new ArrayList<>();
            for(int j = 0; j < ingredients.length(); j++){
                ingredientsList.add(ingredients.getString(j));
            }

            return new Sandwich(mainName,alsoKnownAsList,placeOfOrigin,description,image,ingredientsList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
