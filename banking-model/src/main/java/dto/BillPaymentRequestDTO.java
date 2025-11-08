package dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal; // Ensure this import is present

/**
 * A Data Transfer Object for initiating a new, one-time bill payment.
 * This class models the JSON request body sent by the client to the /api/bills/pay endpoint.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillPaymentRequestDTO {

    // The user's account number from which funds will be debited.
    private String fromAccountNumber;

    // The unique ID of the Biller (from the directory) that the user wants to pay.
    private Long billerId;

    // The user's specific account number or reference ID for that particular biller.
    private String billerReferenceNumber;

    // The amount to be paid. Using BigDecimal is crucial for financial accuracy.
    private BigDecimal amount;

    // An optional note or memo for the payment provided by the user.
    private String userMemo;


}