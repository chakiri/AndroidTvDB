package com.example.chakiri.thetvdb.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chakiri.thetvdb.R;
import com.example.chakiri.thetvdb.model.serieInfo.SerieInfo;
import com.example.chakiri.thetvdb.utils.ApiService;
import com.example.chakiri.thetvdb.utils.Session;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**  * Created by chakiri */

public class SerieActivity extends AppCompatActivity {
    TextView id;
    TextView rating;
    Button episodeButton;
    Button actorsButton;
    Button returnButton;
    ImageView serieBanner;
    Context context = this;
    Long idSerieToDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie);

        rating = (TextView) findViewById(R.id.rating_serie_value);
        serieBanner = (ImageView) findViewById(R.id.serie_banner);
        returnButton = (Button) findViewById(R.id.return_button);
        episodeButton = (Button) findViewById(R.id.episode_button);
        actorsButton = (Button) findViewById(R.id.actors_button);
        Intent intent = getIntent();

        idSerieToDisplay = Long.valueOf(intent.getStringExtra("id_serie"));

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String token = prefs.getString("jwt_token", "");

        ApiService api = Session.getRetrofitInstance().create(ApiService.class);
        Call<SerieInfo> call = api.getSerie("Bearer " + token, idSerieToDisplay);
        call.enqueue(new Callback<SerieInfo>() {

            @Override
            public void onResponse(Call<SerieInfo> call, Response<SerieInfo> response) {
                rating.setText(response.body().getData().getSiteRating().toString());
                Picasso.with(context).load("https://www.thetvdb.com/banners/_cache/" + response.body().getData().getBanner()).into(serieBanner);
            }

            @Override
            public void onFailure(Call<SerieInfo> call, Throwable t) {

            }
        });

        episodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SerieActivity.this, EpisodeActivity.class);
                intent.putExtra("id_serie", idSerieToDisplay.toString());
                startActivity(intent);
            }
        });

        actorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SerieActivity.this, ActorsActivity.class);
                intent.putExtra("id_serie", idSerieToDisplay.toString());
                startActivity(intent);
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SerieActivity.this, SearchActivity.class);
                intent.putExtra("id_serie", idSerieToDisplay.toString());
                startActivity(intent);
            }
        });
    }
}
