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


/**
 * Binary Search Tree tests for
 * CS 1332 Homework 05
 *
 * Created February 11, 2014
 *
 * @author Jonthan Jemson
 * @version 1.0
 */
public class BasicBSTTests {
    private BSTInterface<Integer> tree;
    @Before
    public void setUp() throws Exception {
        tree = new BST<Integer>();
    }

    /*
     * Null Argument Tests
     *
     * These tests check to ensure
     * IllegalArgumentException is thrown
     * when null is passed in as a parameter
     * to the various methods.
     */
    @Test(timeout = 200, expected = IllegalArgumentException.class)
    public void testNullAdd() {
        tree.add(null);
    }
    @Test(timeout = 200, expected = IllegalArgumentException.class)
    public void testNullAddAll() {
        tree.addAll(null);
        assertNull(tree.get(null));
    }
    @Test(timeout = 200, expected = IllegalArgumentException.class)
    public void testNullRemove() {
        assertNull(tree.remove(null));
    }
    @Test(timeout = 200, expected = IllegalArgumentException.class)
    public void testNullContains() {
        assertFalse(tree.contains(null));
    }
    @Test(timeout = 200, expected = IllegalArgumentException.class)
    public void testNullGet() {
        assertNull(tree.get(null));
    }

    /*
     * Basic Tree tests
     * A tree consisting of three nodes (25, 50, 75)
     */

    /**
     * Adds a basic tree of three nodes.
     * Used for the basic tests.
     */
    private void addBasicTree() {
        tree.add(50);
        tree.add(25);
        tree.add(75);
    }
    @Test(timeout = 200)
    public void testBasicAdd() throws Exception {
        addBasicTree();
        assertTrue(tree.contains(new Integer(50)));
        assertTrue(tree.contains(new Integer(25)));
        assertTrue(tree.contains(new Integer(75)));
        
        List<Integer> preOrder = tree.preOrder();
        List<Integer> inOrder = tree.inOrder();
        List<Integer> postOrder = tree.postOrder();
        List<Integer> levelOrder = tree.levelOrder();
        
        assertArrayEquals(new Integer[]{50, 25, 75}, preOrder.toArray());
        assertArrayEquals(new Integer[]{25, 50, 75}, inOrder.toArray());
        assertArrayEquals(new Integer[]{25, 75, 50}, postOrder.toArray());
        assertArrayEquals(new Integer[]{50, 25, 75}, levelOrder.toArray());
    }

    @Test(timeout = 200)
    public void testBasicAddAll() throws Exception {
        Collection<Integer> ints = new ArrayList<Integer>();
        ints.add(50);
        ints.add(25);
        ints.add(75);
        tree.addAll(ints);
        assertTrue(tree.contains(new Integer(50)));
        assertTrue(tree.contains(new Integer(25)));
        assertTrue(tree.contains(new Integer(75)));
        
        List<Integer> preOrder = tree.preOrder();
        List<Integer> inOrder = tree.inOrder();
        List<Integer> postOrder = tree.postOrder();
        List<Integer> levelOrder = tree.levelOrder();
        
        assertArrayEquals(new Integer[]{50, 25, 75}, preOrder.toArray());
        assertArrayEquals(new Integer[]{25, 50, 75}, inOrder.toArray());
        assertArrayEquals(new Integer[]{25, 75, 50}, postOrder.toArray());
        assertArrayEquals(new Integer[]{50, 25, 75}, levelOrder.toArray());
        
    }

    @Test(timeout = 200)
    public void testBasicRemove() throws Exception {
        addBasicTree();
        
        assertEquals(new Integer(50), tree.remove(50));
        
        assertFalse(tree.contains(new Integer(50)));
        assertTrue(tree.contains(new Integer(25)));
        assertTrue(tree.contains(new Integer(75)));
        
        List<Integer> preOrder = tree.preOrder();
        List<Integer> inOrder = tree.inOrder();
        List<Integer> postOrder = tree.postOrder();
        List<Integer> levelOrder = tree.levelOrder();
        
        
        assertArrayEquals(new Integer[]{75, 25}, preOrder.toArray());
        assertArrayEquals(new Integer[]{25, 75}, inOrder.toArray());
        assertArrayEquals(new Integer[]{25, 75}, postOrder.toArray());
        assertArrayEquals(new Integer[]{75, 25}, levelOrder.toArray());
        
        assertEquals(new Integer(75), tree.remove(75));

        assertTrue(tree.contains(new Integer(25)));
        assertFalse(tree.contains(new Integer(75)));
        
        preOrder = tree.preOrder();
        inOrder = tree.inOrder();
        postOrder = tree.postOrder();
        levelOrder = tree.levelOrder();
        
        assertArrayEquals(new Integer[]{25}, preOrder.toArray());
        assertArrayEquals(new Integer[]{25}, inOrder.toArray());
        assertArrayEquals(new Integer[]{25}, postOrder.toArray());
        assertArrayEquals(new Integer[]{25}, levelOrder.toArray());

        assertEquals(new Integer(25), tree.remove(25));
        assertTrue(tree.isEmpty());        
    }

