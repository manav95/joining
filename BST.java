import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;

/**
 * This class implements the BSTInterface
 * @author Manav Dutta
 * @version 2.0
 */
public class BST<T extends Comparable> implements BSTInterface<T> {
    private Node<T> root;
    private int size = 0;
    /**
     * This returns a string representation of the tree
     * @return string representation
     */
    public String toString() { 
        if (root == null) {
            return "()"; 
        }
        return root.toString(); 
    }
    /**
     * Clears the whole tree
     */
    public void clear() {
        root = null;
        size = 0;
    }
    /**
     * Returns the size of the tree
     * @return size of the tree
     */
    public int size() {
        return size;
    }
    /**
     * Returns if tree is empty
     * @return if empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    /**
     * This adds an element to the tree.
     * Throws IllegalArgumentException if data is null
     * @param data to be added
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        else if (contains(data)) {
            return;
        }
        else {
           if (root == null) {
               root = new Node(data);
               size = size + 1;
           }
           else {
               recursiveInsertion(root, data); 
           }
        }
    }
    private void recursiveInsertion(Node<T> node, T data) {
        if (data.compareTo(node.getData()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(data));
                size = size + 1;
            }
            else {
                recursiveInsertion(node.getLeft(), data);
            }
        }
        else {
            if (node.getRight() == null) {
                node.setRight(new Node(data));
                size = size + 1;
            }
            else {
                recursiveInsertion(node.getRight(), data);
            }
        }
    }
    /**
     * Adds the elements of the collection to the 
     * tree. Null collections throw an exception
     * @param c- the collection
     */
    public void addAll(Collection<T> c) {
       if (c == null) {
            throw new IllegalArgumentException();
       }
       for (T data : c) {
           if (data == null) {
               throw new IllegalArgumentException();
           }
           else {
               add(data);
           }
       }
    }
    /**
     * Returns if this tree contains the data
     * Throws exception if data is null
     * @param data- the data
     */
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        return recursiveFinder(root, data);
    }
    private boolean recursiveFinder(Node<T> node, T data) {
       if (node == null) {
           return false;
       }
       else if (node.getData().equals(data)) {
           return true;
       }
       else if (node.getData().compareTo(data) > 0) {
           return recursiveFinder(node.getLeft(), data);
       }
       else {
           return recursiveFinder(node.getRight(), data);
       }
    }
    /**
     * Gets the data from the tree
     * Throws exception if data is null
     * @param data- the data
     * @return the data from the tree
     */
    public T get(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        else if (!contains(data)) {
            return null;
        }
        else {
            return recursiveGetter(root, data);
        }
    }
    private T recursiveGetter(Node<T> node, T data) {
       if (node == null) {
           return null;
       }
       else if (node.getData().equals(data)) {
           return node.getData();
       }
       else if (node.getData().compareTo(data) > 0) {
           return recursiveGetter(node.getLeft(), data);
       }
       else {
           return recursiveGetter(node.getRight(), data);
       }
    }
    /**
     * Removes the data from the tree
     * Throws exception if data is null
     * @param data- the data removed
     */
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        else if (root == null) {
            return null;
        }
        else if (!contains(data)) {
            return null;
        }
        else {
            return removeFinder(null, root, data, " ");
        }
    }
    private T removeFinder(Node<T> parent, Node<T> node, T data, String direction) {
        if (node.getData().equals(data)) {
            if ((node.getLeft() == null && node.getRight() == null) && parent != null) {
                T oldData = node.getData();
                if (direction.equals("left")) {
                    parent.setLeft(null);
                }
                else {
                    parent.setRight(null);
                }
                node = null;
                size = size - 1;
                return oldData;
            }
            else if (node.getData().equals(root.getData()) && node.getLeft() == null) {
                root = node.getRight();
                T oldData = node.getData();
                node = null;
                size = size - 1;
                return oldData;
            }
            else if (node.getData().equals(root.getData()) && node.getRight() == null) {
                root = node.getLeft();
                T oldData = node.getData();
                node = null;
                size = size - 1;
                return oldData;
            }
            else if (node.getLeft() == null) {
                if (direction.equals("left")) {
                    parent.setLeft(node.getRight());
                    node = null;
                }
                else {
                    parent.setRight(node.getRight());
                    node = null;
                }
                size = size - 1;
                return data;
            }
            else if (node.getRight() == null) {
                if (direction.equals("left")) {
                    parent.setLeft(node.getLeft());
                    node = null;
                }
                else {
                    parent.setRight(node.getLeft());
                    node = null;
                }
                size = size - 1;
                return data;
            }
            else if (node.getData().equals(root.getData())) {
                Node<T> smallestRightSide = getSmallestRightSide(node.getRight());
                Node<T> oldRight = node.getRight();
                Node<T> oldLeft = node.getLeft();
                remove(smallestRightSide.getData());
                root = smallestRightSide;
                if (!(smallestRightSide.getData().equals(oldRight.getData()))) {
                    root.setRight(oldRight);
                }
                root.setLeft(oldLeft);
                return data;
            }
            else {
               parent.setLeft(node.getLeft());
               parent.setRight(node.getRight());
               node = null;
               size = size - 1;
               return data;
            }
        }
        else {
            if (node.getData().compareTo(data) > 0) {
                return removeFinder(node, node.getLeft(), data, "left");
            }
            return removeFinder(node, node.getRight(), data, "right");
        }
    }
    private Node<T> getSmallestRightSide(Node<T> node) {
        if (node.getLeft() != null) {
            return getSmallestRightSide(node.getLeft());
        }
        else if (node.getRight() != null) {
            return getSmallestRightSide(node.getRight());
        }
        else {
           return node;
        }
    }
    /**
     * Returns a list containing the nodes in 
     * pre-ordered format.
     * @return the preordered list
     */
    public List<T> preOrder() {
        List<T> list = new ArrayList<T>();
        return preOrderIterator(list, root);
    }
    private List<T> preOrderIterator(List<T> list, Node<T> node) {
        if (node == null) {
            return list;
        }
        else {
            list.add(node.getData());
            list = preOrderIterator(list, node.getLeft());
            list = preOrderIterator(list, node.getRight());
            return list;
        }
    }
    /**
     * Returns a list containing nodes
     * in level order.
     * @return the level ordered list
     */
    public List<T> levelOrder() {
        List<T> list = new ArrayList<T>();
        if (size == 0) {
            return list;
        }
        Queue<Node<T>> queue = new ConcurrentLinkedQueue<Node<T>>();
        queue.add(root);
        while (queue.peek() != null) {
            Node<T> node = queue.poll();
            list.add(node.getData());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return list;
    }
    /**
     * Returns a list containing nodes
     * in order.
     * @return the in order list
     */
    public List<T> inOrder() {
        List<T> list = new ArrayList<T>();
        return inOrderIterator(list, root);
    }
    private List<T> inOrderIterator(List<T> list, Node<T> node) {
        if (node == null) {
            return list;
        }
        else {
            list = inOrderIterator(list, node.getLeft());
            list.add(node.getData());
            list = inOrderIterator(list, node.getRight());
            return list;
        }
    }
    /**
     * Returns a list containing nodes 
     * in post order
     * @return the post ordered list
     */
    public List<T> postOrder() {
        List<T> list = new ArrayList<T>();
        return postOrderIterator(list, root);
    }
    private List<T> postOrderIterator(List<T> list, Node<T> node) {
        if (node == null) {
            return list;
        }
        else {
            list = postOrderIterator(list, node.getLeft());
            list = postOrderIterator(list, node.getRight());
            list.add(node.getData());
            return list;
        }
    }
}

            
            
                       
                
                
            
                
            
                
              
        
      
    

