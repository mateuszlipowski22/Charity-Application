package pl.coderslab.charity.services.implementations;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.services.interfaces.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


}
