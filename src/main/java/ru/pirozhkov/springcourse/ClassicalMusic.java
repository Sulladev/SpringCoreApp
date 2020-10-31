package ru.pirozhkov.springcourse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope ("singleton")
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
