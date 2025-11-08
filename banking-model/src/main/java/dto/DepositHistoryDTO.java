package dto;

import entity.Deposit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepositHistoryDTO {
    private Long depositId;
    private Long transactionId;
    private LocalDateTime timestamp;
    private BigDecimal amount;
    private String toAccountNumber;
    private String toAccountOwnerName;
    private String processedByEmployee; // The employee who made the deposit
    private String notes;


    public DepositHistoryDTO(Deposit deposit) {
        this.depositId = deposit.getId();
        this.timestamp = deposit.getDepositTimestamp();
        this.amount = deposit.getAmount();
        this.processedByEmployee = deposit.getProcessedByEmployee();
        this.notes = deposit.getNotes();

        if (deposit.getTransaction() != null) {
            this.transactionId = deposit.getTransaction().getId();
        }
        if (deposit.getToAccount() != null) {
            this.toAccountNumber = deposit.getToAccount().getAccountNumber();
            if (deposit.getToAccount().getOwner() != null) {
                this.toAccountOwnerName = deposit.getToAccount().getOwner().getFirstName() + " " + deposit.getToAccount().getOwner().getLastName();
            }
        }
    }


}