package dto;

import enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for a user's request to create a new SAVING or CURRENT account.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAccountDTO {
    // The type of account to create.
    private AccountType accountType;

}