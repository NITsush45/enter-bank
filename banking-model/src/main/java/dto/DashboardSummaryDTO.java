package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * A comprehensive DTO to hold all data needed for the user's main dashboard screen.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardSummaryDTO {
    // A summary of the user's accounts
    private List<DashboardAccountDTO> accounts;

    private BigDecimal totalBalance;
    private BigDecimal monthlySpending; // Total debits in the last 30 days
    private List<ScheduledPaymentDTO> upcomingPayments;

    // A list of the 5 most recent transactions across all accounts
    private List<TransactionDTO> recentTransactions;

}