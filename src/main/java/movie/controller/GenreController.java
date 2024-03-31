package movie.controller;


import movie.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(required = false,defaultValue = "10")int size, @RequestParam(required = false,defaultValue = "0")int page) {
        return ResponseEntity.ok(genreService.findAll(size,page));
    }

}
