public class Link {

    int key;
    int level;
    Link left, right;

    public Link(int key) {
        this.key = key;
        level = 0;
        left = right = null;
    }
}
