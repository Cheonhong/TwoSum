import java.util.Arrays;
import java.util.*;

public class TwoSum
{
    public int[] twoSum(int[] num, int sum)
    {
        int[] ogArr = Arrays.copyOfRange(num, 0, num.length); // copy of original array for getting the correct index at the end
        ogArr = removeDuplicate(ogArr, ogArr.length);
        
        for (int i = ogArr.length-1; i >=0; i--) // removing the 0s at the end of the array if there were duplicates
        {
            if(ogArr[i] == 0)
            {
                ogArr = Arrays.copyOfRange(ogArr, 0, i);
            }
        }

        int size = num.length;
        int cut = num.length;

        sort(num);
        System.out.println("Array: ");
        printArray(ogArr);

        for (int i = 1; i < size; i++) // cutting the array for if there are any elements that exceeds the target value
        {
            if(num[size-i] >= sum)
            {
                cut--;
            }
        }

        int[] newArr = Arrays.copyOfRange(num, 0, cut); // copying the array to create a new array only with relevant elements
        newArr = removeDuplicate(newArr, newArr.length);
        boolean sumFound = false;

        int num1 = 0;
        int num2 = 0;
        int start = 1;

        for(int i = 0; i < newArr.length; i++)  // finding the values of sum that equals to the target
        {
            for (int j = start; j < newArr.length; j++)
            {
                if(newArr[i]+newArr[j] == sum)
                {
                    num1 = newArr[i];
                    num2 = newArr[j];
                }
            }
            start++;
        }

        int n = ogArr.length;
        int index1 = Search(ogArr, num1);
        int index2 = Search(ogArr, num2);

        int ans[] = {index1, index2};

        return ans;
    }

    private void sort (int arr[]) // sort method
    {
        int n = arr.length;

        for (int i = 0; i< n-1; i++)
        {
            int min_index = i;
            for (int j = i + 1; j < n; j++)
            {
                if (arr[j] < arr[min_index])
                    min_index = j;
            }

            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i]= temp;
        }
    }

    private void printArray(int arr[])
    {
        for (int num : arr) {
            System.out.print(num + "  ");
        }
    }

    private int Search(int arr[], int x) 
    { 
        for(int i = 0; i < arr.length; i++)
        {
            if (arr[i]==x)
                return i;
        }
        return -1;
    } 

    private int[] removeDuplicate(int arr[], int n)
    {
        int[] temp = new int[n]; 
        int j = 0;

        for (int i = 0; i < n-1; i++)
        {
            if (arr[i]!= arr[i+1])
            {
                temp[j++] = arr[i];
            }
        }
        temp[j++] = arr[n-1];
        return temp;
    }

    public static void main(String[] args)
    {
        TwoSum ob = new TwoSum();
        int arr[] = {1, 13, 18, 20, 20, 30};
        int target = 40;

        int[] answer;
        answer = ob.twoSum(arr, target);

        System.out.println("");
        ob.printArray(answer);
    }
}