package pl.coderslab.charity.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.CategoryDTO;
import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.models.Category;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.services.interfaces.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryDTO convertCategoryToCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    @Override
    public List<CategoryDTO> findAllCategoriesDTO() {
        return categoryRepository
                .findAll()
                .stream()
                .map(this::convertCategoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Category convertCategoryDTOToCategory(CategoryDTO categoryDTO) {
        return Category.builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .build();
    }

    @Override
    public Category getCategoryByID(Long categoryId) {
        return categoryRepository.getById(categoryId);
    }
}
