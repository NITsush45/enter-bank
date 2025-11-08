package entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "kyc_document")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KycDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link back to the user who submitted this document
    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    // KYC Data Fields
    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    private String idNumber;

    @Column(nullable = false)
    private String address;
    private String city;
    private String postalCode;
    private String country;

    // Paths to the stored images. We do NOT store images in the database.
    @Column(nullable = false)
    private String idFrontPhotoPath;

    @Column(nullable = false)
    private String idBackPhotoPath;

    @Column(nullable = false)
    private LocalDateTime submittedAt;


}