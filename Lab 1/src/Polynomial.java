public class Polynomial {
    private ListElement begin;
    private int termCount;
    private int maxPow;

    Polynomial (String str) {
        maxPow = 0;
        str = str.replaceAll(" ", "").replaceAll("-", ",-").replaceAll("\\+", ",+").replaceAll("\\*", "");
        if(str.charAt(0) == ',') {
            str = str.substring(1);
        }
        while(str.indexOf(',') > -1) {
            String term = str.substring(0, str.indexOf(','));
            str = str.substring(str.indexOf(',') + 1);
            insertTerm(term);
        }
        insertTerm(str);
    }

    Polynomial () {
        termCount = 0;
    }

    private void insertTerm(String term) {
        int n, a;
        if(term.indexOf('^') == -1) {
            if(term.indexOf('x') == -1) {
                n = 0;
            } else {
                n = 1;
            }
        } else {
            n = Integer.parseInt(term.substring(term.indexOf('^') + 1));
        }

        if (term.indexOf('x') == -1) {
                a = Integer.parseInt(term);
        } else {
            switch (term.indexOf('x')) {
                case 0:
                    a = 1;
                    break;
                case 1:
                    if (term.charAt(0) == '-' || term.charAt(0) == '+') {
                        a = Integer.parseInt(term.charAt(0) + "1");
                    } else {
                        a = term.charAt(0) - 48;
                    }
                    break;
                default:
                    a = Integer.parseInt(term.substring(0, term.indexOf('x')));
                    break;
            }
        }
        ListElement temp = findByPow(n);
        if (temp != null) {
            temp.a = temp.a + a;
            if(temp.a == 0) {
                remove(temp.n, temp.a);
            }
        } else {
            this.insert(n, a);
        }
    }

    public int getTermCount() {
        return termCount;
    }

    public int getMaxPow() {
        return maxPow;
    }

    private void insert(int n, int a) {
        ListElement elem = new ListElement(n, a);
        if(elem.n > maxPow) {
            maxPow = elem.n;
        }
        if (begin == null) {
            begin = elem;
        } else {
            elem.next = begin;
            begin = elem;
        }
        termCount++;
    }

    private ListElement remove(int n, int a) {
        ListElement prev, current = begin;
        if(current.n == n && current.a == a) {
             begin = current.next;
             return current;
        }
        prev = begin;
        while(current != null) {
            if(current.n == n && current.a == a) {
                prev.next = current.next;
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private ListElement findByPow(int n) {
        ListElement current = begin;
        while (current != null) {
            if (current.n == n) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private ListElement find(int n, int a) {
        ListElement current = begin;
        while (current != null) {
            if (current.n == n && current.a == a) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean equality(Polynomial poly) {
        ListElement current = begin;

        if(this.termCount != poly.termCount) {
            return false;
        }

        while(current != null) {
            if(poly.find(current.n, current.a) == null) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    public int meaning(int x) {
        int meaning = 0;
        ListElement current = begin;

        while(current != null) {
            meaning += current.a * Math.pow(x, current.n);
            current = current.next;
        }

        return meaning;
    }

    public Polynomial add(Polynomial poly) {
        Polynomial answer = new Polynomial();
        ListElement current = begin;

        if(current == null) {
            return poly;
        }
        for(int i = 0; i < this.termCount; i++) {
            ListElement term = poly.findByPow(current.n);
            if(term == null) {
                answer.insert(current.n, current.a);
            } else {
                answer.insert(current.n, current.a + term.a);
            }
            current = current.next;
        }
        current = poly.begin;
        for(int i = 0; i < poly.termCount; i++) {
            if(answer.findByPow(current.n) == null) {
                answer.insert(current.n, current.a);
            }
            current = current.next;
        }

        return answer;
    }

    public String polyToString() {
        String answer = "";
        int n = maxPow;
        while (n > -1) {
            ListElement current = findByPow(n);
            if(current != null && current.a != 0) {
                    answer = answer + (current.a < 0 ? "- " + Math.abs(current.a) : "+ " + current.a);
                answer = answer  + "x^" + current.n + " ";
            }
            n--;
        }
        if (answer.length() == 0) {
            return "0";
        }
        if (answer.charAt(0) == '+') {
            answer = answer.substring(2);
        }
        return answer.replaceFirst("\\^1", "").replaceFirst("x\\^0", "").replaceFirst(" 1x", " x");
    }
}