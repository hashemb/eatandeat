package com.example.hashem.eatandeat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    public ArrayList<table> AllTables;
    private ArrayList<reserve> AllReservations;
    private ArrayList<user> AllUsers;
    private Context context;
    private String key;
	
	private static String URL_IP = "192.168.1.104";


    public Restaurant(Context context) {
        this.context = context;
        AllTables = new ArrayList<table>();
        AllReservations = new ArrayList<reserve>();
        AllUsers = new ArrayList<user>();
    }


    public void setKey(String key) {
        this.key = key;
    }


    public void getTableNBSeats(int id) {
        String url = "http://" + URL_IP + "/hashem/getNBSeats.php?id=" + id;
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        // Request a json response from the provided URL.
        StringRequest jsonRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String name) {Toast.makeText(context, "Table name: " + name, Toast.LENGTH_SHORT).show();}
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("error", error.toString());
                    }
                });
        // Add the request to the RequestQueue.
        queue.add(jsonRequest);
    }

    public void getAllTables(final Spinner spAllTables) {
        String url = "http://" + URL_IP + "/hashem/getTables.php";

        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonRequest = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray ja) {
                        AllTables.clear();
                        try {
                            for (int i = 0;i < ja.length();i++) {
                                JSONObject st = ja.getJSONObject(i);
                                int tid = Integer.parseInt(st.getString("tid"));
                                int nbOfSeats = Integer.parseInt(st.getString("nbOfSeats"));
                                AllTables.add(new table(tid,nbOfSeats));

                            }
                            spAllTables.setAdapter(new ArrayAdapter<table>(context,
                                    android.R.layout.simple_list_item_1, AllTables));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i("error", error.toString());
            }
        });
        // Add the request to the RequestQueue.
        queue.add(jsonRequest);
    }

    //-----------------------------

    public void Reserve(reserve r){
        int rid = r.getRid(), id = r.getId(), tid=r.getTid(), isVIP= r.getIsVIP(), Kids=r.getKids(), paymentM=r.getPaymentM();
        Date date = r.getDate();
        Time stime = r.getStime(), etime = r.getEtime();
        String url = "http://" + URL_IP + "/hashem/reserve.php?id=" + id + "&tid=" + tid + "&date=" + date + "&stime=" + stime
                + "&etime=" + etime + "&isVIP=" +isVIP +"&Kids=" + Kids + "&paymentM=" +paymentM;
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest jsonRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {Toast.makeText(context, response, Toast.LENGTH_SHORT).show();}
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("error", error.toString());
                    }
                });
        queue.add(jsonRequest);
    }

//-----------------------------

    public void signup(user u) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        final int id = u.getId();
        final String username = u.getUsername();
        final String password = u.getPassword();

        String url = "http://" + URL_IP + "/hashem/signup.php?username=" + username + "&password=" + password;

        StringRequest jsonRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {Toast.makeText(context, response.replace("ï»¿", ""), Toast.LENGTH_SHORT).show();}
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("error", error.toString());
                    }
                });
        queue.add(jsonRequest);
    }

    public void signin(String username, String password, final Class context1) {
        String url = "http://" + URL_IP + "/hashem/signin.php?username=" + username+"&password="+password;
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        // Request a json response from the provided URL.
        StringRequest jsonRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String id) {
                        if(!id.isEmpty()){
                            Intent i = new Intent(context, context1);
                            i.putExtra("id", id);
                            context.startActivity(i);
                        }
                        else Toast.makeText(context, "Username or Password are invalid!", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("error", error.toString());
                    }
                });
        // Add the request to the RequestQueue.
        queue.add(jsonRequest);
    }

}