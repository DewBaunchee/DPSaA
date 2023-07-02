package Structs;

public class Queue {
    private class Link {
        String data;
        Link next;

        Link(String data) {
            this.data = data;
            next = null;
        }
    }

    Link begin, end;

    public Queue() {
        begin = null;
    }

    public void add(String data) {
        Link link = new Link(data);

        if(begin == null) {
            begin = end = link;
        } else {
            link.next = begin;
            begin = link;
        }
    }

    public String remove() {
        if(begin == null) return null;

        String data = end.data;
        if(begin == end) {
            begin = end = null;
            return data;
        }

        Link newEnd = begin;
        while(newEnd.next != end) {
            newEnd = newEnd.next;
        }
        newEnd.next = null;
        end = newEnd;
        return data;
    }

    public String toString() {
        if(begin == null) return "{ EMPTY }";
        StringBuilder ans = new StringBuilder("{ ");
        Link current = begin;

        while(current.next != null) {
            ans.append(current.data).append(", ");
            current = current.next;
        }
        ans.append(current.data).append(" }");
        return ans.toString();
    }
}
