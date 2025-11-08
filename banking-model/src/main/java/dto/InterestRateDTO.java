package dto;

import entity.InterestRate;
import enums.AccountLevel;
import enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InterestRateDTO {
    private AccountType accountType;
    private AccountLevel accountLevel;
    private BigDecimal annualRate;
    private String description;



    public InterestRateDTO(InterestRate entity) {
        this.accountType = entity.getId().getAccountType();
        this.accountLevel = entity.getId().getAccountLevel();
        this.annualRate = entity.getAnnualRate();
        this.description = entity.getDescription();
    }


}