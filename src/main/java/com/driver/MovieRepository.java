package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String,Movie>movieMap;
    private HashMap<String,Director>directorMap;
    private HashMap<String, List<String>> directorMovieMap;

    public MovieRepository(HashMap<String, Movie> movieMap, HashMap<String, Director> directorMap, HashMap<String, List<String>> directorMovieMap) {
        this.movieMap = movieMap;
        this.directorMap = directorMap;
        this.directorMovieMap = directorMovieMap;
    }
    public void saveMovie(Movie movie)
    {
        movieMap.put(movie.getName(),movie);
    }
    public void saveDirector(Director director)
    {
        directorMap.put(director.getName(), director);
    }
    public void saveMovieDiretorPair(String movie,String director)
    {
        if (movieMap.containsKey(movie)&& directorMap.containsKey(director))
        {
            List<String>currentMovie= new ArrayList<>();
            if (directorMovieMap.containsKey(director))
                currentMovie = directorMovieMap.get(director);
            currentMovie.add(movie);
            directorMovieMap.put(director,currentMovie);
        }
    }
    public Movie findMovie(String movieName)
    {
        return movieMap.get(movieName);
    }
    public Director findDirector(String directorName)
    {
        return directorMap.get(directorName);
    }
    public List<String>findMovieOfDirector(String director)
    {
        List<String>movieList = new ArrayList<>();
        if (directorMovieMap.containsKey(director))
            movieList =directorMovieMap.get(director);
        return movieList;
    }
    public List<String>findAllMovie()
    {
        return new ArrayList<>(movieMap.keySet());
    }
    public void deleteDirector(String director)
    {
        List<String>movies = new ArrayList<>();
        if (directorMovieMap.containsKey(director))
        {
            movies = directorMovieMap.get(director);
            for (String movie:movies)
            {
                if (movieMap.containsKey(movie))
                {
                    movieMap.remove(movie);
                }
            }
            directorMovieMap.remove(director);
        }
        if (directorMovieMap.containsKey(director))
            directorMap.remove(director);
    }
    public void deletAllDirector()
    {
        HashSet<String> moviesSet = new HashSet<>();
        for (String director:directorMovieMap.keySet())
        {
            for (String movie:directorMovieMap.get(director))
            {
                moviesSet.add(movie);
            }
        }
        for (String movie:moviesSet)
        {
            if (movieMap.containsKey(movie))
            {
                movieMap.remove(movie);
            }
        }
    }

}
