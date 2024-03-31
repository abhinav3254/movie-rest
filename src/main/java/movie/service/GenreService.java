package movie.service;

import movie.dto.ServiceResponse;
import movie.model.Genre;
import movie.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public ServiceResponse<Page<Genre>> findAll(int size, int page) {
        return new ServiceResponse<>(this.genreRepository.findAll(PageRequest.of(page,size)));
    }
}
