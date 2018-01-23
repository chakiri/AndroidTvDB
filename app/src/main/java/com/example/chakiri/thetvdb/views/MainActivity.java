package com.example.chakiri.thetvdb.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.chakiri.thetvdb.R;
import com.example.chakiri.thetvdb.model.Authentication;
import com.example.chakiri.thetvdb.model.serieInfo.SerieIdInfoData;
import com.example.chakiri.thetvdb.model.Token;
import com.example.chakiri.thetvdb.utils.ApiService;
import com.example.chakiri.thetvdb.utils.Session;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String token;
    List<SerieIdInfoData> serieIdInfoData;
    Context context = this;
    ApiService api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        api = Session.getRetrofitInstance().create(ApiService.class);

        Call<Token> call = api.login(new Authentication());

        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                token = response.body().getToken();
                PreferenceManager.getDefaultSharedPreferences(context).edit().putString("jwt_token", token).apply();

                final Button searchButton = (Button) findViewById(R.id.search_button);
                searchButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent searchIntent = new Intent(MainActivity.this, SearchActivity.class);
                        startActivity(searchIntent);
                    }
                });
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
            }
        });
    }
}
