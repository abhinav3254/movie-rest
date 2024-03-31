package movie.service;


import movie.dto.ServiceResponse;
import movie.exception.CustomException;
import movie.model.Movie;
import movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public ServiceResponse<Page<Movie>> findAll(int page,int size) {
        Pageable pageable = PageRequest.of(page,size);
        return new ServiceResponse<>(movieRepository.findAll(pageable));
    }

    public ServiceResponse<Movie> findById(Long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isEmpty()) throw new CustomException("can't find the movie by id "+id, HttpStatus.NOT_FOUND);
        return new ServiceResponse<>(movieOptional.get());
    }

}
