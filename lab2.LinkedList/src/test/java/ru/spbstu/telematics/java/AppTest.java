package ru.spbstu.telematics.java;

import java.util.Iterator;
import java.util.ListIterator;

import org.junit.Assert;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

    LinkedList<Integer> testList;


    public AppTest(){
        testList = new LinkedList<>();
        for(int i=0;i<=7;i++){
            testList.add(i);
        }
    }




    @org.junit.Test
    public void testadd() {
        testList.add(8);
        assertEquals("Add Fail!",new Integer(8),testList.get(8));
    }

    @org.junit.Test
    public void testAdd1() {
        testList.add(3,33);
        assertEquals("Add Fail!",new Integer(33),testList.get(3));

    }

    @org.junit.Test
    public void testGet() {
        assertEquals("Get Fail!",new Integer(1),testList.get(1));
        assertEquals("Get Fail!",new Integer(0),testList.get(0));
    }

    @org.junit.Test
    public void testRemove() {
        testList.remove(3);
        assertEquals("Get Fail!",new Integer(4),testList.get(3));
    }

    @org.junit.Test
    public void testContains() {
        assertEquals("Contains Fail!", true,testList.contains(1));
        assertEquals("Contains Fail!",true,testList.contains(0));
        assertEquals("Contains Fail!",false,testList.contains(9999));

    }

    @org.junit.Test
    public void testIterators(){
        ListIterator<Integer> iter = (ListIterator<Integer>) testList.iterator();
        assertEquals("Iterator Fail!",false,iter.hasPrevious());
        assertEquals("Iterator Fail!",true,iter.hasNext());
        assertEquals("Iterator Fail!",new Integer(0),iter.next());
        assertEquals("Iterator Fail!",new Integer(1), iter.previous());
        iter.next();
        iter.remove();
        assertEquals("IteratorRemove Fail!",new Integer(2), iter.next());
        iter.add(109);
        iter.next();
        assertEquals("Iterator Fail!",new Integer(109),iter.next());
        iter.set(9999);
        assertEquals("Iterator Fail!",new Integer(9999),iter.next());

    }
}
