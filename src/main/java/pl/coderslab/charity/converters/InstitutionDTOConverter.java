package pl.coderslab.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.dto.CategoryDTO;
import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.services.interfaces.CategoryService;
import pl.coderslab.charity.services.interfaces.InstitutionService;


public class InstitutionDTOConverter implements Converter<String, InstitutionDTO>{

    @Autowired
    private InstitutionService institutionService;

    @Override
    public InstitutionDTO convert(String source) {
        return institutionService.convertInstitutionToInstitutionDTO(institutionService.getInstitutionByID(Long.parseLong(source)));
    }
}