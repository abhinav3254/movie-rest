package movie.controller;


import movie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movie")
public interface MovieController {

    @PostMapping("/add/movies")
    public ResponseEntity<String> addMovies(@RequestBody(required = true) List<Movie> movies);

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie);

    @GetMapping("/")
    public ResponseEntity<Page<Movie>> getMovies(Pageable pageable);

    @GetMapping("/find/{year}")
    public ResponseEntity<Page<Movie>> getByYear(
            @PathVariable Integer year,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    );

    @GetMapping("/genres/{genres}")
    public ResponseEntity<Page<Movie>> getByGenres(
            @PathVariable String genres,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    );
}
