import java.util.*; // Iterator, Comparator


public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T>{
	
	private BSTNode<T> root;
    // Constructor
    public BinarySearchTree() {
        this.root = null;
    }

    // Implementation of TreeInterface methods
    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    private int size(BSTNode<T> node) {
        if (node == null) return 0;
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    public void add(T data) {
    	System.out.println("Adding: " + data);
        root = add(root, data);
        System.out.println(data + " has been Added");
    }

    private BSTNode<T> add(BSTNode<T> node, T data) {
        if (node == null) {
            return new BSTNode<>(data);
        }

        int compare = data.compareTo(node.getInfo());
        if (compare < 0) {
            node.setLeft(add(node.getLeft(), data));
        } else if (compare > 0) {
            node.setRight(add(node.getRight(), data));
        }

        return node;
    }


	public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(BSTNode<T> node, T data) {
        if (node == null) {
            return false;
        }

        int cmp = data.compareTo(node.getInfo());
        if (cmp < 0) {
            return contains(node.getLeft(), data);
        } else if (cmp > 0) {
            return contains(node.getRight(), data);
        } else {
            return true; // Found the data
        }
    }

    // Implement delete method
    @Override
    public void delete(T data) {
    	System.out.println("Deleting: " + data);
        root = delete(root, data);
        System.out.println(data + " has been deleted");
    }

    private BSTNode<T> delete(BSTNode<T> node, T data) {
        if (node == null) {
            return null;
        }

        int cmp = data.compareTo(node.getInfo());
        if (cmp < 0) {
            node.setLeft(delete(node.getLeft(), data));
        } else if (cmp > 0) {
            node.setRight(delete(node.getRight(), data));
        } else {
            // Node to delete found
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                // Node has two children
                node.setVal(min(node.getRight())); // Replace node with the minimum value from right subtree
                node.setRight(delete(node.getRight(), node.getInfo())); // Delete the minimum value node
            }
        }
        return node;
    }

    // Implement min method
    @Override
    public T findMin() {
        if (root == null) {
            return null;
        }
        return min(root);
    }

    private T min(BSTNode<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getInfo();
    }

    // Implement max method
    @Override
    public T findMax() {
        if (root == null) {
            return null;
        }
        return max(root);
    }

    private T max(BSTNode<T> node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.getInfo();
    }

    // Implement traversal methods
 // Pre-order traversal method
    public Iterator<T> preOrder() {
        Queue<T> queue = new LinkedList<>();
        preOrderTraversal(root, queue);
        return queue.iterator();
    }

    private void preOrderTraversal(BSTNode<T> node, Queue<T> queue) {
        if (node != null) {
            queue.offer(node.getInfo());
            preOrderTraversal(node.getLeft(), queue);
            preOrderTraversal(node.getRight(), queue);
        }
    }

    // In-order traversal

    // In-order traversal method
    public Iterator<T> inOrder() {
        Queue<T> queue = new LinkedList<>();
        inOrderTraversal(root, queue);
        
        return queue.iterator();
    }

    // Helper method for in-order traversal
    private void inOrderTraversal(BSTNode<T> node, Queue<T> queue) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), queue);
            queue.offer(node.getInfo());
            inOrderTraversal(node.getRight(), queue);
        }
    }
 // Post-order traversal method
    public Iterator<T> postOrder() {
        Queue<T> queue = new LinkedList<>();
        postOrderTraversal(root, queue);
        return queue.iterator();
    }

    private void postOrderTraversal(BSTNode<T> node, Queue<T> queue) {
        if (node != null) {
            postOrderTraversal(node.getLeft(), queue);
            postOrderTraversal(node.getRight(), queue);
            queue.offer(node.getInfo());
        }
    }


    // Level-order traversal (Breadth First Search)
 // Level-order traversal method
    public Iterator<T> breadthFirstSearch() {
        Queue<T> queue = new LinkedList<>();
        breadthFirstSearch(queue);
        return queue.iterator();
    }

    private void breadthFirstSearch(Queue<T> queue) {
        if (root == null) {
            return;
        }

        Queue<BSTNode<T>> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            BSTNode<T> current = nodeQueue.poll();
            queue.offer(current.getInfo());

            if (current.getLeft() != null) {
                nodeQueue.offer(current.getLeft());
            }
            if (current.getRight() != null) {
                nodeQueue.offer(current.getRight());
            }
        }
    }

		@Override
		public Iterator<T> getIterator(Traversal orderType) {
		    switch (orderType) {
		        case Inorder:
		            return inOrder();
		        case Preorder:
		            return preOrder();
		        case Postorder:
		            return postOrder();
		        case breadthFirstSearch:
		            return breadthFirstSearch();
		        default:
		            throw new IllegalArgumentException("Invalid traversal order: " + orderType);
		    }
		}
		public BSTNode<T> getRoot() {
		    return root;
		}

		@Override
		public int compareTo(BinarySearchTree<T> otherTree) {
		    // Compare the roots of the two trees
		    if (root == null && otherTree.root == null) {
		        return 0; // Both trees are empty
		    } else if (root == null) {
		        return -1; // This tree is empty, otherTree is not
		    } else if (otherTree.root == null) {
		        return 1; // otherTree is empty, this tree is not
		    }

		    // Compare the values of the roots
		    return root.getInfo().compareTo(( otherTree).getRoot().getInfo());
		}
}
