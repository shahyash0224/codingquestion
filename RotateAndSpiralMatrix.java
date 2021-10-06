import java.util.Scanner;

public class RotateAndSpiralMatrix {

    static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n/2; i++) {
            for(int j = i; j < n-i-1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int[][] spiralMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, right = n-1;
        int top = 0, down = n-1;
        int count = 1;

        while(left <= right) {
            for(int i = left; i <= right; i++) {
                res[top][i] = count++;
            }
            top++;

            for(int i = top; i <= down; i++) {
                res[i][right] = count++;
            }
            right--;

            for(int i = right; i >= left; i--) {
                res[down][i] = count++;
            }
            down--;

            for(int i = down; i >= top; i--) {
                res[i][left] = count++;
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int[][] matrix = new int[n][n];
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < n; j++) {
//                matrix[i][j] = sc.nextInt();
//            }
//        }
//        rotateMatrix(matrix);

        int[][] result = new int[n][n];
        result = spiralMatrix(n);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}
