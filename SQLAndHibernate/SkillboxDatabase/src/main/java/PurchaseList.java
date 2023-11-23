import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class PurchaseList {

    @EmbeddedId
    private PLKey id;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
