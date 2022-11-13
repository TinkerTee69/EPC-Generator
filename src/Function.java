public class Function {
    public Function(Integer postion, String functionText) {
        this.postion = postion;
        this.functionText = functionText;
    }

    public Integer getPostion() {
        return postion;
    }

    public void setPostion(Integer postion) {
        this.postion = postion;
    }

    public String getFunctionText() {
        return functionText;
    }

    public void setFunctionText(String functionText) {
        this.functionText = functionText;
    }

    private Integer postion;
    private String functionText;

    public Function() {
    }
}
