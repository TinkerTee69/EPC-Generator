public class EPK_Element {
    private Integer position;
    private Integer level;
    private Object type;
    private Integer id;
    private String text;

    public EPK_Element(Integer position, Integer level, Object type, Integer id, String text) {
        this.position = position;
        this.level = level;
        this.type = type;
        this.id = id;
        this.text = text;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
