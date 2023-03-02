package kodlama.io.rentACar.business.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponse {

    private int id;
    private String name;
    private String brandName; // mapper burdaki alana otomatik join atar. modelin icindeli brand alanını gorur ve nameni getirir.
}
