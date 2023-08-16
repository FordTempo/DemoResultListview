package sg.edu.rp.c346.demoresultlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvResult;

    AsyncHttpClient client;

    ArrayList<Result> alResult = new ArrayList<Result>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvResult = findViewById(R.id.listViewResult);

        client = new AsyncHttpClient();
        adapter= new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,alResult);
        lvResult.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=fdd36db3-3317-4790-8c27-8e58f7dd1a42", new JsonHttpResponseHandler() {
            String Year;
            String Type_of_Study;
            String Enrolment;

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, JSONObject response) {
                try {
                    JSONObject firstObj = response.getJSONObject("result");
                    JSONArray jsonArrRecords = firstObj.getJSONArray("records");
                    for(int i = 0; i < jsonArrRecords.length(); i++) {
                        JSONObject jsonObjForecast = jsonArrRecords.getJSONObject(i);
                        Year = jsonObjForecast.getString("year");
                        Type_of_Study = jsonObjForecast.getString("type_of_study");
                        Enrolment = jsonObjForecast.getString("enrolment");
                        Result Result = new Result(Year, Type_of_Study, Enrolment);
                        alResult.add(Result);
                    }
                    adapter.notifyDataSetChanged();
                }
                catch(JSONException e){
                }



            }//end onSuccess
        });
    }//end onResume
}

