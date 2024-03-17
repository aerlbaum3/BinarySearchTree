
import java.util.Iterator;

public interface BSTInterface<T extends Comparable<T>> {
    int size();
    void add(T data);
    boolean contains(T data);
    void delete(T data);
    String toString();
    boolean isEmpty();
    T findMin();
    T findMax();
    // Used to specify traversal order.
    Iterator<T> preOrder();
    Iterator<T> inOrder();
    Iterator<T> postOrder();
    Iterator<T> breadthFirstSearch();
    Iterator<T> getIterator(Traversal orderType);
    int compareTo(BinarySearchTree<T> otherTree);
}
