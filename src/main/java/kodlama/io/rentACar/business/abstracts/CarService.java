package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;

import java.util.List;

public interface CarService {

    void add(CreateCarRequest createCarRequest);
    List<GetAllCarsResponse> getAllCars();
}
