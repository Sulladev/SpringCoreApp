package ru.pirozhkov.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {
//    Создал List в который через applicationContext добавлял объекты Music
//    private List<Music> musicList = new ArrayList<>();
    private Music classicalMusic;
    private Music rockMusic;
    private Music electronicMusic;

//    Создал переменные для значения которых добавлял через properties и applicationContext
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    //Зависимость внедряется из вне Inversion of Control
    @Autowired
    public MusicPlayer(@Qualifier ("classicalMusic") Music classicalMusic,
                       @Qualifier ("rockMusic") Music rockMusic,
                       @Qualifier ("electronicMusic") Music electronicMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
        this.electronicMusic = electronicMusic;
    }

    public MusicPlayer() {
    }

//    public void setMusicList(List<Music> musicList) {
//        this.musicList = musicList;
//    }
//
//    public List<Music> getMusicList() {
//        return musicList;
//    }

    public void playMusic(MusicGenre genre) {
        Random randomSong = new Random();
        int randomNumber = randomSong.nextInt(3);
        switch (genre) {
            case ROCK:
                System.out.println("Playing: " + rockMusic.getSong().get(randomNumber));
                break;

            case CLASSICAL:
                System.out.println("Playing: " + classicalMusic.getSong().get(randomNumber));
                break;

            case ELECTRONIC:
                System.out.println("Playing: " + electronicMusic.getSong().get(randomNumber));
                break;

            default:
                System.out.println("Wrong music genre");

        }
    }
}
