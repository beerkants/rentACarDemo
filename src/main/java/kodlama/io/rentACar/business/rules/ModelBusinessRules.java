package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.utilities.exceptions.ModelBusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private ModelRepository modelRepository;

    public void checkIfNameExists(String name) {
        if (this.modelRepository.existsByNameContainingIgnoreCase(name)) {
            throw new ModelBusinessException("Model name already exist.");
        }
    }
    public void checkIfModelHave() {
        List<Model> models = this.modelRepository.findAll();
        if (models.isEmpty()) {
            throw  new ModelBusinessException("list of empty");
        }
    }
}
