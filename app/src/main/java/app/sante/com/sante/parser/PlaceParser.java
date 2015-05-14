package app.sante.com.sante.parser;

/**
 * Created by anakade on 4/26/2015.
 */

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import app.sante.com.sante.model.Place;

/**
 * Created by girishk on 26/04/15.
 */
public final class PlaceParser {

    private static final String TAG_NAME = "Name";
    private static final String TAG_COST = "Cost Symbol";

    public static ArrayList<Place> parseGetPlacesRequest (JSONObject jsonPlaces) {

        ArrayList<Place> mPlaces = new ArrayList<>();
        Place pl ;
        //TODO make parsing logic

        Log.d("Parser",jsonPlaces.toString());
        try {
            String name = jsonPlaces.getString(TAG_NAME);

            String cost = jsonPlaces.getString(TAG_COST);

            Log.d("info",name + ".." +cost);
            pl = new Place(name,cost);
            mPlaces.add(pl);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        System.out.println(Place.name + "@@@@@@@@" + Place.costSymbol);
        //databaseHelper.savePubRecord(name,cstSymbol);
        Log.d("arrayList",mPlaces.get(0).toString());
        return mPlaces;

    }

}


