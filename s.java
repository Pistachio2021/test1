import CITS2200.Sort;

import java.util.Arrays;

/**
 * A class to give a comaprative view of common sorting algorithms.
 * The maintains a private static variable that counts the number
 * of array assignments that are performed (as an approximate measure
 * of the complexity of the algorithm.
 * @author Tim French.
 **/

public class Sorter implements Sort
{
    private int count;

    /**
     * Returns the number of array assignment operations
     * performed by this class since the count variable was reset.
     * @return the number of assignments
     **/
    public int getCount(){
        return count;

    }

    /**
     *Resets the counter variable to 0
     **/
    public void reset(){

        count = 0;
    }

    /**
     * Executes the insertion sort algorithm sorting the argument array.
     * There is no return as the parameter is to be mutated.
     * @param a the array of long integers to be sorted
     **/





    public void insertionSort(long[] a)
    {


        // To ensure a thorough iteration to ensure every element is sorted.
        for(int i =1;i<a.length;i++){
             int j = i;
             long temp = 0;
             //Sort from the second element from left to right.
            while(j>0 && a[j]<a[j-1]){
            // If the right element is greater than left element, then swap.
                temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
                j--;
                count++;
            }
            count++;
            }
        }








    /**
     * Executes the quick sort algorithm sorting the argument array.
     * There is no return as the parameter is to be mutated.
     * @param a the array of long integers to be sorted
     **/
    public void quickSort(long[] a){


        //Call the quickSort method and hide the method from outer class.
        quickSort(a,0,a.length-1);



    }

    private void quickSort(long[] a,int left, int right){
        int i = left;
        int j = right;

        //Create a pivot
        long pivot = a[left];

        //To ensure the all elements at the left side of pivot are smaller than pivot
        //To ensure the all elements at the right side of pivot are greater than pivot


        while(i < j){
            long temp = 0;

            // keep looking for the elements from the right side which are greater than pivot
            while(a[j] > pivot){
                j--;
                count++;

            }
            // keep looking for the elements from the left side which are smaller than pivot
            while( a[i]< pivot) {
                i++;
                count++;

            }

            //If found the elements greater than pivot or smaller than pivot,exchange the locations
            // finally exchange the pivot location
            if (i <= j){
                temp = a[i];
                a[i] =a[j];
                a[j] = temp;
                i++;
                j--;
            }
            count++;
        }
        // while completing the pivot moving, sorting the left part
        // till finding the exit( only one element left at left side)
        if (left < j)
            quickSort(a, left, j);

        // while completing the pivot moving, sorting the right part
        // till finding the exit( only one element left at right side)
        if (i < right)
            quickSort(a, i, right);
        }








    /**
     * Executes the merge sort algorithm sorting the argument array.
     * There is no return as the parameter is to be mutated.
     * @param a the array of long integers to be sorted
     **/
    public void mergeSort(long[] a){

        mergeSort(a, 0, a.length-1);
    }

    /**
     *A private method to merge the elements in the array between p and r.
     *the array a, between the indices p and r, inclusive.
     *Given the array is sorted between p and q and q+1 and r
     *sorts the array between p and r.
     *@param a the array to be sorted, which is mutated by the method
     *@param p the lower index of the range to be partitioned
     *@param q the midpoint of the two sorted sections.
     *@param r the upper index of the range to be paritioned
     *@return the index of the point of partition
     **/
    private void merge(long[] a, int p, int q, int r)
    {
        int n = q-p+1;
        int m = r-q;
        long[] an = new long[n];
        long[] am = new long[m];
        for(int i = 0; i<n; i++) {
            an[i] = a[p+i];
            count++;
        }
        for(int i = 0; i<m; i++){
            am[i] = a[q+i+1];
            count++;
        }
        int i = 0;
        int j = 0;
        for(int k = p; k<=r; k++){
            if(i==n) a[k] = am[j++];
            else if(j==m || an[i]<am[j]) a[k] = an[i++];
            else a[k] = am[j++];
            count++;
        }
    }

    /**
     *Overloads the mergeSort method with parameters to set the
     *range to be sorted.
     **/
    private void mergeSort(long[] a, int p, int r)
    {
        if(p<r){
            int i = (p+r)/2;
            mergeSort(a,p,i);
            mergeSort(a,i+1,r);
            merge(a, p,i,r);
        }
    }



}