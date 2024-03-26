package movie.service;


import movie.dto.ServiceResponse;
import movie.model.Category;
import movie.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ServiceResponse<Page<Category>> getAllCategories(int size, int page) {
        PageRequest pageRequest = PageRequest.of(page,size);
        return new ServiceResponse<>(categoryRepository.findAll(pageRequest));
    }

    public ServiceResponse<List<Category>> getTopTen() {
        List<Category> list = categoryRepository.findAll();
        List<Category> topTen = new ArrayList<>();
        int i = 0;
        for (Category category:list) {
            topTen.add(category);
            i++;
            if (i>9) break;
        }
        return new ServiceResponse<>(topTen);
    }
}
