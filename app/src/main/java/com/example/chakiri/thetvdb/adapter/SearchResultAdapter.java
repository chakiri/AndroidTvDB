package com.example.chakiri.thetvdb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.chakiri.thetvdb.R;
import com.example.chakiri.thetvdb.model.searchResult.SearchResultData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**  * Created by chakiri */

public class SearchResultAdapter extends ArrayAdapter<SearchResultData> {

    Context context;

    public SearchResultAdapter(@NonNull Context context, List<SearchResultData> seriesResult) {
        super(context, 0, seriesResult);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.last_series_row,parent, false);
        }

        SeriesViewHolder viewHolder = (SeriesViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new SeriesViewHolder();
            viewHolder.image = (ImageView) convertView.findViewById(R.id.serie_image);
            convertView.setTag(viewHolder);
        }

        SearchResultData searchResult = getItem(position);
        Picasso.with(context).load("https://www.thetvdb.com/banners/_cache/" + searchResult.getBanner()).into(viewHolder.image);

        return convertView;
    }

    private class SeriesViewHolder{
        public ImageView image;
    }
}
