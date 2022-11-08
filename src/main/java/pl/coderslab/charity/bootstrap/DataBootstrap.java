package pl.coderslab.charity.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.models.Category;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.services.interfaces.CategoryService;
import pl.coderslab.charity.services.interfaces.InstitutionService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
//Wczytuje sie za każdym razem
//@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    public DataBootstrap(CategoryService categoryService, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadCategories();
        loadInstitutions();
        log.debug("Loading Bootstrap Data");
    }

    private void loadCategories(){
        List<String> categories = new ArrayList<>(Arrays.asList(
                "ubrania, które nadają się do ponownego użycia",
                "ubrania, do wyrzucenia",
                "zabawki", "książki",
                "inne"));
        categories.forEach(category-> categoryService.saveCategory(Category.builder().name(category).build()));
    }

    private void loadInstitutions() {
        institutionService.saveInstitution(Institution.builder()
                .name("Dbam o Zdrowie")
                .description("Pomoc dzieciom z ubogich rodzin.")
                .build());

        institutionService.saveInstitution(Institution.builder()
                .name("A kogo")
                .description("Pomoc wybudzaniu dzieci ze śpiączki.")
                .build());

        institutionService.saveInstitution(Institution.builder()
                .name("Dla dzieci")
                .description("Pomoc osobom znajdującym się w trudnej sytuacji życiowej.")
                .build());

        institutionService.saveInstitution(Institution.builder()
                .name("Bez domu")
                .description("Pomoc dla osób nie posiadających miejsca zamieszkania.")
                .build());
    }
}
