
	import java.util.Iterator;
	import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a binary search tree
        BSTInterface<Integer> bst = new BinarySearchTree<>();

        // Add elements to the tree
        bst.add(50);
        bst.add(30);
        bst.add(70);
        bst.add(20);
        bst.add(40);

        // Print current contents of the tree (in-order traversal)
        System.out.println("Current contents of the tree (in-order traversal):");
        printTreeContents(bst.inOrder());

        // Check if the tree contains a specific element
        int elementToFind = 30;
        if (bst.contains(elementToFind)) {
            System.out.println("The tree contains element " + elementToFind);
        } else {
            System.out.println("The tree does not contain element " + elementToFind);
        }

        // Delete an element from the tree
        int elementToDelete = 20;
        bst.delete(elementToDelete);
        System.out.println("Deleted element " + elementToDelete);

        // Print current contents of the tree after deletion
        System.out.println("Do you want to print your tree? ");
        Scanner keyboard = new Scanner(System.in);
        String printTree = keyboard.nextLine();
        
        while(printTree.toLowerCase().equals("yes")) {
        System.out.println("What traversal do you want to use to print your tree?  ");
        System.out.println("A.In order \nB.Pre-order \nC.Post-order \nD.Breadth First Search");
        
        String choice = keyboard.nextLine();
        
        switch (choice.toLowerCase().charAt(0)) {
        case 'a':
        	printTreeContents(bst.inOrder());
        	break;
        case 'b':
        	printTreeContents(bst.preOrder());
        	break;
        case 'c':
        	printTreeContents(bst.postOrder());
        	break;
        case 'd':
        	printTreeContents(bst.breadthFirstSearch());
        	break;
        }
        System.out.println("Do you want to print your tree? ");
        printTree = keyboard.nextLine();
        	
        }
    }

    // Method to print the contents of the tree using an iterator
    private static void printTreeContents(Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
