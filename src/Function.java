public class Function {

    private Integer id;
    private String functionText;

    public Function(Integer id, String functionText) {
        this.id = id;
        this.functionText = functionText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunctionText() {
        return functionText;
    }

    public void setFunctionText(String functionText) {
        this.functionText = functionText;
    }

    public Function() {
    }
}
