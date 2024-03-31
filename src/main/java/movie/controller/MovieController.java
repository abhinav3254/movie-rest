package movie.controller;


import movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(required = false,defaultValue = "0")int page,@RequestParam(required = false,defaultValue = "5") int size) {
        return ResponseEntity.ok(this.movieService.findAll(page,size));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.movieService.findById(id));
    }

}
