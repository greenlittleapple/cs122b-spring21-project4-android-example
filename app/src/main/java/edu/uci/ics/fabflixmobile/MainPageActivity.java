package edu.uci.ics.fabflixmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.CookieHandler;
import java.util.HashMap;
import java.util.Map;

public class MainPageActivity extends AppCompatActivity {

    private EditText searchQuery;
    private TextView message;
    private Button searchButton;

    /*
      In Android, localhost is the address of the device or the emulator.
      To connect to your machine, you need to use the below IP address
     */
    private final String host = "10.0.2.2";
    private final String port = "8443";
    private final String domain = "cs122b-spring21-project2-login-cart-example";
    private final String baseURL = "https://" + host + ":" + port + "/" + domain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // upon creation, inflate and initialize the layout
        setContentView(R.layout.main_page);
        searchQuery = findViewById(R.id.search);
        message = findViewById(R.id.message);
        searchButton = findViewById(R.id.searchBtn);

        //assign a listener to call a function to handle the user request when clicking a button
        searchButton.setOnClickListener(view -> search());
    }

    public void search() {

        // use the same network queue across our application
        final RequestQueue queue = NetworkManager.sharedManager(this).queue;
        // request type is POST
        final StringRequest loginRequest = new StringRequest(
                Request.Method.POST,
                baseURL + "/api/login",
                response -> {
                    Intent mainPage = new Intent(MainPageActivity.this, ListViewActivity.class);
                    startActivity(mainPage);
//                    try {
//                        JSONObject jsonResponse = new JSONObject(response);
//                        String status = jsonResponse.getString("status");
//                        String message = jsonResponse.getString("message");
//                        if(status.equals("success")) {
//                            Log.d("login.success", response);
//                            // initialize the activity(page)/destination
//                            Intent mainPage = new Intent(MainPageActivity.this, MainPageActivity.class);
//                            // activate the list page.
//                            startActivity(mainPage);
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
                },
                error -> {
                    // error
                    Log.d("login.error", error.toString());
                }) {
            @Override
            protected Map<String, String> getParams() {
                // POST request form data
                final Map<String, String> params = new HashMap<>();
                params.put("searchQuery", searchQuery.getText().toString());

                return params;
            }
        };

        // important: queue.add is where the login request is actually sent
        queue.add(loginRequest);

    }
}