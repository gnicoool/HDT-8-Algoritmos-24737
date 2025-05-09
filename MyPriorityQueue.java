/*
 * Interface para PriorityQueue
 * 
 */
public interface MyPriorityQueue<E extends Comparable<E>> {
    public E getFirst();
    public E remove();
    public void add(E value);
    public boolean isEmpty();
    public int size();
    public void clear();
}
