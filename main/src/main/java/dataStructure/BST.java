package dataStructure;

public class BST {

  private Node root;

  public class Node {

    private int value;
    public Node left;
    public Node right;

    public Node(int value) {
      this.value = value;
    }

    public boolean isLeaf() {
      return (this.left == null) && (this.right == null);
    }

    public int getValue() {
      return value;
    }
  }

  public void insert(int value) {
    if (root == null) {
      root = new Node(value);
    } else {
      insert(root, value);
    }
  }

  private void insert(final Node root, final int value) {
    if (root == null)
      return;
    if (value == root.value)
      return; // Não vai inserir se já houver o valor na árvore.

    if (value > root.value) {
      if (root.right == null)
        root.right = new Node(value);
      else
        insert(root.right, value);
    } else {
      if (root.left == null)
        root.left = new Node(value);
      else
        insert(root.left, value);
    }
  }

  public void inOrder() {
    inOrder(root);
  }

  private void inOrder(Node node) { // Imprime o lado esquerdo, raiz e direita de uma árvore binária.
    // E R D
    if (node == null)
      return;
    inOrder(node.left);
    System.out.println(node.value);
    inOrder(node.right);
  }

  public boolean contains(int value) {
    return contains(root, value);
  }

  public boolean contains(final Node root, final int value) {
    if (root == null)
      return false;
    if (value == root.value)
      return true;

    if (value > root.value)
      return contains(root.right, value);
    else
      return contains(root.left, value);

  }

  public int minValue(Node currentNode) {
    while (currentNode.left != null) {
      currentNode = currentNode.left;
    }
    return currentNode.value;
  }

  public void deleteNode(int value) {
    root = deleteNode(root, value);
  }

  private Node deleteNode(final Node root, final int value) {
    if (root == null) return null;

    if (value < root.value) {
      root.left = deleteNode(root.left, value);
    } else if (value > root.value) {
      root.right = deleteNode(root.right, value);
    } else {
      if ((root.left == null) && (root.right == null)) {
        return null;
      } else if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        int minValue = minValue(root.right);
        root.value = minValue;
        root.right = deleteNode(root.right, minValue);
      }
    }
    return root;
  }

}
