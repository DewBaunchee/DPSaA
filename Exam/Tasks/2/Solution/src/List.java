public class List {
    public class Link {
        public class Student {
            String name;
            double mark1;
            double mark2;
            double mark3;
        }

        Student student;
        Link next;

        Link(String name, double mark1, double mark2, double mark3) {
            student = new Student();
            student.name = name;
            student.mark1 = mark1;
            student.mark2 = mark2;
            student.mark3 = mark3;
            next = null;
        }

        public String toString() {
            return student.name + ": " + student.mark1 + ", " + student.mark2 + ", " + student.mark3 + ";";
        }
    }

    private Link begin, end;
    private int size;

    public List() {
        begin = end = null;
        size = 0;
    }

    public void add(String name, double mark1, double mark2, double mark3) {
        Link newLink = new Link(name, mark1, mark2, mark3);

        if(begin == null) {
            begin = end = newLink;
        } else {
            end.next = newLink;
            end = newLink;
        }
        size++;
    }

    public void sortByName() {
        if(begin == end) return;

        for(int i = 1; i < size; i++) {
            Link current = begin;
            Link next = begin.next;
            for(int j = 0; j < size - i; j++) {
                if(isFirstBigger(current.student.name, next.student.name)) {
                    swapData(current, next);
                }
                current = current.next;
                next = next.next;
            }
        }
    }

    private Link get(int index) {
        if(index < 0 || index >= size) return null;

        Link current = begin;
        while (index > 0) {
            current = current.next;
            index--;
        }
        return current;
    }

    private void swapData(Link current, Link next) {
        String tempName = current.next.student.name;
        current.next.student.name = current.student.name;
        current.student.name = tempName;

        double tempMark = current.next.student.mark1;
        current.next.student.mark1 = current.student.mark1;
        current.student.mark1 = tempMark;

        tempMark = current.next.student.mark2;
        current.next.student.mark2 = current.student.mark2;
        current.student.mark2 = tempMark;

        tempMark = current.next.student.mark3;
        current.next.student.mark3 = current.student.mark3;
        current.student.mark3 = tempMark;
    }

    private boolean isFirstBigger(String name1, String name2) {
        if(name1.length() < name2.length()) return false;
        if(name1.length() > name2.length()) return true;

        for(int i = 0; i < name1.length(); i++) {
            if(name1.charAt(i) < name2.charAt(i)) return false;
            if(name1.charAt(i) > name2.charAt(i)) return true;
        }
        return false;
    }

    public String toString() {
        if(begin == null) return "{EMPTY LIST}";

        StringBuilder answer = new StringBuilder("+------------------\n");
        Link current = begin;
        while(current != null) {
            answer.append(current.toString()).append("\n");
            current = current.next;
        }

        return answer.append("+------------------").toString();
    }

    public Enumerator getEnumerator() {
        return new Enumerator();
    }

    public class Enumerator {
        private Link next;

        Enumerator() {
            next = begin;
        }

        public Link.Student getNext() {
            Link returnable = next;
            next = next.next;
            return returnable.student;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
