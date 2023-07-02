public class Link {
    int hash;
    String word, description;
    Link next;

    Link(int hash, String word, String description) {
        this.hash = hash;
        this.word = word;
        this.description = description;
        next = null;
    }
}