package com.example.chakiri.thetvdb.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.chakiri.thetvdb.R;
import com.example.chakiri.thetvdb.adapter.ActorAdapter;
import com.example.chakiri.thetvdb.model.actors.Actors;
import com.example.chakiri.thetvdb.model.actors.ActorsData;
import com.example.chakiri.thetvdb.utils.ApiService;
import com.example.chakiri.thetvdb.utils.Session;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**  * Created by chakiri */

public class ActorsActivity extends AppCompatActivity {

    ListView mListViewActorsResult;
    Long idSerieToDisplay;
    Context context = this;
    List<ActorsData> actorsResultDatas;
    Button returnButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actors);
        Intent intent = getIntent();

        idSerieToDisplay = Long.valueOf(intent.getStringExtra("id_serie"));
        returnButton = (Button) findViewById(R.id.return_button);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String token = prefs.getString("jwt_token", "");

        ApiService api = Session.getRetrofitInstance().create(ApiService.class);

        Call<Actors> call = api.getActors("Bearer " + token, idSerieToDisplay);
        call.enqueue(new Callback<Actors>() {
            @Override
            public void onResponse(Call<Actors> call, Response<Actors> response) {
                mListViewActorsResult = (ListView) findViewById(R.id.listViewActorsResult);
                actorsResultDatas = response.body().getData();
                ActorAdapter adapter = new ActorAdapter(ActorsActivity.this, actorsResultDatas);
                mListViewActorsResult.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Actors> call, Throwable t) {

            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActorsActivity.this, SerieActivity.class);
                intent.putExtra("id_serie", idSerieToDisplay.toString());
                startActivity(intent);
            }
        });
    }
}
