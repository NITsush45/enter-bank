package dto;


import entity.User;
import enums.AccountLevel;
import enums.KycStatus;
import enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * A Data Transfer Object representing a User for administrative purposes.
 * It omits sensitive fields like passwords and verification codes.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private boolean emailVerified;
    private String phoneNumber;
    private KycStatus kycStatus;
    private AccountLevel accountLevel;
    private UserStatus status;
    private String profilePictureUrl;
    private LocalDateTime registeredDate;
    private LocalDateTime lastLoginDate;



    // A convenient constructor to map from the database Entity to this DTO.
    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.emailVerified = user.isEmailVerified();
        this.phoneNumber = user.getPhoneNumber();
        this.kycStatus = user.getKycStatus();
        this.accountLevel = user.getAccountLevel();
        this.status = user.getStatus();
        this.profilePictureUrl = user.getProfilePictureUrl();
        this.registeredDate = user.getRegisteredDate();
        this.lastLoginDate = user.getLastLoginDate();
    }


}