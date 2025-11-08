package entity;

import enums.BillerCategory;
import enums.BillerStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "biller")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Biller implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String billerName;

    @Enumerated(EnumType.STRING) // Stores the enum name (e.g., "UTILITIES") in the DB
    @Column(nullable = false)
    private BillerCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BillerStatus status = BillerStatus.ACTIVE; // Default new billers to ACTIVE

    private String logoUrl;

    // The link to the internal account used to receive funds.
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "internal_account_id", referencedColumnName = "id", nullable = false)
    private Account internalAccount;


}