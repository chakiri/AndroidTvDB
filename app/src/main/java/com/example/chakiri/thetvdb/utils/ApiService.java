package com.example.chakiri.thetvdb.utils;

import com.example.chakiri.thetvdb.model.Authentication;
import com.example.chakiri.thetvdb.model.Token;
import com.example.chakiri.thetvdb.model.actors.Actors;
import com.example.chakiri.thetvdb.model.episode.Episode;
import com.example.chakiri.thetvdb.model.searchResult.SearchResult;
import com.example.chakiri.thetvdb.model.serieInfo.SerieIdInfo;
import com.example.chakiri.thetvdb.model.serieInfo.SerieInfo;
import com.example.chakiri.thetvdb.model.userInfo.UserInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by steve on 20/01/2018.
 */

public interface ApiService {
    @POST("login")
    Call<Token> login(@Body Authentication authentication);

    @GET("user")
    Call<UserInfo> getUserInfo(@Header("Authorization") String token);

    @GET("updated/query")
    Call<SerieIdInfo> getIdLastSeries(@Header("Authorization") String token, @Query(value = "fromTime") String fromTime);

    @GET("series/{id}")
    Call<SerieInfo> getSerie(@Header("Authorization") String token, @Path(value = "id") Long id);

    @GET("search/series")
    Call<SearchResult> getSearchResultByName(@Header("Authorization") String token, @Query(value = "name") String name);

    @GET("search/series")
    Call<SearchResult> getSearchResultByImdbId(@Header("Authorization") String token, @Query(value = "imdbId") String imdbId);

    @GET("series/{id}/episodes")
    Call<Episode> getEpisode(@Header("Authorization") String token, @Path(value = "id") Long id);

    @GET("series/{id}/actors")
    Call<Actors> getActors(@Header("Authorization") String token, @Path(value = "id") Long id);
}
