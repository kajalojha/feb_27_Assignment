package Feb_27_Assignment;
class TreeNode//class treenode
{
    int value;
    TreeNode left;
    TreeNode right ;
    public TreeNode(int x)// constrctor
    {
        value = x;
    }
}
class recoverBST// another class to recover BST
{
  public void recoverTree(TreeNode root) {
      TreeNode currentNode = root;
      TreeNode previous = null;
      TreeNode firstNode = null, secondNode = null;
      while (currentNode != null)
      // If current node has no left child
      {
          if (currentNode.left == null)
          {
              // Process current node and move to its right child
              if (previous != null && previous.value > currentNode.value) {
                  // If the previous node's value is greater than the current node's value,
                  // it indicates a violation of BST property
                  if (firstNode == null) {
                      firstNode = previous;// Assign the first violation
                      secondNode = currentNode;// Potential second violation
                  } else {
                      secondNode = currentNode;// Assign the second violation
                  }
              }
              previous = currentNode;// Update prev
              currentNode = currentNode.right;// Move to the right child
          } else
          {
              // If current node has a left child
              // Find the predecessor node
              TreeNode predecessor = currentNode.left;
              while (predecessor.right != null && predecessor.right != currentNode) {
                  predecessor = predecessor.right;
              }
              if (predecessor.right == null)
              {
                  // If predecessor's right child is null, establish link to current
                  predecessor.right = currentNode;
                  currentNode = currentNode.left;// Move to the left child
              } else
              {
                  // If predecessor's right child is current, removethe link and process current node
                  predecessor.right = null;
                  if (previous != null && previous.value > currentNode.value) {
                      // If the previous node's value is greater than the current node's value,
                      // it indicates a violation of BST property
                      if (firstNode == null)
                      {
                          firstNode = previous; // Assign the first violation
                          secondNode = currentNode;// Potential second violation
                      } else {
                          secondNode = currentNode; // Assign the second violation
                      }
                  }

                  previous = currentNode;//update new pointer
                  currentNode = currentNode.right;// move to right child
              }
          }
      }
      // swap the first and second
      if (firstNode != null && secondNode != null) {
          int temp = firstNode.value;
          firstNode.value = secondNode.value;
          secondNode.value = temp;
      }
  }
}
public class Q3_Recover_BST
{
    public static void main(String[] args)
    {
       TreeNode root = new TreeNode((2));
       root.left = new TreeNode(1);
       root.right=new TreeNode(3);
        recoverBST obj = new recoverBST();
        obj.recoverTree(root);

        System.out.println("Swapped values: " + root.left.value + ", " + root.value);

    }
}
