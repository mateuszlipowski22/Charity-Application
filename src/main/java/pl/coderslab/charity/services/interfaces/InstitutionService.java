package pl.coderslab.charity.services.interfaces;

import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.models.Category;
import pl.coderslab.charity.models.Institution;

import java.util.List;

public interface InstitutionService {

    List<Institution> findAll();

    void saveInstitution(Institution institution);

    InstitutionDTO convertInstitutionToInstitutionDTO(Institution institution);

    Institution convertInstitutionDTOToInstitution(InstitutionDTO institutionDTO);

    List<InstitutionDTO> findAllDTO();

    Institution getInstitutionByID(Long institutionId);

}
