package dto;



import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * DTO for initiating a new fund transfer.
 * This represents the JSON body the client will send.
 */
@Getter
@Setter
public class TransactionRequestDTO {
    private String fromAccountNumber;
    private String toAccountNumber;
    private BigDecimal amount;
    private String userMemo; // Optional note from the user


}