package entity;


import enums.PaymentFrequency;
import enums.ScheduledPaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Represents a user's instruction to make a recurring payment.
 * This can be for a user-to-user transfer or a bill payment.
 */
@Entity
@Table(name = "scheduled_payment")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ScheduledPayment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The user who owns this scheduled payment rule.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // The account from which funds will be debited.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_account_id", nullable = false)
    private Account fromAccount;

    // --- Destination: Only ONE of these will be populated ---

    // For user-to-user transfers, this will be the recipient's account.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_account_id", nullable = true)
    private Account toAccount;

    // For bill payments, this links to the Biller entity from the directory.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "biller_id", nullable = true)
    private Biller biller;

    // For bill payments, this stores the user's specific account/reference number for that biller.
    @Column(length = 100, nullable = true)
    private String billerReferenceNumber;

    // --- Scheduling and Payment Details ---

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentFrequency frequency;

    @Column(nullable = false)
    private LocalDate nextExecutionDate;

    @Column(nullable = false)
    private LocalDate startDate;

    // An optional date after which the schedule will no longer run.
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ScheduledPaymentStatus status;

    // An optional note provided by the user for the transactions.
    @Column(length = 255)
    private String userMemo;


}