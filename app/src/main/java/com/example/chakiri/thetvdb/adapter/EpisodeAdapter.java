package com.example.chakiri.thetvdb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.chakiri.thetvdb.R;
import com.example.chakiri.thetvdb.model.episode.EpisodeData;

import java.util.List;

/**  * Created by chakiri */

public class EpisodeAdapter extends ArrayAdapter<EpisodeData> {
    Context context;

    public EpisodeAdapter(@NonNull Context context, List<EpisodeData> seriesResult) {
        super(context, 0, seriesResult);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.episode_row,parent, false);
        }

        SeriesViewHolder viewHolder = (SeriesViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new SeriesViewHolder();
            viewHolder.episodeName = (TextView) convertView.findViewById(R.id.episode_name);
            viewHolder.overview = (TextView) convertView.findViewById(R.id.episode_descr);
            convertView.setTag(viewHolder);
        }

        EpisodeData episodeData = getItem(position);

        viewHolder.episodeName.setText(episodeData.getEpisodeName());
        viewHolder.overview.setText(episodeData.getOverview());

        return convertView;
    }

    private class SeriesViewHolder{
        public TextView episodeName;
        public TextView overview;
    }
}
