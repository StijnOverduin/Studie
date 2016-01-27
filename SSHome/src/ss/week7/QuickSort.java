package ss.week7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class QuickSort {
	
    /**
	 * 
	 */
	

	public static void qsort(int[] a) {
        qsort(a, 0, a.length - 1);
    }
	
    public static void qsort(int[] a, int first, int last) {
        if (first < last) {
            int position = partition(a, first, last);
            QuickThread t1 = new QuickThread(a, first, position - 1);
            QuickThread t2 = new QuickThread(a, position + 1, last);
            t1.start();
            t2.start();
            try {
            	t1.join();
            	t2.join();
            } catch (InterruptedException e) {
            	
            }
           
        }
    }
    
    /*
     *  qsort(a, first, position - 1);
            qsort(a, position + 1, last);
     */
    public static int partition(int[] a, int first, int last) {

        int mid = (first + last) / 2;
        int pivot = a[mid];
        swap(a, mid, last); // put pivot at the end of the array
        int pi = first;
        int i = first;
        while (i != last) {
            if (a[i] < pivot) {
                swap(a, pi, i);
                pi++;
            }
            i++;
        }
        swap(a, pi, last); // put pivot in its place "in the middle"
        return pi;
    }
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    static class QuickThread extends Thread {
    	private int[] a;
    	private int first;
    	private int last;
    	
    	public QuickThread(int[] a, int first, int last) {
    		this.a = a;
    		this.first = first;
    		this.last = last;
    		
    	}
    	public void run() {
    		qsort(a, first, last);
    	}
    }

}
