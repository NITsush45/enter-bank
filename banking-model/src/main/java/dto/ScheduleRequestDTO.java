package dto;


import enums.PaymentFrequency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class ScheduleRequestDTO {
    private String fromAccountNumber;
    private BigDecimal amount;
    private PaymentFrequency frequency;
    private LocalDate startDate;
    private LocalDate endDate;
    private String userMemo;
    private String toAccountNumber;
    private Long billerId;
    private String billerReferenceNumber;


}