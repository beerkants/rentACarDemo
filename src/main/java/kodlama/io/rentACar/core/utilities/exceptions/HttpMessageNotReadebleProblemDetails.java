package kodlama.io.rentACar.core.utilities.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpMessageNotReadebleProblemDetails extends ProblemDetails {
    private Map<String,String> httpMessageNotReadebleErrors;
}
