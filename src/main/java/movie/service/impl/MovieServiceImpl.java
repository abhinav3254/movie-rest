package movie.service.impl;

import movie.model.Movie;
import movie.repository.MovieRepository;
import movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public ResponseEntity<List<Movie>> getMovies() {
        try {

//            wait for few seconds then only data will load
//            Thread.sleep(2000);

            List<Movie> movies = movieRepository.findAll();

            return new ResponseEntity<>(movies,HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Movie>> getByYear(Integer year) {
        try {

            List<Movie> movies = movieRepository.findByYear(year);

            return new ResponseEntity<>(movies,HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
