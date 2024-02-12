public class MergeVsBubble {
    public static void main(String[] args) throws Exception {
        int toSort[] = {5, 77, 23, 0, 48, 7};

        System.out.print("Unsorted array: ");
        printArray(toSort);
        System.out.println();

        //Merge Sort
        System.out.println("Merge sort method: ");
        mergeSort(toSort);
        printArray(toSort);
        System.out.println();
        System.out.println("Time took: " + System.nanoTime());

        //Bubble Sort
        System.out.println("Bubble sort method: ");
        bubbleSort(toSort);
        printArray(toSort);
        System.out.println("Time took: " + System.nanoTime());
    }

    public static void mergeSort(int[] a) //Splits array into subarrays
    {
        int length = a.length; //Get length of array
        if(length <= 1)
        {
            return;
        }

        //Creating the subarrays
        int mid = length / 2; 
        int[] left = new int[mid];
        int[] right = new int[length-mid]; //length-mid b/c if length is odd, 

        int i = 0, j = 0;

        for(i = 0; i < length; i++)
        {
            if(i < mid)
            {
                left[i] = a[i]; //Copy the element at i from a to left
            }
            else{
                right[j] = a[i]; //If i is not less than mid, then copy it to the right array instead
                j++;
            }
        }
        mergeSort(left); //Recursion- calls the arrays back and back again so it keeps splitting up
        mergeSort(right);
        merge(left, right, a); 

    }

    public static void merge(int[] left, int[] right, int[] a) //Merges them back into subarrays
    {
        int leftSize = a.length / 2;
        int rightSize = a.length - leftSize;
        int i = 0, l = 0, r = 0;

        while(l < leftSize && r < rightSize) //While elements exist in the subarrays, add them back into the original 
        {
            if(left[l] < right[r]) //If the left number is smaller than the right....
            {
                a[i] = left[l]; //Add it back to the array
                i++;
                l++;
            }
            else{  //If the right number is smaller than the left...
                a[i] = right[r]; //Add it back to the array
                i++;
                r++;
            }
        }

        //While there's only one element left in the subarray
        while(l < leftSize) 
        {
            a[i] = left[l];
            i++;
            l++;
        }
        while(r < rightSize)
        {
            a[i] = right[r];
            i++;
            r++;
        }

    }

    public static void bubbleSort(int[] a)
    {
        int i, j;
        int n = a.length;
        int temp;

        for(i = 0; i < n - 1; i++)
        {
            for(j = 0; j < n - i - 1; j++)
            {
                if(a[j] < a[j+1]) //If the current number is smaller than the next...
                {
                    temp = a[j];
                    a[j] = a[j + 1]; //Switch places
                    a[j + 1] = temp;
                }
            }
        }
    }
    
    public static void printArray(int[] a)
    {
        for(int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }



}

