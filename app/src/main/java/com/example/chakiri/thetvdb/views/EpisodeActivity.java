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
import com.example.chakiri.thetvdb.adapter.EpisodeAdapter;
import com.example.chakiri.thetvdb.model.episode.Episode;
import com.example.chakiri.thetvdb.model.episode.EpisodeData;
import com.example.chakiri.thetvdb.utils.ApiService;
import com.example.chakiri.thetvdb.utils.Session;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**  * Created by chakiri */

public class EpisodeActivity extends AppCompatActivity {

    ListView mListViewEpisodeResult;
    Long idSerieToDisplay;
    Context context = this;
    List<EpisodeData> episodeResultDatas;
    Button returnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode);
        Intent intent = getIntent();

        idSerieToDisplay = Long.valueOf(intent.getStringExtra("id_serie"));
        returnButton = (Button) findViewById(R.id.return_button);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String token = prefs.getString("jwt_token", "");

        ApiService api = Session.getRetrofitInstance().create(ApiService.class);

        Call<Episode> call = api.getEpisode("Bearer " + token, idSerieToDisplay);
        call.enqueue(new Callback<Episode>() {
            @Override
            public void onResponse(Call<Episode> call, Response<Episode> response) {
                mListViewEpisodeResult = (ListView) findViewById(R.id.listViewEpisodeResult);
                episodeResultDatas = response.body().getData();
                EpisodeAdapter adapter = new EpisodeAdapter(EpisodeActivity.this, episodeResultDatas);
                mListViewEpisodeResult.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Episode> call, Throwable t) {

            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EpisodeActivity.this, SerieActivity.class);
                intent.putExtra("id_serie", idSerieToDisplay.toString());
                startActivity(intent);
            }
        });
    }
}
