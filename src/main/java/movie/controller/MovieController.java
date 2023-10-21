package movie.controller;


import movie.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/movie")
public interface MovieController {

    @PostMapping("/add/movies")
    public ResponseEntity<String> addMovies(@RequestBody(required = true) List<Movie> movies);

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie);

    @GetMapping("/")
    public ResponseEntity<List<Movie>> getMovies();
}
