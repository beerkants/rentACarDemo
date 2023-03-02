package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

    private BrandRepository brandRepository;


    public void checkIfBrandNameExists(String name) {
        if (this.brandRepository.existsByNameContainingIgnoreCase(name)) {
            // throw new RuntimeException("Brand already exists"); // java exceptions types.
            throw new BusinessException("Brand already exists");
        }
    }
}
