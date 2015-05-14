package app.sante.com.sante.api;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;

import app.sante.com.sante.VolleyCallback;
import app.sante.com.sante.network.NetworkManager;
import app.sante.com.sante.parser.PlaceParser;
import app.sante.com.sante.util.URLConstants;


/**
 * Created by girishk on 26/04/15.
 */
public final class PlacesAPI {

    private static ArrayList<app.sante.com.sante.model.Place> data ;
    public static ArrayList<app.sante.com.sante.model.Place> getPlacesForLocation(Context mContext, String location, final VolleyCallback callback){

        String requestURL = URLConstants.BASE_URL + URLConstants.GET_LOCALE_PLACES + location + URLConstants.RESOURCE_FORMAT;

        Log.d("API",":: request url :: " + requestURL);

        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(Request.Method.GET,requestURL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                Log.d("API-RESP",PlaceParser.parseGetPlacesRequest(response).toString());
                data = PlaceParser.parseGetPlacesRequest(response);
                callback.onSuccess(data);
                Log.e("error",data.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("Error",":: Volley Error :: " + error);

            }
        });



        //Making network request
        NetworkManager.getInstance(mContext).getRequestQueue().add(jsonArrayRequest);

        return data;

    }


}