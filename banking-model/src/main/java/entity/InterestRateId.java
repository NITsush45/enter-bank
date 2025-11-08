package entity;


import enums.AccountLevel;
import enums.AccountType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.io.Serializable;

/**
 * Represents the composite primary key for the InterestRate entity.
 * It's a combination of the AccountType and AccountLevel.
 *
 * An @Embeddable class requires a no-arg constructor, Serializable, and
 * correctly implemented equals() and hashCode() methods.
 */
@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class InterestRateId implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_level")
    private AccountLevel accountLevel;

}