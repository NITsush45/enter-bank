package dto;


import entity.Transaction;
import enums.TransactionStatus;
import enums.TransactionType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO for representing a completed transaction in an API response (e.g., for transaction history).
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private Long id;
    private TransactionType transactionType;
    private TransactionStatus status;
    private BigDecimal amount;
    private String fromAccountNumber;
    private String toAccountNumber;
    private LocalDateTime transactionDate;
    private String description;
    private String userMemo;

    public TransactionDTO(Transaction transaction) {
        this.id = transaction.getId();
        this.transactionType = transaction.getTransactionType();
        this.status = transaction.getStatus();
        this.amount = transaction.getAmount();
        this.transactionDate = transaction.getTransactionDate();
        this.description = transaction.getDescription();
        this.userMemo = transaction.getUserMemo();

        // Safely get account numbers
        if (transaction.getFromAccount() != null) {
            this.fromAccountNumber = transaction.getFromAccount().getAccountNumber();
        }
        if (transaction.getToAccount() != null) {
            this.toAccountNumber = transaction.getToAccount().getAccountNumber();
        }
    }

}