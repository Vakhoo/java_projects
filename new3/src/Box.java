public class Box<T> {
    private T field;

    public T getField() {
        return field;
    }

    public Box(T field) {
        this.field = field;
    }
}
