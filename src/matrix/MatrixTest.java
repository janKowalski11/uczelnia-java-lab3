package matrix;
/*
Author: BeGieU
Date: 14.03.2019
*/

public class MatrixTest
{
    public static void testCheckMatrixPessimistic()
    {
        try
        {
            Double[][] arr = new Double[5][];
            for (int i = 0; i < arr.length; i++)
            {
                arr[i] = new Double[i + 2];
            }
            Matrix<Double> matrix = new Matrix<>(arr);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void checkAddMatrix()
    {
        Double[][] arr = new Double[4][4];
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                arr[i][j] = Double.valueOf(j);
            }
        }

        Matrix<Double> matrix=new Matrix<>(arr);
        matrix.addMatrix(arr);
    }

    public static void main(String[] args)
    {
        //testCheckMatrixPessimistic();
        checkAddMatrix();

    }
}
