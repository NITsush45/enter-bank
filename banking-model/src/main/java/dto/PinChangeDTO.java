package dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PinChangeDTO {
    private String currentPassword;
    private String newPin;


}
