package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.example.demo.DTO.Movie;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MoveController {
    private static List<Movie> moveData = new ArrayList<>();

    static {
        Movie m1 = new Movie("1", "AAA", "action", false);
        Movie m2 = new Movie("2", "BBB", "animation", false);
        Movie m3 = new Movie("3", "PPPP", "animation", false);
        Movie m4 = new Movie("4", "CCC", "science fiction", true);
        Movie m5 = new Movie("5", "DDD", "animation", false);
        Movie m6 = new Movie("6", "AB", "comedy", true);
        Movie m7 = new Movie("7", "FFF", "horror", false);
        Movie m8 = new Movie("8", "DDDDDGG", "horror", true);
        moveData.add(m1);
        moveData.add(m2);
        moveData.add(m3);
        moveData.add(m4);
        moveData.add(m5);
        moveData.add(m6);
        moveData.add(m7);
        moveData.add(m8);
    }

    //get a movie by id
    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable String id) {
        for (Movie movie : moveData) {
            if (movie.getId().equals(id)) {
                return movie;
            }
        }
        return null;
    }

    //get a movie list by the search condition which is supposed to be a JSON string
    @GetMapping("/movies")
    public List<Movie> searchMovieList(@RequestParam String search) {
        System.out.println(search);
        Movie condition = null;
        List<Movie> result = new ArrayList<>();
        try {
            condition = JSON.parseObject(search, Movie.class);
        } catch (JSONException e) {
            return result;
        }
        condition = condition == null ? new Movie() : condition;
        for (Movie m : moveData) {
            if (condition.getId() != null) {
                if (!m.getId().equals(condition.getId()))
                    continue;
            }
            if (condition.getName() != null) {
                if (m.getName().indexOf(condition.getName()) < 0)
                    continue;
            }
            if (condition.getType() != null) {
                if (!m.getType().equals(condition.getType()))
                    continue;
            }
            if (condition.getContidionFav() != null) {
                if (condition.getContidionFav().equals("0")) {//is not fav
                    if (m.isFavorite()) {
                        continue;
                    }
                }
                if (condition.getContidionFav().equals("1")) {//is fav
                    if (!m.isFavorite()) {
                        continue;
                    }
                }
            }
            result.add(m);
        }
        return result;
    }

    @GetMapping("/favorites")
    public List<Movie> getFavorites() {
        List<Movie> result = new ArrayList<>();
        for (Movie m : moveData) {
            if (m.isFavorite()) {
                result.add(m);
            }
        }
        return result;
    }

    @GetMapping("/addFav")
    public ModelAndView index() {
        return new ModelAndView("addFav");
    }

    @PostMapping("/favorite")
    public String addFavorite(String id) {
        System.out.println(id);
        for (Movie movie : moveData) {
            if (movie.getId().equals(id)) {
                if (movie.isFavorite()) {
                    return "This movie is already favorite";
                } else {
                    movie.setFavorite(true);
                    return "set successfully";
                }
            }

        }
        return "no movie has this id";
    }
}
