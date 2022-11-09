package pl.coderslab.charity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.charity.converters.CategoryDTOConverter;
import pl.coderslab.charity.converters.InstitutionDTOConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")

public class AppConfig implements WebMvcConfigurer {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getCategoryDTOConverter());
        registry.addConverter(getInstitutionDTOConverter());
    }
    @Bean
    public CategoryDTOConverter getCategoryDTOConverter() {
        return new CategoryDTOConverter();
    }

    @Bean
    public InstitutionDTOConverter getInstitutionDTOConverter() {
        return new InstitutionDTOConverter();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}
