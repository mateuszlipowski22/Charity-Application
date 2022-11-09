package pl.coderslab.charity.services.interfaces;

import pl.coderslab.charity.models.Category;

import java.util.List;

public interface CategoryService {

    void saveCategory(Category category);

    List<Category> findAllCategories();

}
