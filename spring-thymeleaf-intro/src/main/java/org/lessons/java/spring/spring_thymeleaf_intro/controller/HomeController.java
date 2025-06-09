package org.lessons.java.spring.spring_thymeleaf_intro.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.lessons.java.spring.spring_thymeleaf_intro.controller.model.Movie;
import org.lessons.java.spring.spring_thymeleaf_intro.controller.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class HomeController<ItemRepository> {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping()
    public String home(Model model, String name){
        model.addAttribute("name", "Alessio Brusca");
        return "homepage";
    }


    @GetMapping("/movies")
    private String movie(Model model){
        model.addAttribute("movies", getBestMovies());
        return "movies/home";
    }

    @GetMapping("/songs")
    private String song(Model model){
        model.addAttribute("songs", getBestSongs());
        return "songs/home";
    }


    private List<Movie> getBestMovies(){
        List<Movie> moviesList = new ArrayList<>();

        moviesList.add(new Movie("Forrest Gump", 1));
        moviesList.add(new Movie("Kill Bill", 2));
        moviesList.add(new Movie("Il Padrino", 3));
        moviesList.add(new Movie("Pulp Fiction", 4));
        
        return moviesList;
    }


    private List<Song> getBestSongs(){
        List<Song> songsList = new ArrayList<>();

        songsList.add(new Song("Bohemian Rhapsody - Queen", 100));
        songsList.add(new Song("Another Brick In The Wall - Pink Floyd", 101));
        songsList.add(new Song("Thriller - Michael Jackson", 102));
        songsList.add(new Song("All Along The Watchtower - Jimi Hendrix", 103));
        
        return songsList;
    }


  
    
}