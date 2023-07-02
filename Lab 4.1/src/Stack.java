public class Stack {
    SLink peak;

    Stack() {
        peak = null;
    }

    void push(char data) {
        SLink link = new SLink(data);
        if(peak == null) {
            peak = link;
        } else {
            link.below = peak;
            peak = link;
        }
    }

    SLink pop() {
        SLink popable = peak;
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
        SLink current = peak;
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
