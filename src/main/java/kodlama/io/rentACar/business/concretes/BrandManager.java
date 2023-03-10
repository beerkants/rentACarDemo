package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Autowired
    public BrandManager(BrandRepository brandRepository,ModelMapperService modelMapperService,BrandBusinessRules brandBusinessRules) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
        this.brandBusinessRules = brandBusinessRules;
    }
    @Override
    public List<GetAllBrandsResponse> findAll() {
        List<Brand> brands = brandRepository.findAll();
        // List<GetAllBrandsResponse> brandResponse = new ArrayList<GetAllBrandsResponse>();
        // for (Brand brand : brands) {
        //     GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
        //     responseItem.setId(brand.getId());
        //     responseItem.setName(brand.getName());
        //     brandResponse.add(responseItem);
        // }
        List<GetAllBrandsResponse> brandResponse = brands.stream()
                .map(brand-> this.modelMapperService.forResponse()
                        .map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        this.brandRepository.save(brand);
    }
}
