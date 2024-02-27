//Andrew Lee (alee168@toromail.csudh.edu)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class NumberFileWriter
{
    private int[] array;
    private int size;
    private int loopCycles;

    public NumberFileWriter(String fileName)
    {
        readFromFile(fileName);
    }

    public void writeToFile(String fileName, int[] arrayToWrite)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)))
        {
            for (int number : arrayToWrite)
            {
                bw.write(Integer.toString(number));
                bw.newLine();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void write(int[] arrayToWrite)
    {
        writeToFile("./numberFileOut.txt", arrayToWrite);
    }

    public int[] read()
    {
        return Arrays.copyOf(array, size);
    }

    public int[] sortAsc()
    {
        bubbleSort(true);
        return Arrays.copyOf(array, size);
    }

    public int[] sortDesc()
    {
        bubbleSort(false);
        return Arrays.copyOf(array, size);
    }

    public int loopCycles()
    {
        return loopCycles;
    }

    private void readFromFile(String fileName)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            size = 10;
            array = new int[size];
            int index = 0;

            while ((line = br.readLine()) != null)
            {
                int number = Integer.parseInt(line.trim());
                if (index >= size)
                {
                    size *= 2;
                    array = Arrays.copyOf(array, size);
                }
                array[index++] = number;
            }
            size = index;
            array = Arrays.copyOf(array, size);
        } catch (IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
    }

    private void bubbleSort(boolean ascending)
    {
        loopCycles = 0;
        for (int i = 0; i < size - 1; i++)
        {
            for (int j = 0; j < size - i - 1; j++)
            {
                if (ascending ? array[j] > array[j + 1] : array[j] < array[j + 1])
                {
                    // Swap elements if not in the desired order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                loopCycles++;
            }
        }
    }

    public static void main(String[] args)
    {
        NumberFileWriter numberFileRW = new NumberFileWriter("./numberFile.txt");

        System.out.println("Numbers read from file: " + Arrays.toString(numberFileRW.read()));

        int[] sortedArrayAsc = numberFileRW.sortAsc();
        
        System.out.println("Sorted in Ascending Order: " + Arrays.toString(sortedArrayAsc));
        System.out.println("Loop Cycles for Ascending Order: " + numberFileRW.loopCycles());

        numberFileRW.write(sortedArrayAsc);
        System.out.println("Sorted array written to file: ./numberFileOut.txt");
    }
}
