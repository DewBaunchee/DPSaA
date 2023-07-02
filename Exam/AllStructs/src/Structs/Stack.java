package Structs;

public class Stack<T> {
    private class Link {
        T data;
        Link below;

        Link(T data) {
            this.data = data;
        }
    }

    Link peak;

    public Stack() {
        peak = null;
    }

    public void push(T data) {
        Link link = new Link(data);
        if (peak == null) {
            peak = link;
        } else {
            link.below = peak;
            peak = link;
        }
    }

    public T pop() {
        if (peak == null) {
            return null;
        }
        T returnable = peak.data;
        if (peak.below == null) {
            peak = null;
            return returnable;
        }
        peak = peak.below;
        return returnable;
    }

    public static String transform(String expr) {
        String postForm = transformToPost(expr);
        return "Normal form: " + expr +
                "\nPrefix form: " + postToPre(postForm) +
                "\nPost form: " + postForm;
    }

    public static String postToPre(String answer) {
        Stack<String> operands = new Stack<>();

        for (int i = 0; i < answer.length(); i++) {
            char chr = answer.charAt(i);

            if(isLetter(chr))
            {
                operands.push(chr + "");
            } else {
                String temp = operands.pop();
                operands.push(chr + operands.pop() + temp);
            }

        }
        return operands.pop();
    }

    private static String transformToPost(String exp) {
        exp = exp.replaceAll(" ", "");
        if (exp.length() == 0) {
            return "No expression";
        }

        StringBuilder answer = new StringBuilder();
        Stack<Character> operations = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char chr = exp.charAt(i);

            if (isLetter(chr)) {
                answer.append(chr);
                continue;
            }
            if (getPriority(chr) == -1) {
                return "Invalid expression";
            }
            if (getPriority(chr) == 0) {
                operations.push(chr);
                continue;
            }
            if (getPriority(chr) == 1) {
                answer.append(operations.pop());
                while (operations.peak.data != 0 && getPriority(operations.peak.data) >= getPriority(chr) && getPriority((operations.peak.data)) != 0) {
                    answer.append(operations.pop());
                }
                operations.pop();
                continue;
            }
            if (operations.peak == null || getPriority(operations.peak.data) == 0) {
                operations.push(chr);
                continue;
            }
            if (getPriority(operations.peak.data) < getPriority(chr)) {
                operations.push(chr);
                continue;
            }

            answer.append(operations.pop());
            while (operations.peak.data != 0 && getPriority(operations.peak.data) >= getPriority(chr) && getPriority((operations.peak.data)) != 0) {
                answer.append(operations.pop());
            }
            operations.push(chr);
        }

        Character link = operations.pop();
        while (link != null) {
            if (link != '(' && link != ')') {
                answer.append(link);
            }
            link = operations.pop();
        }
        return answer.toString();
    }

    private static int getPriority(char operation) {
        switch (operation) {
            case '(':
                return 0;
            case ')':
                return 1;
            case '+':
            case '-':
                return 2;
            case '*':
            case '/':
                return 3;
            case '^':
                return 4;
            default:
                return -1;
        }
    }

    private static boolean isLetter(char chr) {
        return chr > 64 && chr < 91 || chr > 96 && chr < 123;
    }


    public String toString() {
        StringBuilder answer = new StringBuilder("Peak\n");
        Link current = peak;
        if (current == null) {
            return "Stack is empty.";
        }
        while (current.below != null) {
            answer.append(current.data).append("\n");
            current = current.below;
        }
        answer.append(current.data);
        return answer.toString();
    }
}
