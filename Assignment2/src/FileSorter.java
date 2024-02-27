//Andrew Lee (alee168@toromail.csudh.edu)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileSorter
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the input file: ");
        String inputFileName = scanner.nextLine();

        int[] inputArray = readFromFile(inputFileName);

        if (inputArray != null)
        {
            bubbleSort(inputArray);

            System.out.print("Enter the name of the output file: ");
            String outputFileName = scanner.nextLine();

            writeToFile(outputFileName, inputArray);

            System.out.println("Sorting completed. Results written to " + outputFileName);
        }
        else
        {
            System.out.println("Error reading the input file. Please check the file name and try again.");
        }
        
    }

    public static int[] readFromFile(String fileName)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            int size = 10; 
            int[] array = new int[size];
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
            return Arrays.copyOf(array, index);
            
        }
        catch (IOException | NumberFormatException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }

    public static void bubbleSort(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                
            }
            
        }
        
    }
    
    public static void writeToFile(String fileName, int[] array)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)))
        {
            for (int number : array)
            {
                bw.write(Integer.toString(number));
                bw.newLine();
            }
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }
    
}