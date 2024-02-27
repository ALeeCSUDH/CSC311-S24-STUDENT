//Andrew Lee (alee168@toromail.csudh.edu)

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class NumberFileReader
{
    private int[] array;
    private int size;
    private int loopCycles;

    public NumberFileReader(String fileName)
    {
        readFromFile(fileName);
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
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (ascending ? array[j] > array[j + 1] : array[j] < array[j + 1])
                {
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
        NumberFileReader numberFileReader = new NumberFileReader("./numberFile.txt");

        System.out.println("Numbers read from file: " + Arrays.toString(numberFileReader.read()));
        System.out.println("");
        
        System.out.println("Sorted in Ascending Order: " + Arrays.toString(numberFileReader.sortAsc()));
        System.out.println("Loop Cycles for Ascending Order: " + numberFileReader.loopCycles());
        
        System.out.println("");

        System.out.println("Sorted in Descending Order: " + Arrays.toString(numberFileReader.sortDesc()));
        System.out.println("Loop Cycles for Descending Order: " + numberFileReader.loopCycles());
    }
    
}