package seniorsort;

/**
 * Created by KaiLin.Guo on 2018-05-10.
 */
public class QuickSort {
    private long[] theArray;
    private int nElems;

    public QuickSort(int max) {
        theArray = new long[max];
        this.nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        System.out.printf("A=");
        for (int j = 0; j < nElems; j++) {
            System.out.printf(theArray[j] + " ");
        }
        System.out.println("");
    }

    public void quickSort() {

        recQuickSort(0, nElems - 1);
    }

    public void recQuickSort(int left, int right) {
        if (right - left <= 0)
            return;
        else {
            long pivot = theArray[right];
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition -1);
            recQuickSort(partition + 1, right);
        }

    }

    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (theArray[++leftPtr] < pivot);
            while (rightPtr > 0 && theArray[--rightPtr] > pivot);
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right);
        return leftPtr;
    }

    public void swap(int one,int two){
        long temp = theArray[one];
        theArray[one] = theArray[two];
        theArray[two] = temp;
    }

    public static void main(String[] args) {
        int maxSize = 16;
        QuickSort quickSort = new QuickSort(maxSize);
        for (int j = 0; j < maxSize; j++) {
            long n = (int)(Math.random() * 99);
            quickSort.insert(n);
        }
        quickSort.display();
        quickSort.quickSort();
        quickSort.display();
    }

}
