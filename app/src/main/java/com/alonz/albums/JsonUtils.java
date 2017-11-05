package com.alonz.albums;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.duration;

/**
 * Created by alonz on 01/11/2017.
 */

public class JsonUtils {
    private static String jsonString = "[\n" +
            "  {\n" +
            "    \"album\": \"taylor\",\n" +
            "    \"author\": \"taylor swift\",\n" +
            "    \"genre\": \"pop\",\n" +
            "    \"image\": \"http://www.freepngimg.com/download/lion/3-2-lion-png.png\",\n" +
            "    \"songs\": [\n" +
            "      {\n" +
            "        \"song\": \"ours\",\n" +
            "        \"duration\": \"4:11\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"song\": \"love story\",\n" +
            "        \"duration\": \"4:65\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"album\": \"ADI\",\n" +
            "    \"author\": \"adi zilber\",\n" +
            "    \"genre\": \"rock\",\n" +
            "    \"image\": \"https://img00.deviantart.net/65e4/i/2013/003/6/6/png_floating_terrain_by_moonglowlilly-d5qb58m.png\",\n" +
            "    \"songs\": [\n" +
            "      {\n" +
            "        \"song\": \"sihi\",\n" +
            "        \"duration\": \"4:18\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"song\": \"love a\",\n" +
            "        \"duration\": \"4:25\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"album\": \"alon\",\n" +
            "    \"author\": \"alon swift\",\n" +
            "    \"genre\": \"pop\",\n" +
            "    \"image\": \"http://www.freepngimg.com/download/lion/3-2-lion-png.png\",\n" +
            "    \"songs\": [\n" +
            "      {\n" +
            "        \"song\": \"ddours\",\n" +
            "        \"duration\": \"4:17\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"song\": \"hate story\",\n" +
            "        \"duration\": \"4:65\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]";


    static int songListNames = 0;

    public JsonUtils() {
    }

    public static Album JsonParse(int numOfAlbums) {
        Album album = null;
        List<String> mSongName = new ArrayList<String>();
        List<String> mDuration = new ArrayList<String>();
        try {
            JSONArray root = new JSONArray(jsonString);
            if (numOfAlbums < root.length()) {
                JSONObject mainObject = root.getJSONObject(numOfAlbums);
                String albumName = mainObject.getString("album");
                String authorName = mainObject.getString("author");
                String genreName = mainObject.getString("genre");
                String imageUrl = mainObject.getString("image");
                JSONArray songDetail = mainObject.getJSONArray("songs");

                songListNames = songDetail.length();
                for (int i=0; i<songDetail.length();i++){
                    JSONObject currentSongObject = songDetail.getJSONObject(i);
                    mSongName.add(currentSongObject.getString("song"));
                    mDuration.add(currentSongObject.getString("duration"));
                }
                String[] songName = new String[mSongName.size()];
                String[] duration = new String[mSongName.size()];
                mSongName.toArray(songName);
                mDuration.toArray(duration);
                album = new Album(albumName, authorName, genreName, imageUrl, 0, songName, duration);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return album;
    }

}

