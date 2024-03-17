import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator; 

import org.junit.jupiter.api.Test;

class TestingForBst {

	@Test
	void testAddOnBst() {
		BSTInterface<Integer> bst = new BinarySearchTree<>();
		 bst.add(50);
		 assertTrue(bst.contains(50));

	}
	
	@Test
	void testDeletingNodeFromBst() {
		BSTInterface<Integer> bst = new BinarySearchTree<>();
		 bst.delete(50);
		 assertFalse(bst.contains(50));

	}
	@Test
	void testMin() {
		BSTInterface<Integer> bst = new BinarySearchTree<>();
	        bst.add(5);
	        bst.add(3);
	        bst.add(7);
	        assertEquals((Integer) 3, bst.findMin());
	       
	    }
	@Test
	void testMax() {
		BSTInterface<Integer> bst = new BinarySearchTree<>();
		bst.add(5);
        bst.add(3);
        bst.add(7);
        assertEquals((Integer) 7, bst.findMax());
	}
	@Test
    public void testTraversal() {
        BSTInterface<Integer> bst = new BinarySearchTree<>();
        bst.add(50);
        bst.add(30);
        bst.add(70);
        bst.add(20);
        bst.add(40);

        Iterator<Integer> iterator = bst.inOrder();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append(" ");
        }
        String expected = "20 30 40 50 70 ";
        assertEquals("In-order traversal should match", expected, sb.toString());
    }
}


