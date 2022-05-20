package MyRealization.Classes;

import java.util.Iterator;

import MyRealization.AbstractClasses.AbsArrayList;
import MyRealization.MyCollections.MCollections;


public class MArrayList<T extends Comparable<T>> extends AbsArrayList<T> {

	@SuppressWarnings("unchecked")
	public MArrayList(T ... args) {
		super(args);
	}
	
	

	

}
