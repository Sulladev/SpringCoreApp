package ru.pirozhkov.springcourse.manualconfig;

import java.util.ArrayList;
import java.util.List;


public class ClassicalMusic implements Music {
    private List<String> songList = new ArrayList<>();

    {
        songList.add("Shubert");
        songList.add("Mozart");
        songList.add("Bach");
    }


    @Override
    public List<String> getSong() {
        return songList;
    }
}
