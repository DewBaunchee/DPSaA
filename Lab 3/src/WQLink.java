public class WQLink<T> {
    T data;
    WQLink<T> next;

    WQLink(T data) {
        this.data = data;
        next = null;
    }
}
