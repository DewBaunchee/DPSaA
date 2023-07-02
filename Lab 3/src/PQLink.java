public class PQLink<T> {

    T data;
    int priority;
    PQLink<T> next;

    PQLink(T data, int priority) {
        this.priority = priority;
    }
}
