package entity;


import enums.AccountLevel;
import enums.KycStatus;
import enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "app_user")
@Cacheable(value = false)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;
    private String middleName;
    @Column(nullable = false)
    private String lastName;


    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String phoneNumber;
    private String address;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = true)
    private String passcode;

    private boolean emailVerified = false;
    private String emailVerificationCode;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private KycStatus kycStatus = KycStatus.PENDING;

    // KYC Review fields
    private String kycReviewedBy;
    private LocalDateTime kycReviewedAt;
    @Column(length = 1000)
    private String kycReviewNotes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountLevel accountLevel = AccountLevel.BRONZE;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus status = UserStatus.ACTIVE;

    @Column(name = "has_claimed_welcome_gift", nullable = false)
    private boolean hasClaimedWelcomeGift = false; // Default to false

    private String profilePictureUrl;

    private LocalDateTime registeredDate;
    private LocalDateTime lastLoginDate;

}
