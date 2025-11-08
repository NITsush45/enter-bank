package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAuditDTO {
    private UserDTO userDetails; // We can reuse the existing UserDTO
    private List<DashboardAccountDTO> accounts; // Reuse the DashboardAccountDTO
    private List<AdminTransactionDTO> transactions; // Reuse the AdminTransactionDTO for full details


}