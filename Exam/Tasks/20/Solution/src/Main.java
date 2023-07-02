import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        int[][] adjMatrix = readAdjMatrix();
        System.out.println(Arrays.deepToString(adjMatrix));
        System.out.println("Enter node number:");
        solveTask(adjMatrix, Integer.parseInt(in.nextLine()) - 1);
    }

    private static void solveTask(int[][] adjMatrix, int nodeNumber) {
        List<Integer> neighbors = new List<>();
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[i][nodeNumber] > 0) {
                for (int j = 0; j < adjMatrix.length; j++)
                    if(adjMatrix[i][j] > 0)
                    neighbors.add(adjMatrix[i][j]);
            }
        }
        neighbors.sort();
        System.out.println(neighbors.toString());
    }
/*
Для первой вершины ответ:
{ 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 18, 42, 79 }
То есть:
0 5 7 8 9 0 12
---> 4 0 8 3 6 8 9
---> 18 42 0 7 79 6 7
---> 1 2 3 0 5 6 7
0 0 0 0 0 0 0
---> 1 2 0 3 0 0 8
---> 7 6 5 4 3 2 0
Все ненулевые дуги из выделенных строк :)
 */
    private static int[][] readAdjMatrix() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("table.txt"));
        int size = Integer.parseInt(fileScanner.nextLine());
        int[][] answer = new int[size][size];
        int i = 0;
        while (fileScanner.hasNextLine()) {
            String[] line = fileScanner.nextLine().split(" ", size);
            for (int j = 0; j < size; j++) {
                answer[i][j] = Integer.parseInt(line[j]);
            }
            i++;
        }
        return answer;
    }
}
