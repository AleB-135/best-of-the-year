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
        List<Movie> movies = getBestMovies();
        model.addAttribute("movies", movies.toString());
        return "movies/home";
    }

    @GetMapping("/songs")
    private String song(Model model){
        List<Song> songs = getBestSongs();
        model.addAttribute("songs", songs.toString());
        return "songs/home";
    }


    private List<Movie> getBestMovies(){
        List<Movie> moviesList = new ArrayList<>();

        moviesList.add(new Movie("Forrest Gump", 1));
        moviesList.add(new Movie("Kill Bill", 2));
        moviesList.add(new Movie("Il Padrino", 3));
        moviesList.add(new Movie("Pulp Fiction", 4));
        moviesList.add(new Movie("Il Miglio Verde", 5));
        
        return moviesList;
    }


    private List<Song> getBestSongs(){
        List<Song> songsList = new ArrayList<>();

        songsList.add(new Song("Bohemian Rhapsody", 1));
        songsList.add(new Song("Another Brick In The Wall", 2));
        songsList.add(new Song("Thriller", 3));
        songsList.add(new Song("All Along The Watchtower", 4));
        songsList.add(new Song("Master of Puppets", 5));
        
        return songsList;
    }

         
  @GetMapping("/songs/{id}")
        private String songId(Model model, @PathVariable("id") Integer songId){
            Boolean isSongFound = false;
            Song song = null;

            for (Song currentSong : getBestSongs()) {
                if(currentSong.getId() == songId){
                    isSongFound = true;
                    song = currentSong;
                    break;
                }
            }
            
            model.addAttribute("isSongFound", isSongFound);
            model.addAttribute("song", song);
           
        return "songs/song_id";
    }



     @GetMapping("/movies/{id}")
        private String movieId(Model model, @PathVariable("id") Integer movieId){
            Boolean isMovieFound = false;
            Movie movie = null;

            for (Movie currentMovie : getBestMovies()) {
                if(currentMovie.getId() == movieId){
                    isMovieFound = true;
                    movie = currentMovie;
                    break;
                }
            }
            
            model.addAttribute("isMovieFound", isMovieFound);
            model.addAttribute("movie", movie);
           
        return "movies/movie_id";
    }
}