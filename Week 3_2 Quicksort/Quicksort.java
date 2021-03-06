/**
 * Created by Jeremy on 3/2/16.
 */


/**
 *
 * Repeat until i and j pointers cross.
    - Scan i from left to right so long as (a[i] < a[lo]).
    - Scan j from right to left so long as (a[j] > a[lo]).
    - Exchange a[i] with a[j].

 * When pointers cross.
    - Exchange a[lo] with a[j].

 *
 * **/

public class Quicksort {

    public static int partition(Comparable[] a, int lo, int hi) {

        int i = lo, j = hi + 1;

        while (true) {

            while (Utils.less(a[++i], a[lo])) // find the left item to swap
                if (i == hi)
                    break;
            while (Utils.less(a[lo], a[--j])) // find the right item to swap
                if (j == lo)
                    break;

            if (j <= i)
                break;

            Utils.exchange(a, i, j);
        }
        Utils.exchange(a, lo, j);
        return j;
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);  // shuffling needed for performance guarantee
        sort(a, 0, a.length-1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

}
