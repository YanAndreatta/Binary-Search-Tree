package estruturadedados;

import dataStructure.BST;

public class App 
{
    public static void main( String[] args )
    {
        BST tree = new BST();
        tree.insert(37);
        tree.insert(66);
        tree.insert(42);
        tree.insert(11);
        tree.insert(72);
        tree.insert(8);
        tree.insert(17);
        
        tree.deleteNode(8);
        tree.inOrder();

        // System.out.println(tree.contains(11));
        // System.out.println(tree.contains(99));

        // tree.inOrder();
    }
}
