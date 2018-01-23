package com.example.chakiri.thetvdb.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.example.chakiri.thetvdb.R;
import com.example.chakiri.thetvdb.adapter.SearchResultAdapter;
import com.example.chakiri.thetvdb.model.searchResult.SearchResult;
import com.example.chakiri.thetvdb.model.searchResult.SearchResultData;
import com.example.chakiri.thetvdb.utils.ApiService;
import com.example.chakiri.thetvdb.utils.Session;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**  * Created by chakiri */

public class SearchActivity extends AppCompatActivity {

    GridView mListViewSearchResult;
    EditText nameInputEditText;
    EditText imdbIdInputEditText;
    Context context = this;
    List<SearchResultData> searchResultDatas;
    Call<SearchResult> call;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        final Button searchButton = (Button) findViewById(R.id.search_button_page);
        final Button returnButton = (Button) findViewById(R.id.return_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
                String token = prefs.getString("jwt_token", "");

                ApiService api = Session.getRetrofitInstance().create(ApiService.class);
                nameInputEditText = (EditText) findViewById(R.id.search_input);

                call = api.getSearchResultByName("Bearer " + token, nameInputEditText.getText().toString());

                call.enqueue(new Callback<SearchResult>() {

                    @Override
                    public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                        mListViewSearchResult = (GridView) findViewById(R.id.listViewSearchResult);
                        searchResultDatas = response.body().getData();
                        SearchResultAdapter adapter = new SearchResultAdapter(SearchActivity.this, searchResultDatas);
                        mListViewSearchResult.setAdapter(adapter);
                        mListViewSearchResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Intent searchIntent = new Intent(SearchActivity.this, SerieActivity.class);
                                searchIntent.putExtra("id_serie", searchResultDatas.get(i).getId().toString());
                                startActivity(searchIntent);
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<SearchResult> call, Throwable t) {

                    }
                });
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
