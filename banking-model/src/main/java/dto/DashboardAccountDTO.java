package dto;
import entity.Account;
import enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DTO for displaying a summary of a user's account on their dashboard.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardAccountDTO {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private AccountType accountType;
    private String ownerName; // Helpful to show "John Doe"

    public DashboardAccountDTO(Account account) {
        this.id = account.getId();
        this.accountNumber = account.getAccountNumber();
        this.balance = account.getBalance();
        this.accountType = account.getAccountType();
        if (account.getOwner() != null) {
            this.ownerName = account.getOwner().getFirstName() + " " + account.getOwner().getLastName();
        }
    }


}