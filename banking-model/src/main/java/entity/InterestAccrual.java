package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "interest_accrual")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InterestAccrual implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The account this interest was calculated for.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    // The date for which this interest was calculated.
    @Column(nullable = false)
    private LocalDate accrualDate;

    // The calculated interest amount for that single day.
    @Column(nullable = false, precision = 19, scale = 12)
    private BigDecimal interestAmount;

    // The balance of the account at the time of calculation.
    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal closingBalance;

    // The annual rate used for the calculation.
    @Column(nullable = false, precision = 10, scale = 5)
    private BigDecimal annualRateUsed;

    // Flag to show if this accrual has been paid out.
    @Column(nullable = false)
    private boolean paidOut = false;


}