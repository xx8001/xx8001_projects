public class noo {


    public static long f_01(int n) {
        if ( n <= 1) {
            return n;
        }
        else {
            return f_01(n - 1) + f_01(n - 2);
        }

    }

    //non
    public static long f_02(int n) {
        long[] F = new long[n + 2];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= n; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F[n];
    }

    //matrix
    public static long f_03(int n) {
        if ( n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        long[][] baseMatrix = {{1, 1}, {1, 0}};
        long[][] resultMatrix = matrixPower(baseMatrix, n - 1);
        return resultMatrix[0][0];

    }

    //construct a matrix with line 1
    private static long[][] identityMatrix(int size) {
        long[][] matrix = new long[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
        return matrix;
    }

    // multiply 2 matrix
    private static long[][] multiplyMatrices(long[][] matrix1, long[][] matrix2) {

        int row1 = matrix1.length;
        int col1 = matrix1[0].length;

        int col2 = matrix2[0].length;

        long[][] result = new long[row1][col2];

        //3 loops to computer every element, row x col
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    private static long[][] matrixPower(long[][] matrix, int power) {

        if (power == 0) {
            return identityMatrix(2);
        }

        if (power == 1) {
            return matrix;
        }

        long[][] halfPowerMatrix = matrixPower(matrix, power / 2);
        long [][] squaredMatrix = multiplyMatrices(halfPowerMatrix, halfPowerMatrix);

        if (power % 2 == 1) {
            return multiplyMatrices(squaredMatrix, matrix);
        }
        else {
            return squaredMatrix;
        }
    }


    //quick
    public static long f_04(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0;
        long b = 1;
        long result = 0;
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }


}
