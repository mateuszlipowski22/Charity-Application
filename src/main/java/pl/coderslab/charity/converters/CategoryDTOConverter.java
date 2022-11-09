package pl.coderslab.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.dto.CategoryDTO;
import pl.coderslab.charity.services.interfaces.CategoryService;


public class CategoryDTOConverter implements Converter<String, CategoryDTO>{

    @Autowired
    private CategoryService categoryService;

    @Override
    public CategoryDTO convert(String source) {
        return categoryService.convertCategoryToCategoryDTO(categoryService.getCategoryByID(Long.parseLong(source)));
    }
}