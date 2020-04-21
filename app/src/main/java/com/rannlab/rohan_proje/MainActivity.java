package com.rannlab.rohan_proje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText ssc,hsc,ufy,usy,uty,pfy,psy,pty;
    String sssc,shsc,sufy,suty,susy,spfu,spsy,spty;
    Button showbtn,savebtn;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inti();

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                api();
            }
        });

    }

    private void api() {

        requestQueue= Volley.newRequestQueue(getApplicationContext());
        String url="https://mcoeplacement.000webhostapp.com/register.php";
       // HashMap<String,String> map=new HashMap<>();
        sssc=ssc.getText().toString().trim();
       shsc=hsc.getText().toString().trim();
        sufy=ufy.getText().toString().trim();
        susy=usy.getText().toString().trim();
        suty=uty.getText().toString().trim();


        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                map.put("ssc",sssc);
                map.put("hsc",shsc);
                map.put("ufy",sufy);
                map.put("usy",susy);
                map.put("uty",suty);

                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void inti() {
        ssc=findViewById(R.id.ssc);
        hsc=findViewById(R.id.hsc);
        pfy=findViewById(R.id.pfy);
        psy=findViewById(R.id.psy);
        pty=findViewById(R.id.pty);
        ufy=findViewById(R.id.ufy);
        usy=findViewById(R.id.usy);
        uty=findViewById(R.id.uty);
        savebtn=findViewById(R.id.save);
        showbtn=findViewById(R.id.show);
    }
}
