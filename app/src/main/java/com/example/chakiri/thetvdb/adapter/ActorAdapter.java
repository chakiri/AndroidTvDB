package com.example.chakiri.thetvdb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chakiri.thetvdb.R;
import com.example.chakiri.thetvdb.model.actors.ActorsData;
import com.squareup.picasso.Picasso;

import java.util.List;

/**  * Created by chakiri */

public class ActorAdapter extends ArrayAdapter<ActorsData> {
    Context context;

    public ActorAdapter(@NonNull Context context, List<ActorsData> actorsResult) {
        super(context, 0, actorsResult);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.actors_row,parent, false);
        }

        ActorsViewHolder viewHolder = (ActorsViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ActorsViewHolder();
            viewHolder.actorName = (TextView) convertView.findViewById(R.id.actor_name);
            viewHolder.realName = (TextView) convertView.findViewById(R.id.actor_real_name);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.actor_src);
            convertView.setTag(viewHolder);
        }

        ActorsData actorData = getItem(position);

        viewHolder.actorName.setText(actorData.getRole());
        viewHolder.realName.setText(actorData.getName());

        Picasso.with(context).load("https://www.thetvdb.com/banners/_cache/" + actorData.getImage()).error(context.getResources().getDrawable(R.drawable.ic_launcher)).into(viewHolder.imageView);

        return convertView;
    }

    private class ActorsViewHolder{
        public TextView actorName;
        public TextView realName;
        public ImageView imageView;
    }
}
