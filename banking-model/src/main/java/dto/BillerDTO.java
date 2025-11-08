package dto;


import entity.Biller;
import enums.BillerCategory;
import enums.BillerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillerDTO {
    private Long id;
    private String billerName;
    private BillerCategory category;
    private BillerStatus status;
    private String logoUrl;


    public BillerDTO(Biller biller) {
        this.id = biller.getId();
        this.billerName = biller.getBillerName();
        this.category = biller.getCategory();
        this.status = biller.getStatus();
        if (biller.getLogoUrl() != null && !biller.getLogoUrl().isEmpty()) {
            this.logoUrl = "/api/biller/logo/image/" + biller.getLogoUrl();
        } else {
            this.logoUrl = null;
        }
    }


}