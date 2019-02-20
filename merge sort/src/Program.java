public class Program {
    public static void main(String[] args) {

        int[] array = {4, 9, 7, 6, 5, 3};  //The array that will be sorted

        array = mergeSort(array);   //Initiating the mergeSort functions

        for (int t : array) {  //printing sorted array values on screen
            System.out.println(t);
        }
    }

    //the function for splitting an array into two subarrays
    static int[] mergeSort(int[] lst) {
        int n = lst.length; //variable representing number of elements in array
        int[] left;  //sub-array representing the left side of the split array
        int[] right; //sub-array representing the right side of the split array

        //conditions used to create space for sub-arrays
        if ((n % 2) == 0) {
            //if number of elements in array are even, then the sumber of elements will be split evenly among the sub-arrays
            left = new int[n / 2];
            right = new int[n / 2];
        } else {            //if number of elements in array is odd, then the right sub-array will containg +1 more elements
            left = new int[n / 2];
            right = new int[n / 2 + 1];
        }

        //loop used to fill sub-arrrays
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {         //if the elements is from the first half then it will populate the left sub-array
                left[i] = lst[i];
            } else {            //if the element is from the right half of the array then it will fill the right sub-array
                right[i - n / 2] = lst[i];
            }
        }
        //function will continue to split until sub-arrays have 1 element left
        if (n > 1) {
            //recursive splitting of sub-arrays
            left = mergeSort(left); //recursively split left sub-array
            right = mergeSort(right);   //recursively split right sub-array
        }
        return merge(left, right);  //return the array after is has passed through the merge() function
    }

    // the function for merging two sorted arrays
    static int[] merge(int[] left, int[] right) {
        //create space for the merged array
        int[] result = new int[left.length + right.length];   //size of merged array will be the sum of the number of elements from the left and right sub-array
        //creating index for each array/sub-array
        int i = 0;        //index for left sub-array
        int j = 0;        //index for right sub-array
        int index = 0;    //index for merged array

        //loop used to compare and fill the merged array
        while ((i < left.length) && (j < right.length)) {
            if (left[i] < right[j]) {
                //if element from left sub-array is of smaller value than that of right sub-array then in will be placed in the current position of merged array
                result[index++] = left[i++];
            } else {
                result[index++] = right[j++];
            }
        }
        //loops used to add remaining elements into the merged array
        while (i < left.length) {
            result[index++] = left[i++];
        }

        while (j < right.length) {
            result[index++] = right[j++];
        }

        return result;  //return the merged array
    }
}


