package movie.service.impl;

import movie.model.Movie;
import movie.repository.MovieRepository;
import movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Override
    public ResponseEntity<String> addMovies(List<Movie> movies) {
        try {

            for (int i = 0; i < movies.size(); i++) {
                movieRepository.save(movies.get(i));
            }

            return new ResponseEntity<>("added "+movies.size()+" movies",HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> addMovie(Movie movie) {
        try {

            movieRepository.save(movie);
            return new ResponseEntity<>("added movie",HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Page<Movie>> getMovies(Pageable pageable) {
        try {
            // Simulate a delay of 2 seconds (optional)
            // Thread.sleep(2000);

            Page<Movie> movies = movieRepository.findAll(pageable);

            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Page<Movie>> getByYear(Integer year, int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Movie> movies = movieRepository.findByYear(Double.parseDouble(year.toString()), pageable);
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<Page<Movie>> getByGenres(String genres, int page, int size) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Movie> movies = movieRepository.findByGenres(genres, pageable);
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
