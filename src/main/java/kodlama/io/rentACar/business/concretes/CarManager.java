package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private ModelMapperService modelMapperService;
    private CarRepository carRepository;


    @Override
    public void add(CreateCarRequest createCarRequest) {
        Car car = this.modelMapperService.forRequest().map(createCarRequest,Car.class);

        this.carRepository.save(car);
    }

    @Override
    public List<GetAllCarsResponse> getAllCars() {
        List<Car> cars = this.carRepository.findAll();
        List<GetAllCarsResponse> carResponse = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car,GetAllCarsResponse.class)).collect(Collectors.toList());
        return carResponse;
    }
}
