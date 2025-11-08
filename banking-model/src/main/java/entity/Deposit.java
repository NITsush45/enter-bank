package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "deposit")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Deposit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The transaction record for this deposit. Creates a one-to-one link.
    @OneToOne
    @JoinColumn(name = "transaction_id", nullable = false)
    private Transaction transaction;

    // The account that received the deposit.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_account_id", nullable = false)
    private Account toAccount;

    // The employee who processed the deposit. Stored as username for auditing.
    @Column(nullable = false)
    private String processedByEmployee;

    // The amount deposited.
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDateTime depositTimestamp;

    // An optional note, e.g., "Cash deposit at Main Branch".
    private String notes;


}