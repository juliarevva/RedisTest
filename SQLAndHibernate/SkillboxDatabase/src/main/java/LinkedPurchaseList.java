import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPLKey key;

    @Override
    public String toString() {
        return key.getStudentId() + " - " + key.getCourseId();
    }
}
