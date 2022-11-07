package pl.coderslab.charity.services.implementations;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.repositories.InstitutionRepository;
import pl.coderslab.charity.services.interfaces.InstitutionService;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }
}
