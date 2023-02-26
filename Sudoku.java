import java.util.Random;

public class Sudoku {
    public static void main(String[] args) {
        int[][] board = new int[9][9]; // 9x9 Sudoku board

        Random rand = new Random();
        for (int i = 0; i < 81 * 0.3; i++) { // fill 30% of the board with random numbers
            int row, col, num;
            do {
                row = rand.nextInt(9);
                col = rand.nextInt(9);
                num = rand.nextInt(9) + 1;
            } while (!isValid(board, row, col, num));
            board[row][col] = num;
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int num = board[row][col];
                System.out.print(num == 0 ? "  " : num + " "); // if the cell is empty, print a space
                if (col == 2 || col == 5) { // print a vertical line after every third column
                    System.out.print("| ");
                }
            }
            System.out.println();
            if (row == 2 || row == 5) { // you also need to print a horizontal line after every third row
                System.out.println("---------------------");
            }
        }
    }

    // check to see if the number can legally be placed in that row/column
    private static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        int boxRow = row - row % 3; // get the topmost row in the 3x3 box
        int boxCol = col - col % 3; // get the leftmost column of the 3x3 box
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
