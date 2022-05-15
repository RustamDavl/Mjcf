package MyRealization.Interfaces.MList;

import MyRealization.Interfaces.MCollection;

public interface MList<T> extends MCollection<T> {
	
	Comparable<T>[] toComparableArray();
	
	
	
	

}
