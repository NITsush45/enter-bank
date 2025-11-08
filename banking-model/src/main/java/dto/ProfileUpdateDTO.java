package dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileUpdateDTO {
    private String email;
    private String phoneNumber;
    private String profilePictureUrl;


}