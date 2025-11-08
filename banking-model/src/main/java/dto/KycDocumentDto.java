package dto;

import enums.KycStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KycDocumentDto {
    private Long id;
    private String username;
    private String fullName;
    private LocalDate dateOfBirth;
    private String nationality;
    private String idNumber;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String idFrontPhotoPath;
    private String idBackPhotoPath;
    private LocalDateTime submittedAt;
    private KycStatus status;


}
