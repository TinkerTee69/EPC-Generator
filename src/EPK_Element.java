public class EPK_Element {
    private static Integer counter = 0;
    private Integer position;
    private Integer level;
    private Integer id;

    public EPK_Element(Integer position, Integer level) {
        this.position = position;
        this.level = level;
        setCounter(++counter);
        setId(getCounter());
        id = getId();
    }

    public EPK_Element() {
        setCounter(++counter);
        setId(getCounter());
        id = getId();
    }

    public static Integer getCounter() {
        return counter;
    }

    public static void setCounter(Integer counter) {
        EPK_Element.counter = counter;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

}
