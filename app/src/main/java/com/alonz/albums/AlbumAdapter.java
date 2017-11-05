package com.alonz.albums;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

/**
 * Created by alonz on 01/11/2017.
 */

public class AlbumAdapter extends ArrayAdapter<Album> {
    Album album;
    int mPosition;
    ImageView imageView;
    ProgressBar pb;

    public AlbumAdapter(Context context, ArrayList<Album> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        album = getItem(position);
        mPosition = position;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_model, parent, false);
        }
        TextView albumText = (TextView) convertView.findViewById(R.id.albumText);
        TextView authorText = (TextView) convertView.findViewById(R.id.authorText);
        TextView genreText = (TextView) convertView.findViewById(R.id.genreText);
        TextView songText = (TextView) convertView.findViewById(R.id.songText);
        TextView durationText = (TextView) convertView.findViewById(R.id.durationText);
        imageView = (ImageView) convertView.findViewById(R.id.albumImage);
        pb = (ProgressBar) convertView.findViewById(R.id.pb);

        Picasso.with(getContext()).load(album.imageUrl).resize(50,50).into(imageView, new com.squareup.picasso.Callback(){
                    @Override
                    public void onSuccess() {
                        pb.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onError() {

                    }
                });
        albumText.setText(album.albumName);
        authorText.setText(album.authorName);
        genreText.setText(album.genreName);
        songText.setText(album.songName);
        durationText.setText(album.duration);

        return convertView;

    }
    }

