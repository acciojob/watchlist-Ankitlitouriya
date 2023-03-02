package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie)
    {
        movieRepository.saveMovie(movie);
    }
    public void adddirector(Director director)
    {
        movieRepository.saveDirector(director);
    }
    public void creatMovieDirectorPair(String movie,String director)
    {
        movieRepository.saveMovieDiretorPair(movie, director);
    }
    public Movie findMovie(String movieName)
    {
        return movieRepository.findMovie(movieName);
    }
    public Director findDirector(String directorName)
    {
        return movieRepository.findDirector(directorName);
    }
    public List<String>findMoviesOfDirector(String director)
    {
        return movieRepository.findMovieOfDirector(director);
    }

    public List<String>findAllmovies()
    {
        return movieRepository.findAllMovie();
    }
    public void deleteDirector(String director)
    {
        movieRepository.deleteDirector(director);
    }
    public void deleteAllDirector()
    {
        movieRepository.deletAllDirector();
    }
}
