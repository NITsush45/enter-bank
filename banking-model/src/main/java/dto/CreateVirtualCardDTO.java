package dto;


import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateVirtualCardDTO {
    private String fromAccountNumber;
    private String nickname;
    private BigDecimal spendingLimit;

}