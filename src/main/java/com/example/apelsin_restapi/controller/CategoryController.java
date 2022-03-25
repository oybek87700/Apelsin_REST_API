package com.example.apelsin_restapi.controller;
import com.example.apelsin_restapi.dto.ApiResponse;
import com.example.apelsin_restapi.entity.Category;
import com.example.apelsin_restapi.repository.CategoryRepository;
import com.example.apelsin_restapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {


    final CategoryRepository categoryRepository;
    final CategoryService categoryService;

    @GetMapping("/list")
    public HttpEntity<?> getAll() {
        List<Category> all = categoryRepository.findAllByActiveTrue();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable UUID id) {
        Optional<Category> byId = categoryRepository.findById(id);
        return ResponseEntity.status(byId.isEmpty() ?
                HttpStatus.NOT_FOUND : HttpStatus.OK).body(byId.orElse(new Category()));
    }
    @PostMapping
    public HttpEntity<?> add(@RequestBody Category category) {
        ApiResponse response = categoryService.add(category);
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable UUID id, @RequestBody Category category) {
        ApiResponse response = categoryService.edit(id, category);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable UUID id) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty()) return ResponseEntity.status(404).body("NOT FOUND");
        Category category = byId.get();
        category.setActive(false);
        categoryRepository.save(category);
        return ResponseEntity.ok().body("Deleted Category");
    }



}
