public class List {
    Link begin;

    List() {
        begin = null;
    }

    List(int hash, String word, String description) {
        begin = new Link(hash, word, description);
    }

    String add(int hash, String word, String description) {
        Link elem = new Link(hash, word, description);

        if (begin == null) {
            begin = elem;
        } else {
            Link current = begin;
            if (begin.word.equals(elem.word)) {
                return "Element is already in hash-table.";
            }
            while (current.next != null) {
                if (current.word.equals(elem.word)) {
                    return "Element is already in hash-table.";
                }
                current = current.next;
            }
            current.next = elem;
        }

        return "";
    }

    Link findByWord(String word) {
        Link current = begin;
        if (current == null) {
            return null;
        } else {
            while (current.next != null) {
                if (current.word.equals(word)) return current;
                current = current.next;
            }
            if (current.word.equals(word)) return current;
        }
        return null;
    }

    Link remove(String word) {
        Link current = begin;
        if (current == null) {
            return null;
        }
        if (current.word.equals(word)) {
            begin = begin.next;
            return current;
        }
        while (current.next != null) {
            if (current.next.word.equals(word)) {
                Link removable = current.next;
                current.next = current.next.next;
                return removable;
            }
            current = current.next;
        }
        return null;
    }

    String listToString(String separator) {
        Link current = begin;
        String answer = "";
        if(current == null) {
            return separator;
        }
        while (current.next != null) {
            answer = answer + separator + current.word + " - " + current.description;
            current = current.next;
        }
        answer = answer + separator + current.word + " - " + current.description;
        return answer.substring(separator.length());
    }
}