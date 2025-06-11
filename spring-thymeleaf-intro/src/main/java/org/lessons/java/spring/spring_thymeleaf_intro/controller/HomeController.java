package org.lessons.java.spring.spring_thymeleaf_intro.controller;

import java.util.ArrayList;
import java.util.List;

import org.lessons.java.spring.spring_thymeleaf_intro.controller.model.Movie;
import org.lessons.java.spring.spring_thymeleaf_intro.controller.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class HomeController<ItemRepository> {


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

        moviesList.add(new Movie("Forrest Gump", 0));
        moviesList.add(new Movie("Kill Bill", 1));
        moviesList.add(new Movie("Il Padrino", 2));
        moviesList.add(new Movie("Pulp Fiction", 3));
        moviesList.add(new Movie("Il Miglio Verde", 4));
        
        return moviesList;
    }


    private List<Song> getBestSongs(){
        List<Song> songsList = new ArrayList<>();

        songsList.add(new Song("Bohemian Rhapsody - Queen", 1));
        songsList.add(new Song("Another Brick In The Wall - Pink Floyd", 1));
        songsList.add(new Song("Thriller - Michael Jackson", 2));
        songsList.add(new Song("All Along The Watchtower - Jimi Hendrix", 3));
        songsList.add(new Song("Master of Puppets - Metallica", 4));
        
        return songsList;
    }

         
    @GetMapping("/songs/{id}")
        private String songId(Model model, @PathVariable("id") Integer songId){
            List<Song> songs = getBestSongs();
            model.addAttribute("songId", songs.get(songId));
           
        return "songs/song_id";
    }



     @GetMapping("/movies/{id}")
        private String movieId(Model model, @PathVariable("id") Integer movieId){
            List<Movie> movies = getBestMovies();
            model.addAttribute("movieId", movies.get(movieId));
            
           
        return "movies/movie_id";
    }
}