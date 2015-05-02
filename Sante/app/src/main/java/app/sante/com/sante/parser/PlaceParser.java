package app.sante.com.sante.parser;

import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;

import app.sante.com.sante.model.Place;

/**
 * Created by girishk on 26/04/15.
 */
public final class PlaceParser {

    public static ArrayList<Place> parseGetPlacesRequest (JSONObject jsonPlaces) {

        ArrayList<Place> mPlaces = new ArrayList<Place>();

        //TODO make parsing logic

        Log.d("Parser",jsonPlaces.toString());

        return mPlaces;

    }

}


