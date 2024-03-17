public class BSTNode<T>
{
  private T val;                // The node info
  private BSTNode<T> left;       // A link to the left child node
  private BSTNode<T> right;      // A link to the right child node

  public BSTNode(T val)
  {
    this.val = val; left = null; right = null;
  }
  public void setVal(T val){
	  this.val = val;
	  }
  public T getInfo(){
	  return val;
	  }

  public void setLeft(BSTNode<T> link){
	  left = link;
	  }
  public void setRight(BSTNode<T> link){
	  right = link;
	  }

  public BSTNode<T> getLeft(){
	  return left;
	  }
  public BSTNode<T> getRight(){
	  return right;
	  }
}

