package ru.pirozhkov.springcourse.manualconfig;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class RockMusic implements Music {

    private List<String> songList = new ArrayList<>();

    {
        songList.add("Deutchland");
        songList.add("Auslander");
        songList.add("Sonne");
    }


    @Override
    public List<String> getSong() {
        return songList;
    }

}
