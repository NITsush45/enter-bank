package dto;


import lombok.*;

import java.time.LocalDate;

/**
 * DTO for a user's on-demand request for an account statement.
 * This represents the JSON body the client will send.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StatementRequestDTO {

    // The account number for which the statement is requested.
    private String accountNumber;

    // The start date of the desired statement period (format: YYYY-MM-DD).
    private LocalDate startDate;

    // The end date of the desired statement period (format: YYYY-MM-DD).
    private LocalDate endDate;

}