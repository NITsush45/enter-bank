package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminDashboardDTO {
    // User statistics
    private long totalUsers;
    private long newUsersToday;
    private long activeUsers;

    // Transaction statistics
    private long totalTransactions;
    private long transactionsToday;
    private BigDecimal totalTransactionVolume; // Sum of all transaction amounts

    // Account statistics
    private long totalAccounts;
    private BigDecimal totalSystemAssets; // Sum of all account balances

    private ChartDataDTO newUsersChart;


    private ChartDataDTO transactionVolumeChart;

    // KYC statistics
    private long pendingKycSubmissions;


}