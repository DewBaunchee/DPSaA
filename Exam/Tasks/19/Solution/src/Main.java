import java.io.CharArrayReader;

public class Main {

    public static void main(String[] args) {
	    Queue<Character> letters = new Queue<>();
        letters.push('a');
        letters.push('n');
        letters.push('a');
        letters.push('6');
        letters.push('1');
        letters.push('5');
        letters.push('n');
        Queue<Character> digits = new Queue<>();
        digits.push('7');
        digits.push('h');
        digits.push('s');
        digits.push('2');
        solveTask(letters, digits);
    }

    private static void solveTask(Queue<Character> letters, Queue<Character> digits) {
        System.out.println("Letters: " + letters.toString());
        System.out.println("Digits: " + digits.toString());
        System.out.println("Doing magic...");
        int lettersSize = letters.size();
        int digitsSize = digits.size();

        for(int i = 0; i < lettersSize; i++) {
            Character c = letters.pop();
            if(isDigit(c)) {
                digits.push(c);
            } else {
                letters.push(c);
            }
        }

        for(int i = 0; i < digitsSize; i++) {
            Character c = digits.pop();
            if(isDigit(c)) {
                digits.push(c);
            } else {
                letters.push(c);
            }
        }
        System.out.println("Letters: " + letters.toString());
        System.out.println("Digits: " + digits.toString());
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
