package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
@Builder
//in this cas we don' need NoArgsConstructor because we never used
public class ChartDataDTO {
    private List<String> labels; // e.g., ["Jul 18", "Jul 19", "Jul 20"]
    private List<Number> data;   // e.g., [15, 25, 18]


}