    @Test(timeout = 200)
    public void testBasicContains() throws Exception {
        addBasicTree();
        assertTrue(tree.contains(50));
        assertTrue(tree.contains(25));
        assertTrue(tree.contains(75));
        assertFalse(tree.contains(12));
        assertFalse(tree.contains(99));
    }

    @Test(timeout = 200)
    public void testBasicGet() throws Exception {
        addBasicTree();
        assertEquals(new Integer(50), tree.get(50));
        assertEquals(new Integer(25), tree.get(25));
        assertEquals(new Integer(75), tree.get(75));
        assertNull(tree.get(21));
        assertNull(tree.get(99));
    }

    @Test(timeout = 200)
    public void testBasicPreOrder() throws Exception {
        addBasicTree();
        List<Integer> preOrder = new ArrayList<Integer>();
        preOrder.add(50);
        preOrder.add(25);
        preOrder.add(75);
        assertEquals(preOrder, tree.preOrder());
    }

    @Test(timeout = 200)
    public void testBasicInOrder() throws Exception {
        addBasicTree();
        List<Integer> inOrder = new ArrayList<Integer>();
        inOrder.add(25);
        inOrder.add(50);
        inOrder.add(75);
        assertEquals(inOrder, tree.inOrder());
    }

    @Test(timeout = 200)
    public void testBasicPostOrder() throws Exception {
        addBasicTree();
        List<Integer> postOrder = new ArrayList<Integer>();
        postOrder.add(25);
        postOrder.add(75);
        postOrder.add(50);
        assertEquals(postOrder, tree.postOrder());
    }

    @Test(timeout = 200)
    public void testBasicLevelOrder() throws Exception {
        addBasicTree();
        List<Integer> levelOrder = new ArrayList<Integer>();
        levelOrder.add(50);
        levelOrder.add(25);
        levelOrder.add(75);
        assertEquals(levelOrder, tree.levelOrder());
    }
    
    @Test(timeout = 200)
    public void testBasicIsEmpty() throws Exception {
        assertTrue(tree.isEmpty());
        addBasicTree();
        assertFalse(tree.isEmpty());
    }

    @Test(timeout = 200)
    public void testBasicSize() throws Exception {
        assertEquals(0, tree.size());
        addBasicTree();
        assertEquals(3, tree.size());
    }

    @Test(timeout = 200)
    public void testBasicClear() throws Exception {
        assertTrue(tree.isEmpty());
        testBasicAdd();
        assertFalse(tree.isEmpty());
        tree.clear();
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        assertNull(tree.get(50));
    }

    /*
     * Empty tree tests
     * Make sure the tree works when
     * there is no data inside it.
     */

    @Test(timeout = 200)
    public void testEmptyRemove() throws Exception {
        assertNull(tree.remove(50));
        assertNull(tree.remove(25));
        assertNull(tree.remove(75));
    }

    @Test(timeout = 200)
    public void testEmptyContains() throws Exception {
        assertFalse(tree.contains(50));
        assertFalse(tree.contains(25));
        assertFalse(tree.contains(75));
        assertFalse(tree.contains(12));
        assertFalse(tree.contains(99));
    }

    @Test(timeout = 200)
    public void testEmptyGet() throws Exception {
        assertNull(tree.get(50));
        assertNull(tree.get(25));
        assertNull(tree.get(75));
        assertNull(tree.get(21));
        assertNull(tree.get(99));
    }

    @Test(timeout = 200)
    public void testEmptyPreOrder() throws Exception {
        List<Integer> preOrder = new ArrayList<Integer>();
        assertEquals(preOrder, tree.preOrder());
    }

    @Test(timeout = 200)
    public void testEmptyInOrder() throws Exception {
        List<Integer> inOrder = new ArrayList<Integer>();
        assertEquals(inOrder, tree.inOrder());
    }

    @Test(timeout = 200)
    public void testEmptyPostOrder() throws Exception {
        List<Integer> postOrder = new ArrayList<Integer>();
        assertEquals(postOrder, tree.postOrder());
    }

    @Test(timeout = 200)
    public void testEmptyLevelOrder() throws Exception {
        List<Integer> postOrder = new ArrayList<Integer>();
        assertEquals(postOrder, tree.levelOrder());
    }

    
    @Test(timeout = 200)
    public void testEmptyIsEmpty() throws Exception {
        assertTrue(tree.isEmpty());
    }

    @Test(timeout = 200)
    public void testEmptySize() throws Exception {
        assertEquals(0, tree.size());
    }

    @Test(timeout = 200)
    public void testEmptyClear() throws Exception {
        assertTrue(tree.isEmpty());
    	tree.clear();
    	assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());
        assertNull(tree.get(50));
    }

    @Test(timeout = 200)
    public void testToString() throws Exception {
        assertEquals(tree.toString(), "()");
        tree.add(25);
        tree.add(12);
        assertEquals(tree.toString(), "(25(12()())())");
        tree.add(37);
        tree.add(38);
        assertEquals(tree.toString(), "(25(12()())(37()(38()())))");
    }

}
