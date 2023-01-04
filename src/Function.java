public class Function extends EPK_Element{

    private Integer id;
    private String functionText;
    private Integer position;

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

    public String getText() {
        return functionText;
    }

    public void setText(String functionText) {
        this.functionText = functionText;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

}
