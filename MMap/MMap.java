package MyRealization.MMap;

public interface MMap<K extends Comparable<? super K>,V> {
	
	int getSize();
	
	boolean isEmpty();
	
	void put(K key, V value);
	
	boolean containsKey(K key);
	
	V remove (K key);
	
	int hash(K key);
	
	
	
	interface Entry<K extends Comparable<? super K>,V>  {
		
	   K getKey();
	   
	   V getValue();
	   
	   
	   
	   void setValue(V value);
	   
	   void setKey(K key);
		
	}
	

}
