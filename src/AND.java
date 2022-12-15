import java.util.ArrayList;
import java.util.List;

public class AND {
    private Integer gateID;
    private Integer position;
    public AND(Integer position) {
        this.position = position;
    }

    public AND(Integer gateID, Integer position) {
        this.gateID = gateID;
        this.position = position;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }


    public Integer getGateID() {
        return gateID;
    }

    public void setGateID(Integer gateID) {
        this.gateID = gateID;
    }
}
