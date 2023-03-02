package com.driver;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie)
    {
        movieService.addMovie(movie);
        return new ResponseEntity<>("new movie added successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director)
    {
        movieService.adddirector(director);
        return new ResponseEntity<>("new diretor added",HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie,@RequestParam("director") String director)
    {
      movieService.creatMovieDirectorPair(movie,director);
      return new ResponseEntity<>("new movie pair added Successfully",HttpStatus.CREATED);
    }
    @GetMapping("/"+"")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name)
    {
        Movie movies = movieService.findMovie(name);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
    @GetMapping("/get-director-by-name/{name}")
     public ResponseEntity<Director> getDirectorByName(@PathVariable String name)
    {
        Director director = movieService.findDirector(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED
        );
    }
    @GetMapping("get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director) {
        List<String> movies = movieService.findMoviesOfDirector(director);
        return new ResponseEntity<>(movies, HttpStatus.CREATED);
    }

    @GetMapping("get-all-movies")
    public ResponseEntity<List<String>> findAllMovies() {
        List allMovies = movieService.findAllmovies();
        return new ResponseEntity<>(allMovies, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director) {
        movieService.deleteDirector(director);
        return new ResponseEntity<>(director + "removed successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        movieService.deleteAllDirector();
        return new ResponseEntity<>("All directors deleted successfully", HttpStatus.CREATED);
    }
}