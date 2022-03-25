package com.example.apelsin_restapi.service;
import com.example.apelsin_restapi.dto.ApiResponse;
import com.example.apelsin_restapi.entity.Category;
import com.example.apelsin_restapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {
    final CategoryRepository categoryRepository;
    public ApiResponse add(Category category) {
        categoryRepository.save(category);
        return new ApiResponse("Added", true);
    }

    public ApiResponse edit(UUID id, Category category) {

        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty()) return new ApiResponse(" Not found!", false);
        Category edited = byId.get();
        edited.setName(category.getName());
        categoryRepository.save(edited);
        return new ApiResponse("Edited", true);
    }
}
