package entity;


import enums.TransactionStatus;
import enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status; // NEW: Status of the transaction

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    // The account money came FROM. Null for top-ups.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_account_id", nullable = true)
    private Account fromAccount;

    // The account money went TO. Null for some withdrawals/payments.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_account_id", nullable = true)
    private Account toAccount;

    @Column(nullable = false)
    private LocalDateTime transactionDate;

    // System-generated description, e.g., "Transfer to Jane Doe"
    @Column(length = 255)
    private String description;

    // Optional note provided by the user, e.g., "For concert tickets"
    @Column(length = 255)
    private String userMemo;

    // Optional but recommended for performance
    @Column(precision = 19, scale = 4)
    private BigDecimal runningBalance;


}