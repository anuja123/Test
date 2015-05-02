package app.sante.com.sante.api;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;

import app.sante.com.sante.model.Place;
import app.sante.com.sante.network.NetworkManager;
import app.sante.com.sante.parser.PlaceParser;
import app.sante.com.sante.util.URLConstants;


/**
 * Created by girishk on 26/04/15.
 */
public final class PlacesAPI {


    public static ArrayList<Place> getPlacesForLocation(Context mContext , String location){

        String requestURL = URLConstants.BASE_URL + URLConstants.GET_LOCALE_PLACES + location + URLConstants.RESOURCE_FORMAT;

            Log.d("API",":: request url :: " + requestURL);

        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(Request.Method.GET,requestURL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Log.d("API-RESP",PlaceParser.parseGetPlacesRequest(response).toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

               Log.e("Error",":: Volley Error :: " + error);

            }
        });

        //Making network request
        NetworkManager.getInstance(mContext).getRequestQueue().add(jsonArrayRequest);

        return null;

    }


}
