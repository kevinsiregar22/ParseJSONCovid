package com.example.parsejsoncovid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.parsejsoncovid.adaptercovid.GetAdapterCovid;
import com.example.parsejsoncovid.model.CovidData;
import com.example.parsejsoncovid.services.ApiClient;
import com.example.parsejsoncovid.services.GetRequestCovid;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCovid;
    private GetAdapterCovid adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCovid = findViewById(R.id.recyclerViewCovid);
        recyclerViewCovid.setHasFixedSize(true);
        recyclerViewCovid.setLayoutManager(new LinearLayoutManager(this));

        GetRequestCovid requestCovid = ApiClient.getRetrofitInstance().create(GetRequestCovid.class);
        Call<List<CovidData>> call = requestCovid.getAllCovidData();
        call.enqueue(new Callback<List<CovidData>>() {

            @Override
            public void onResponse(Call<List<CovidData>> call, Response<List<CovidData>> response) {
                generateDataCovidList(response.body());
            }

            @Override
            public void onFailure(Call<List<CovidData>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Upps... Ada Yang Salah Nih!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataCovidList(List<CovidData> coviddatalist){
        recyclerViewCovid = findViewById(R.id.recyclerViewCovid);
        adapter = new GetAdapterCovid(this, coviddatalist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerViewCovid.setLayoutManager(layoutManager);
        recyclerViewCovid.setAdapter(adapter);
    }

}