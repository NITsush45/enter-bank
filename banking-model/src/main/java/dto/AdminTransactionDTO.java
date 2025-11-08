package dto;

import entity.Transaction;
import enums.TransactionStatus;
import enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * A detailed Data Transfer Object for viewing transactions from an administrative perspective.
 * This DTO is designed to be populated by a service layer that can resolve
 * all necessary details, like owner usernames and biller names.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AdminTransactionDTO {

    private Long id;
    private TransactionType transactionType;
    private TransactionStatus status;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

    // Sender Details
    private String fromAccountNumber;
    private String fromOwnerUsername;

    // Receiver Details
    private String toAccountNumber;
    private String toOwnerUsername; // Can hold a username OR a Biller's name

    private String description;
    private String userMemo;
    private BigDecimal runningBalance;


    public AdminTransactionDTO(Transaction transaction) {
        this.id = transaction.getId();
        this.transactionType = transaction.getTransactionType();
        this.status = transaction.getStatus();
        this.amount = transaction.getAmount();
        this.transactionDate = transaction.getTransactionDate();
        this.description = transaction.getDescription();
        this.userMemo = transaction.getUserMemo();
        this.runningBalance = transaction.getRunningBalance();

        // Map "From" details
        if (transaction.getFromAccount() != null) {
            this.fromAccountNumber = transaction.getFromAccount().getAccountNumber();
            if (transaction.getFromAccount().getOwner() != null) {
                this.fromOwnerUsername = transaction.getFromAccount().getOwner().getUsername();
            }
        }

        // Map "To" details
        if (transaction.getToAccount() != null) {
            this.toAccountNumber = transaction.getToAccount().getAccountNumber();
            if (transaction.getToAccount().getOwner() != null) {
                this.toOwnerUsername = transaction.getToAccount().getOwner().getUsername();
            }
        }
    }

}