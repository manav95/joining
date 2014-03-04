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
 * Level Order tests for
 * CS 1332 Homework 05
 *
 * @author Kevin Simon
 */
public class LevelOrderTests {
    private static final int TIMEOUT = 300;
    private BSTInterface<Integer> tree;

    @Before
    public void setUp() throws Exception {
        tree = new BST<Integer>();
    }

    @Test(timeout = TIMEOUT)
    public void rightHeavyLevelOrder() throws Exception {
    	tree.add(50);
    	tree.add(30);
    	tree.add(90);
    	tree.add(89);
    	tree.add(40);
    	tree.add(41);
    	tree.add(42);
    	tree.add(43);
    	tree.add(44);

    	assertArrayEquals(new Integer[] {50, 30, 90, 40, 89, 41, 42, 43, 44}, tree.levelOrder().toArray());
    }

    @Test(timeout = TIMEOUT)
    public void generalLevelOrder() throws Exception {
        tree.add(10);
        tree.add(9);
        tree.add(11);
        tree.add(8);
        tree.add(12);
        tree.add(7);
        tree.add(13);
        tree.add(14);
        tree.add(6);
        tree.add(15);
        tree.add(5);

        assertArrayEquals(new Integer[] {10, 9, 11, 8, 12, 7, 13, 6, 14, 5, 15}, tree.levelOrder().toArray());
    }

    @Test(timeout = TIMEOUT)
    public void fullLevelOrder() throws Exception {
        tree.add(10);
        tree.add(8);
        tree.add(12);
        tree.add(13);
        tree.add(11);
        tree.add(6);
        tree.add(9);

        assertArrayEquals(new Integer[] {10, 8, 12, 6, 9, 11, 13}, tree.levelOrder().toArray());
    }

    @Test(timeout = TIMEOUT)
    public void sizeEmptyCase() {
        assertArrayEquals(new Integer[] {}, tree.levelOrder().toArray());
    }

    @Test(timeout = TIMEOUT)
    public void sizeOneCase() {
        tree.add(0);
        assertArrayEquals(new Integer[] {0}, tree.levelOrder().toArray());
    }

    @Test(timeout = TIMEOUT)
    public void sizeTwoCase() {
        tree.add(0);
        tree.add(1);
        assertArrayEquals(new Integer[] {0, 1}, tree.levelOrder().toArray());
        tree.clear();
        tree.add(0);
        tree.add(-1);
        assertArrayEquals(new Integer[] {0, -1}, tree.levelOrder().toArray());
    }

    @Test(timeout = TIMEOUT)
    public void sizeThreeCase() {
        tree.add(0);
        tree.add(1);
        tree.add(-1);
        assertArrayEquals(new Integer[] {0, -1, 1}, tree.levelOrder()
                .toArray());
        tree.clear();
        tree.add(0);
        tree.add(-1);
        tree.add(1);
        assertArrayEquals(new Integer[] {0, -1, 1}, tree.levelOrder()
                .toArray());
        tree.clear();
        tree.add(-1);
        tree.add(0);
        tree.add(1);
        assertArrayEquals(new Integer[] {-1, 0, 1}, tree.levelOrder()
                .toArray());
        tree.clear();
        tree.add(-1);
        tree.add(1);
        tree.add(0);
        assertArrayEquals(new Integer[] {-1, 1, 0}, tree.levelOrder()
                .toArray());
        tree.clear();
        tree.add(1);
        tree.add(0);
        tree.add(-1);
        assertArrayEquals(new Integer[] {1, 0, -1}, tree.levelOrder()
                .toArray());
        tree.clear();
        tree.add(1);
        tree.add(-1);
        tree.add(0);
        assertArrayEquals(new Integer[] {1, -1, 0}, tree.levelOrder()
                .toArray());
    }

    @Test(timeout = TIMEOUT)
    public void zigZagCase() {
        tree.add(9);
        tree.add(0);
        tree.add(8);
        tree.add(1);
        tree.add(7);
        tree.add(2);
        tree.add(6);
        tree.add(3);
        tree.add(5);
        tree.add(4);

        assertArrayEquals(new Integer[] {9, 0, 8, 1, 7, 2, 6, 3, 5, 4}, tree
                .levelOrder().toArray());
    }
}