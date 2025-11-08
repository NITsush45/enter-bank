package dto;

import enums.TransactionStatus;
import enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * A simple DTO to hold the full details of a single transaction.
 * This class has no business logic; it is just a data container.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetailDTO {

    private Long id;
    private TransactionType transactionType;
    private TransactionStatus status;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

    // Sender Details
    private String fromAccountNumber;
    private String fromOwnerName;

    // Receiver Details
    private String toAccountNumber;
    private String toOwnerName;
    private String fromOwnerAvatarUrl;
    private String toOwnerAvatarUrl;

    private String description;
    private String userMemo;

}