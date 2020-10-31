package ru.pirozhkov.springcourse.manualconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {

    @Bean
    public ClassicalMusic classicalMusic () {
        return new ClassicalMusic();
    }

    @Bean
    public ElectronicMusic electronicMusic () {
        return new ElectronicMusic();
    }

    @Bean
    public RockMusic rockMusic () {
        return new RockMusic();
    }

    @Bean
    public List<Music> musicList () {
        List<Music> musicList = new ArrayList<>();
        musicList.add(rockMusic());
        musicList.add(classicalMusic());
        musicList.add(electronicMusic());
        return musicList;
    }

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(musicList());
    }
}
