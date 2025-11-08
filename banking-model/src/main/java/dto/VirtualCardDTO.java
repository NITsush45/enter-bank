package dto;

import entity.VirtualCard;
import enums.AccountType;
import enums.VirtualCardStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

/**
 * A Data Transfer Object representing a Virtual Card for API responses.
 * It securely masks sensitive information like the full card number and
 * formats other data like the expiry date for client-side display.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VirtualCardDTO {

    private Long id;
    private String nickname;
    private String maskedCardNumber; // e.g., "**** **** **** 1234"
    private String cardHolderName;
    private String expiryDate; // Formatted as "MM/yy"
    private String cvv;
    private VirtualCardStatus status;
    private BigDecimal spendingLimit;
    private String linkedAccountNumber;
    private boolean hasPinSet;
    private AccountType accountType;

    // A flag to indicate if a PIN has been created



    /**
     * A constructor to easily map from a VirtualCard entity to this DTO.
     * This is where the logic for masking and formatting the data lives.
     *
     * @param card The VirtualCard entity from the database.
     */
    public VirtualCardDTO(VirtualCard card) {
        this.id = card.getId();
        this.nickname = card.getNickname();
        this.cardHolderName = card.getCardHolderName();
        this.cvv = card.getCvv();
        this.status = card.getStatus();
        this.spendingLimit = card.getSpendingLimit();
        this.hasPinSet = card.getHashedPin() != null && !card.getHashedPin().isEmpty();
        this.accountType = card.getLinkedAccount() != null ? card.getLinkedAccount().getAccountType() : null;

        if (card.getLinkedAccount() != null) {
            this.linkedAccountNumber = card.getLinkedAccount().getAccountNumber();
        }

        // Securely mask the card number, showing only the last 4 digits.
        if (card.getCardNumber() != null && card.getCardNumber().length() == 16) {
            this.maskedCardNumber = "**** **** **** " + card.getCardNumber().substring(12);
        } else {
            this.maskedCardNumber = "Invalid Card Number";
        }

        // Format the expiry date to the standard MM/yy format for display.
        if (card.getExpiryDate() != null) {
            this.expiryDate = card.getExpiryDate().format(DateTimeFormatter.ofPattern("MM/yy"));
        }
    }


}