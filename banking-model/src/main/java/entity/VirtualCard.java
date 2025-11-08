package entity;


import enums.VirtualCardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "virtual_card")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VirtualCard implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 16)
    private String cardNumber;
    @Column(nullable = false, length = 3)
    private String cvv;
    @Column(nullable = false)
    private LocalDate expiryDate;
    @Column(nullable = false)
    private String cardHolderName;
    private String nickname;

    @Column(nullable = true, length = 255)
    private String hashedPin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VirtualCardStatus status;

    @Column(precision = 19, scale = 4)
    private BigDecimal spendingLimit;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "linked_account_id", nullable = false)
    private Account linkedAccount;


}