//Andrew Lee (alee168@toromail.csudh.edu)

import java.util.Arrays;

public class BubbleSort 
{

    private int[] array;
    private int size;
    private int loopCycles;

    public BubbleSort(int[] inputArray)
    {
        this.array = Arrays.copyOf(inputArray, inputArray.length);
        this.size = inputArray.length;
        this.loopCycles = 0;
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

    private void bubbleSort(boolean ascending)
    {
        loopCycles = 0;
        for (int i = 0; i < size - 1; i++)
        {
            for (int j = 0; j < size - i - 1; j++)
            {
                if ((ascending && array[j] > array[j + 1]) || (!ascending && array[j] < array[j + 1]))
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
    	BubbleSort bubble = new BubbleSort(new int[]{23, 2, 3, 1000, 41, 63});

        System.out.println("Sorted in Ascending Order: " + Arrays.toString(bubble.sortAsc()));
        System.out.println("Loop Cycles for Ascending Order: " + bubble.loopCycles());
        
        System.out.println("");

        System.out.println("\nSorted in Descending Order: " + Arrays.toString(bubble.sortDesc()));
        System.out.println("Loop Cycles for Descending Order: " + bubble.loopCycles());
        
    }
    
}
