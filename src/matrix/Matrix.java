package matrix;
/*
Author: BeGieU
Date: 14.03.2019
*/

import java.util.Iterator;
import java.util.function.Consumer;

public class Matrix<T extends Number> implements Iterator<T>
{
    private T[][] elementsArr;
    private int rows;
    private int columns;


    public Matrix(T[][] elementsArr)
    {
        if (!isMatrix(elementsArr))
            throw new IllegalArgumentException("given arr doesnt contain matrix: matrix has to have columns of equal length");

        this.elementsArr = elementsArr;
        columns = elementsArr.length;
        rows = elementsArr[0].length;
    }

    private boolean isMatrix(T[][] elementsArr)
    {
        //checks whether matrix has proper size (has to be rectangle)
        int rowLength = elementsArr[0].length;
        for (int i = 1; i < elementsArr.length; i++)
        {
            //if size is wrong returns false
            if (rowLength != elementsArr[i].length)
                return false;
        }

        return true;
    }

    //check if given array has same columns and rows size
    private boolean hssEqualSize(T[][] arr)
    {
        //        if (arr.length != columns)
        //            return false;
        //        else if (arr[0].length != rows)
        //            return false;
        //        else
        //            return true;

        //assumes that given arr passed isMatrix
        return (arr.length == columns) && (arr[0].length == rows);
    }

    //checks if adding given array to this.elementsArr is possible
    private boolean mayAdd(T[][] arr)
    {
        return isMatrix(arr) && hssEqualSize(arr);
    }

    public T[][] addMatrix(T[][] arr)
    {
        //check given arr
        if (!mayAdd(arr))
            return null;


        for (int i = 0; i < columns; i++)
        {
            //todo check this warning
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = (T) Double.valueOf(arr[i][j].doubleValue() + elementsArr[i][j].doubleValue()); //For starters cast double to Double then to T that extends Number
        }
        return arr;
    }

    @Override
    public boolean hasNext()
    {
        return false;
    }

    @Override
    public T next()
    {
        return null;
    }

    @Override
    public void remove()
    {

    }

    @Override
    public void forEachRemaining(Consumer<? super T> action)
    {

    }

    public static void main(String[] args)
    {
    }
}
