package dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class DepositRequestDTO {
    private String toAccountNumber;
    private BigDecimal amount;
    private String notes;

}