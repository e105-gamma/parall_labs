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
    java.util.LinkedList<Integer> javaList;


    public AppTest(){
        testList = new LinkedList<>();
        javaList = new java.util.LinkedList<Integer>();
        for(int i=0;i<=7;i++){
            testList.add(i);
            javaList.add(i);
        }
    }




    @org.junit.Test
    public void testadd() {
        testList.add(8);
        javaList.add(8);
        assertEquals("Add Fail!",javaList.get(8),testList.get(8));
    }

    @org.junit.Test
    public void testAddbyIndex() {
        testList.add(3,33);
        javaList.add(3,33);

        assertEquals("Add Fail!",javaList.get(3),testList.get(3));

    }

    @org.junit.Test
    public void testGet() {
        assertEquals("Get Fail!",javaList.get(1),testList.get(1));
        assertEquals("Get Fail!",javaList.get(0),testList.get(0));
    }

    @org.junit.Test
    public void testRemove() {
        testList.remove(3);
        javaList.remove(3);
        assertEquals("Get Fail!",javaList.get(3),testList.get(3));
    }

    @org.junit.Test
    public void testContains() {
        assertEquals("Contains Fail!", javaList.contains(1),testList.contains(1));
        assertEquals("Contains Fail!",javaList.contains(0),testList.contains(0));
        assertEquals("Contains Fail!",javaList.contains(9999),testList.contains(9999)); //этих чисел заведомо нет в листе

    }

    @org.junit.Test
    public void testIterators(){
        ListIterator<Integer> testiter = (ListIterator<Integer>) testList.iterator();
        java.util.ListIterator<Integer> javaiter = (ListIterator<Integer>) javaList.iterator();

        assertEquals("IteratorHasPrevious Fail!",javaiter.hasPrevious(),testiter.hasPrevious());
        assertEquals("IteratorHasNext Fail!",javaiter.hasNext(),testiter.hasNext());
        assertEquals("IteratorNext Fail!",javaiter.next(),testiter.next());
        assertEquals("IteratorPrevious Fail!",javaiter.previous(), testiter.previous());
        javaiter.next();
        testiter.next();
        testiter.remove();
        javaiter.remove();
        assertEquals("IteratorRemove Fail!",javaiter.next(), testiter.next());
        testiter.add(109);
        testiter.next();
        javaiter.add(109);
        javaiter.next();
        assertEquals("IteratorAdd Fail!",javaiter.next(),testiter.next());
        testiter.set(9999);
        javaiter.set(9999);
        assertEquals("IteratorSet Fail!",javaiter.next(),testiter.next());


    }
}
