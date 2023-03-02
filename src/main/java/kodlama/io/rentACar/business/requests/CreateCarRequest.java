package kodlama.io.rentACar.business.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {

    @NotNull
    @NotBlank
    @Size(min = 6,max = 9)
    private String plate;

    @NotBlank
    private String name;

    private double dailyPrice;

    private int state;

    private int modelYear;


    @NotNull
    private int modelId;
}
