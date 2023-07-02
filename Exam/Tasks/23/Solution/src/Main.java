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
        for(int i = 0; i < adjMatrix.length; i++) {
            if(adjMatrix[nodeNumber][i] > 0) {
                neighbors.add(adjMatrix[nodeNumber][i]);
            }
        }
        neighbors.sort();
        System.out.println(neighbors.toString());
    }

    private static int[][] readAdjMatrix() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("table.txt"));
        int size = Integer.parseInt(fileScanner.nextLine());
        int[][] answer = new int[size][size];
        int i = 0;
        while(fileScanner.hasNextLine()) {
            String[] line = fileScanner.nextLine().split(" ", size);
            for(int j = 0; j < size; j++) {
                answer[i][j] = Integer.parseInt(line[j]);
            }
                    i++;
        }
        return answer;
    }
}
