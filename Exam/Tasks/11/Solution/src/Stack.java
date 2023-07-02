public class Stack {
    public class Link {
        int key;
        Link down;

        Link(int key) {
            this.key = key;
            down = null;
        }
    }

    private Link peak;

    public Stack() {
        peak = null;
    }

    public void push(int key) {
        if(peak == null) {
            peak = new Link(key);
        } else {
            Link link = new Link(key);
            link.down = peak;
            peak = link;
        }
    }

    public int pop() {
        if(peak == null) return Integer.MIN_VALUE;

        Link temp = peak;
        peak = peak.down;
        return temp.key;
    }

    public String toString() {
        if (peak == null) return "{EMPTY}";

        StringBuilder answer = new StringBuilder("{ ");
        Link current = peak;
        while (current.down != null) {
            answer.append(current.key).append(", ");
            current = current.down;
        }
        return answer.append(current.key).append(" }").toString();
    }
}
