package dto;


import enums.AccountType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSearchResultDTO {
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String profilePictureUrl;
    private String accountNumber;
    private AccountType accountType;
}