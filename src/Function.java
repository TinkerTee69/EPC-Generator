public class Function extends EPK_Element{

    private Integer id;
    private String functionText;

    public Function(Integer position, Integer level, String functionText) {
        super(position, level);
        this.functionText = functionText;
    }

    public Function(String functionText){
        super();
        this.functionText = functionText;
    }

    public Function()
    {
        super();
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

}
