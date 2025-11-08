package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(
        name = "user_role",
        // Add a unique constraint to prevent assigning the same role to the same user twice
        uniqueConstraints = @UniqueConstraint(columnNames = {"username", "rolename"})
)
@Cacheable(value = false)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "rolename", nullable = false)
    private String rolename;
}