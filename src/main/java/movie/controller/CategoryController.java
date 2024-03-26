package movie.controller;


import movie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@RequestMapping("api/no-auth/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(required = false,defaultValue = "10") int size, @RequestParam(required = false,defaultValue = "0") int page) {
        return ResponseEntity.ok(categoryService.getAllCategories(size,page));
    }
}
