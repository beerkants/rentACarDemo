package kodlama.io.rentACar.business.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {

    private String name;
    private String modelName;
    private String brandName;
    private int modelYear;
    private double dailyPrice;
}
