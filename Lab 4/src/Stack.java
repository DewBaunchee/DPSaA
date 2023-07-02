public class Stack {
    private class Link {
        char data;
        Link below;

        Link (char data) {
            this.data = data;
        }
    }

    Link peak;

    Stack() {
        peak = null;
    }

    void push(char data) {
        Link link = new Link(data);
        if(peak == null) {
            peak = link;
        } else {
            link.below = peak;
            peak = link;
        }
    }

    Link pop() {
        Link popable = peak;
        if(peak == null) {
            return null;
        }
        if(peak.below == null) {
            peak = null;
            return popable;
        }
        peak = peak.below;
        popable.below = null;
        return popable;
    }

    String toStr() {
        String answer = "Peak\n";
        Link current = peak;
        if(current == null) {
            return "Stack is empty.";
        }
        while(current.below != null) {
            answer = answer + current.data + "\n";
            current = current.below;
        }
        answer = answer + current.data;
        return answer;
    }
}
