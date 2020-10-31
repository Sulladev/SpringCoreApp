package ru.pirozhkov.springcourse;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

@Component
public class ElectronicMusic implements Music {

    private List<String> songList = new ArrayList<>();

    {
        songList.add("Techno 1");
        songList.add("Techno 2");
        songList.add("Techno 3");

    }

    public ElectronicMusic () {

    }

    //
    public static ElectronicMusic getElectronicMusic () {
        return new ElectronicMusic();
    }

    @PostConstruct
    public void init () {
        System.out.println("Initialization");
    }

    @PreDestroy
    public void destroy () {
        System.out.println("destruction");
    }


    @Override
    public List<String> getSong() {
        return songList;
    }
}
