package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
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
        Movie m4 = new Movie("4", "CCC", "science fiction", false);
        Movie m5 = new Movie("5", "DDD", "animation", false);
        Movie m6 = new Movie("6", "AB", "comedy", false);
        Movie m7 = new Movie("7", "FFF", "horror", false);
        Movie m8 = new Movie("8", "DDDDDGG", "horror", false);
        moveData.add(m1);
        moveData.add(m2);
        moveData.add(m3);
        moveData.add(m4);
        moveData.add(m5);
        moveData.add(m6);
        moveData.add(m7);
        moveData.add(m8);
    }


    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable String id) {
        for (Movie movie : moveData) {
            if (movie.getId().equals(id)) {
                return movie;
            }
        }
        return null;
    }

    @GetMapping("/movies")
    public List<Movie> searchMovieList(@RequestParam String search) {
        System.out.println(search);
        Movie condition = JSON.parseObject(search, Movie.class);
        List<Movie> result = new ArrayList<>();
        for (Movie m : moveData) {
            if (condition.getId() != null && m.getId().equals(condition.getId())) {
                result.add(m);
                return result;
            }
            if (condition.getName() != null && m.getName().indexOf(condition.getName()) >= 0) {
                result.add(m);
            }
            if (condition.getType() != null && m.getType().equals(condition.getType())) {
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
