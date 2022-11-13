package pl.coderslab.charity.services.implementations;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.InstitutionDTO;
import pl.coderslab.charity.models.Institution;
import pl.coderslab.charity.repositories.InstitutionRepository;
import pl.coderslab.charity.services.interfaces.InstitutionService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public void saveInstitution(Institution institution) {
        institutionRepository.save(institution);
    }

    @Override
    public InstitutionDTO convertInstitutionToInstitutionDTO(Institution institution) {
        return InstitutionDTO.builder()
                .id(institution.getId())
                .description(institution.getDescription())
                .name(institution.getName())
                .build();
    }

    @Override
    public List<InstitutionDTO> findAllDTO() {
        return institutionRepository
                .findAll()
                .stream()
                .map(this::convertInstitutionToInstitutionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Institution convertInstitutionDTOToInstitution(InstitutionDTO institutionDTO) {
        return Institution.builder()
                .id(institutionDTO.getId())
                .description(institutionDTO.getDescription())
                .name(institutionDTO.getName())
                .build();
    }

    @Override
    public Institution getInstitutionByID(Long institutionId) {
        return institutionRepository.getById(institutionId);
    }

    @Override
    public void deleteInstitutionByID(Long institutionId) {
        institutionRepository.deleteById(institutionId);
    }
}
