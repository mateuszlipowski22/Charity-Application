package pl.coderslab.charity.bootstrap;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.models.Category;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.models.Role;
import pl.coderslab.charity.services.interfaces.CategoryService;
import pl.coderslab.charity.services.interfaces.InstitutionService;
import pl.coderslab.charity.services.interfaces.RoleService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
//Wczytuje sie za każdym razem
//@Component
@AllArgsConstructor
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final RoleService roleService;


    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadCategories();
        loadInstitutions();
        loadRoles();
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

    private void loadRoles() {
        roleService.saveRole(Role.builder()
                .name("ROLE_USER")
                .build());

        roleService.saveRole(Role.builder()
                .name("ROLE_ADMIN")
                .build());
    }
}
