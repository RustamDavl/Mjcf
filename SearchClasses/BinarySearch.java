package MyRealization.SearchClasses;



public class BinarySearch {
	

	
	public static<T extends Comparable<? super T>> int rank(Comparable<T>[] comparables, T element) {
		if (element == null)
			throw new IllegalArgumentException("argument to rank() is null");

		int lo = 0, hi = comparables.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			
			@SuppressWarnings("unchecked")
			int cmp = element.compareTo((T)comparables[mid]);
			if (cmp < 0)
				hi = mid - 1;
			else if (cmp > 0)
				lo = mid + 1;
			else
				return mid;
		}
		return lo;
	}

}
