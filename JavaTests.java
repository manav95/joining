import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class JavaTests
{
    private BSTInterface<Integer> tree;
    private static final int TIMEOUT = 300;
    @Before
    public void setUp() throws Exception {
        tree = new BST<Integer>();
    }
    @Test(timeout = TIMEOUT)
    public void loadTree() {
        BSTInterface<String> tree = new BST<String>();
        tree.add("M");
        assertTrue(tree.size() == 1);
        assertTrue(tree.contains("M"));
        tree.add("A");
        tree.add("B");
        tree.add("C");
        tree.add("Y");
        tree.add("X");
        tree.add("T");
        assertTrue(tree.size() == 7);
        assertTrue(tree.contains("B"));
        assertTrue(tree.contains("T"));
        assertTrue(tree.contains("Y"));
        List<String> preOrder = tree.preOrder();
        List<String> inOrder = tree.inOrder();
        List<String> postOrder = tree.postOrder();
        List<String> levelOrder = tree.levelOrder();
        assertArrayEquals(new String[]{"M","A","B","C","Y","X","T"}, preOrder.toArray());
        assertArrayEquals(new String[]{"A","B","C","M","T","X","Y"}, inOrder.toArray());
        assertArrayEquals(new String[]{"C","B","A","T","X","Y","M"}, postOrder.toArray());
        assertArrayEquals(new String[]{"M","A","Y","B","X","C","T"}, levelOrder.toArray());
        tree.remove("X");
        tree.remove("B");
        preOrder = tree.preOrder();
        inOrder = tree.inOrder();
        postOrder = tree.postOrder();
        levelOrder = tree.levelOrder();
        assertTrue(tree.size() == 5);
        assertFalse(tree.contains("B"));
        assertTrue(tree.contains("T"));
        assertTrue(tree.contains("Y"));
        assertFalse(tree.contains("S"));
        assertArrayEquals(new String[]{"M","A","C","Y","T"}, preOrder.toArray());
        assertArrayEquals(new String[]{"A","C","M","T","Y"}, inOrder.toArray());
        assertArrayEquals(new String[]{"C","A","T","Y","M"}, postOrder.toArray());
        assertArrayEquals(new String[]{"M","A","Y","C","T"}, levelOrder.toArray());
    }
    @Test(timeout = TIMEOUT)
    public void loguesTree() {
        tree = new BST<Integer>();
        for (int i = 40; i >= 0; i = i - 2) {
            tree.add(i);
        }
        for (int b = 42; b <= 100; b = b + 2) {
            tree.add(b);
        }
        int counter = 0;
        while (counter <= 32) {
            tree.remove(counter * 2);
            List<Integer> inOrder = tree.inOrder();
            ArrayList<Integer> newList = new ArrayList<Integer>();
            for (int i = counter * 2 + 2; i <= 100; i = i + 2) {
                newList.add(i);
            }
            assertArrayEquals(inOrder.toArray(),newList.toArray());
            counter = counter + 1;
        }
    }
}


