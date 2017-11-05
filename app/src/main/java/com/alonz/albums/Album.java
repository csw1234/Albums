package com.alonz.albums;

/**
 * Created by alonz on 01/11/2017.
 */

public class Album {
    String albumName;
    String authorName;
    String genreName;
    String imageUrl;
    int currentSong;
    String[] songName;
    String[] duration;


    public Album(String albumName, String authorName, String genreName, String imageUrl, int currentSong, String[] songName, String[] duration) {
        this.albumName = albumName;
        this.authorName=authorName;
        this.genreName=genreName;
        this.imageUrl=imageUrl;
        this.currentSong=currentSong;
        this.songName=songName;
        this.duration=duration;
    }

}
