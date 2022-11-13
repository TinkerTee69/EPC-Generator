public class gateType {
    private AND and;
    private OR or;
    private XOR xor;

    public gateType(AND and) {
        this.and = and;
    }


    public gateType(OR or) {
        this.or = or;
    }

    public gateType(XOR xor) {
        this.xor = xor;
    }
}

