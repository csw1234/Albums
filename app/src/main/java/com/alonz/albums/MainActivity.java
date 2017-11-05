package com.alonz.albums;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Comparator;


public class MainActivity extends AppCompatActivity {
    AlbumAdapter adapter;
    int numOfAlbumsToDisplay = 0;
    ArrayList<Album> arrayOfAlbums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayOfAlbums = new ArrayList<Album>();


        adapter = new AlbumAdapter(this, arrayOfAlbums);

        final ListView listView = (ListView) findViewById(R.id.list_item);

        listView.setAdapter(adapter);

        // Set the touch listener
        final SwipeDetector swipeDetector = new SwipeDetector();
        listView.setOnTouchListener(swipeDetector);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Album album = arrayOfAlbums.get(position);
                int songLength = JsonUtils.songListNames;

                if (swipeDetector.swipeDetected()) {
                    if (swipeDetector.getAction() == SwipeDetector.Action.LR) {

                        Toast.makeText(getApplicationContext(),
                                "Left to right" + position, Toast.LENGTH_SHORT).show();
                        if (album.currentSong < songLength - 1) {
                            album.currentSong++;
                        }
                        int currentSong = album.currentSong;
                        String song = JsonUtils.JsonParse(position, currentSong).songName;
                        if (!song.equals("")) {
                            TextView songText = (TextView) view.findViewById(R.id.songText);
                            album.songName = song;
                            songText.setText(song);
                        } else {
                            album.currentSong--;
                        }

                    }
                    if (swipeDetector.getAction() == SwipeDetector.Action.RL) {

                        Toast.makeText(getApplicationContext(),
                                "Right to left", Toast.LENGTH_SHORT).show();

                        if (album.currentSong > 0) {
                            album.currentSong--;
                        }
                        int currentSong = album.currentSong;
                        String song = JsonUtils.JsonParse(position, currentSong).songName;
                        if (!song.equals("")) {
                            TextView songText = (TextView) view.findViewById(R.id.songText);
                            album.songName = song;
                            songText.setText(song);

                        }
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.addButton) {
            Album album = JsonUtils.JsonParse(numOfAlbumsToDisplay, 0);
            if (album != null) {
                adapter.add(album);
                numOfAlbumsToDisplay++;
                adapter.sort(new Comparator<Album>() {
                    @Override
                    public int compare(Album album, Album t1) {
                        String albumName1 = album.albumName;
                        String albumName2 = t1.albumName;
                        return albumName1.compareToIgnoreCase(albumName2);
                    }
                });
                return true;
            }
        }


        return super.onOptionsItemSelected(item);
    }

}
