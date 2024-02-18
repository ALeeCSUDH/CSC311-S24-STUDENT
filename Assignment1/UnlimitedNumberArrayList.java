//Andrew Lee (alee168@toromail.csudh.edu)

import java.util.ArrayList;

public class UnlimitedNumberArrayList
{
    private ArrayList<Integer> list;

    public UnlimitedNumberArrayList()
    {
        this.list = new ArrayList<>();
    }

    public int add(int number)
    {
        list.add(number);
        return list.size() - 1;
    }

    public int get(int index)
    {
        if (index >= 0 && index < list.size())
        {
            return list.get(index);
        }
        else
        {
            System.out.println("Invalid index.");
            return -1;
        }
    }

    public int size()
    {
        return list.size();
    }

    public int[] find(int number)
    {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) == number)
            {
                indices.add(i);
            }
        }
        int[] result = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++)
        {
            result[i] = indices.get(i);
        }
        return result;
    }

    public int getLargest()
    {
        if (list.isEmpty())
        {
            return -1;
        }
        int max = list.get(0);
        for (int num : list)
        {
            if (num > max)
            {
                max = num;
            }
        }
        return max;
    }

    public int getSmallest()
    {
        if (list.isEmpty())
        {
            return -1;
        }
        int min = list.get(0);
        for (int num : list)
        {
            if (num < min)
            {
                min = num;
            }
        }
        return min;
    }

    public int getAverage()
    {
        if (list.isEmpty())
        {
            return -1;
        }
        int sum = 0;
        for (int num : list)
        {
            sum += num;
        }
        return sum / list.size();
    }

    public void print() 
    {
        System.out.println(list);
    }

    public static void main(String[] args)
    {
    	UnlimitedNumberArrayList myList = new UnlimitedNumberArrayList();

        myList.add(1);
        myList.add(99);
        myList.add(55);
        myList.add(44);
        myList.add(66);
        myList.add(33);
        myList.add(77);
        myList.add(33);
        myList.add(88);
        myList.add(22);
        myList.add(99);
        myList.add(11);

        myList.print();

        int element = myList.get(1);
        System.out.println("Element at index 1: " + element);

        int[] index = myList.find(99);
        System.out.println("Index containing 99: " + java.util.Arrays.toString(index));

        int largest = myList.getLargest();
        int smallest = myList.getSmallest();
        int average = myList.getAverage();
        
        System.out.println("Largest Number : " + largest);
        System.out.println("Smallest Number: " + smallest);
        System.out.println("Average Number : " + average);
    }
}