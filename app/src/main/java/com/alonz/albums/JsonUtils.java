package com.alonz.albums;

import org.json.JSONArray;
import org.json.JSONObject;

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

    static String songName;
    static String duration;
    static int songListNames = 0;

    public JsonUtils() {
    }

    public static Album JsonParse(int numOfAlbums, int currentSong) {
        Album album = null;
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
                if (currentSong < songListNames) {
                    JSONObject currentSongObject = songDetail.getJSONObject(currentSong);
                    songName = currentSongObject.getString("song");
                    duration = currentSongObject.getString("duration");
                    album = new Album(albumName, authorName, genreName, imageUrl, currentSong, songName, duration);
                } else {
                    return null;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return album;
    }

}

