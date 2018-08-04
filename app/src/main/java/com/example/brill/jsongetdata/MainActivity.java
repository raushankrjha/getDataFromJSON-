package com.example.brill.jsongetdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<GattersatterGenralKnowledge> GetDataAdapter1;

    RecyclerView recyclerView;

    RecyclerView.LayoutManager recyclerViewlayoutManager;

    RecyclerView.Adapter recyclerViewadapter;


    JsonArrayRequest jsonArrayRequest;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        GetDataAdapter1 = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(recyclerViewlayoutManager);




        JSON_DATA_WEB_CALL();


    }



    public void JSON_DATA_WEB_CALL(){


        String url="http://www.brilltechno.com/bdating/android/Intern/getAllUserData.php";

        Log.i("sad","url is --------------"+url);


        jsonArrayRequest = new JsonArrayRequest("http://www.brilltechno.com/bdating/android/Intern/getAllUserData.php",

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {


                        Log.i("sad","response is --------------"+response);


                        JSON_PARSE_DATA_AFTER_WEBCALL(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(jsonArrayRequest);
    }

    public void JSON_PARSE_DATA_AFTER_WEBCALL(JSONArray array){

        Log.i("","asdf array length"+array.length());


        for(int i = 0; i<array.length(); i++) {

            GattersatterGenralKnowledge GetDataAdapter2 = new GattersatterGenralKnowledge();

            JSONObject json = null;
            try {
                json = array.getJSONObject(i);

                GetDataAdapter2.setStrname(json.getString("name"));
                // GetDataAdapter2.setId(json.getInt(JSON_ID));
                GetDataAdapter2.setStremail(json.getString("email"));
                GetDataAdapter2.setStrphone(json.getString("phone"));

                Log.i("","asdf asdaasdfasf"+json.getString("name")+"email==="+json.getString("email")+"phone==="+json.getString("phone"));

                //  GetDataAdapter2.setName(json.getString(JSON_NAME));

                // GetDataAdapter2.setSubject(json.getString(JSON_SUBJECT));

                // GetDataAdapter2.setPhone_number(json.getString(JSON_PHONE_NUMBER));

            } catch (JSONException e) {

                e.printStackTrace();
            }
            GetDataAdapter1.add(GetDataAdapter2);
        }

        recyclerViewadapter = new GeneralKnowledgeAdapter(GetDataAdapter1, this);

        recyclerView.setAdapter(recyclerViewadapter);
    }
}
