public class Main {

    public static void main(String[] args) {
        List<Character> l = new List<>();
        l.add('t');
        l.add('r');
        l.add('g');
        l.add('r');
        l.add('t');
        l.add('b');
        l.add('r');
        l.add('t');
        l.add('b');
        l.add('r');
        l.add('x');
        solveTask(l);
    }

    private static void solveTask(List<Character> l) {
        for (int i = 0; i < 'z' - 'a'; i++) {
            int count = l.countOf((char) ('a' + i));
            if (count > 0) System.out.println("Count of letter '" + (char) ('a' + i) + "': " + count);
        }
    }
}