package dto;

import entity.VirtualCard;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class UnmaskedVirtualCardDTO implements Serializable {

    private String cardNumber; // Full, unmasked 16-digit number
    private String cardHolderName;
    private String expiryDate; // Formatted as "MM/yy"
    private String cvv;


    public UnmaskedVirtualCardDTO(VirtualCard card) {
        this.cardNumber = card.getCardNumber();
        this.cardHolderName = card.getCardHolderName();
        this.cvv = card.getCvv();

        if (card.getExpiryDate() != null) {
            this.expiryDate = card.getExpiryDate().format(DateTimeFormatter.ofPattern("MM/yy"));
        }
    }


}