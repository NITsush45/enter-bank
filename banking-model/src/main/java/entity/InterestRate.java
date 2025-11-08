package entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "interest_rate")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InterestRate implements Serializable {

    @EmbeddedId
    private InterestRateId id;

    @Column(nullable = false, precision = 10, scale = 5)
    private BigDecimal annualRate;

    private String description;

}