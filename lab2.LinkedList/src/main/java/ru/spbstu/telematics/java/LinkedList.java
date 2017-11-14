package ru.spbstu.telematics.java;


import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedList<T> implements Iterable<T> {
    Node<T> root=null;
    int size;
    LinkedList<T> thisList=this;

    void setRoot(Node<T> root){
        this.root=root;
    }


    public class Node<T>{
        T data;

        Node<T> next;
        Node<T> back;
        Node(T data){
            this.data=data;
            next=null;
            back=null;
        }
        void setNext(Node<T> next){
            this.next=next;
        }
        void setback(Node<T> back){
            this.back=back;
        }
    }

    public class ListIterator<T> implements java.util.ListIterator<T>{

        private Node<T> current;
        private int index;


        ListIterator(){
            int a =size;
            current = new Node<T>(null);
            current.next= (Node<T>) root;
            current.next.back = current;
            //current = (Node<T>)root;
            index=0;
        }

        public boolean hasNext() {
            if(current.next==null){
                return false;
            }
            else {
                return true;
            }
        }

        public boolean hasPrevious() {
            if(current.back==null){
                return false;
            }
            else {
                return true;
            }
        }

        public T next() throws NoSuchElementException {
            if(hasNext()==false){
                throw new NoSuchElementException();
            }
            current=current.next;
            index++;
            return current.data;
        }

        public T previous() throws NoSuchElementException {
            if(hasPrevious()==false){
                throw new NoSuchElementException();
            }
            index--;
            T data=current.data;
            current=current.back;
            return data;
        }


        public void remove() {
            if(hasPrevious()) {
                current.back.next = current.next;
            }
            if(hasNext()) {
                current.next.back = current.back;
            }
            size--;
            if(current==root){
                thisList.root=thisList.root.next;
            }
            if(index!=0){
                index--;
            }
            //current=current.back;
        }

        public int nextIndex(){
            return index+1;
        }
        public int previousIndex(){
            return index-1;
        }

        public void set(T obj){
            current.data=obj;
        }

        public void add(T obj){
            Node<T> newNode = new Node(obj);
            newNode.next = current.next;
            if(hasNext()) {
                current.next.back = newNode;
            }
            current.next = newNode;
            current=current.next;
            size++;
        }



    }

    public Iterator<T> iterator(){
        return new ListIterator<T>();
    }

    public Node<T> getRoot() {
        return root;
    }


    public int getSize() {
        return size;
    }

    LinkedList(){
        size=0;
        root=null;
    }


    Node<T> goToLast(){
        if(size==1){
            return root;
        }
        Node<T> temp=root;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }


    boolean add(T data){
        if(size==0){
            root = new Node<T>(data);
            size++;
            return true;
        }
        Node<T> temp = goToLast();
        temp.next = new Node<T>(data);
        temp.next.back = temp;
        size++;
        return true;
    }

    boolean add(int index, T data) throws NoSuchElementException{
        if(index>size){
            throw new NoSuchElementException();
        }
        index--;
        Node<T> temp = root;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        Node<T> newNode = new Node<T>(data);
        temp.next.back=newNode;
        newNode.next = temp.next;
        newNode.back=temp;
        temp.next  = newNode;
        size++;
        return true;
    }

    T get(int index){
        Node<T> temp = root;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.data;
    }

    void remove(int index){
        if(index>size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> temp = root;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        temp.next.back=temp;
    }

    boolean contains(T data){
        Node<T> temp=root;
        while(temp.next!=null){
            if(temp.data==data){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }




}










 class Main {

    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<>();
    }


}
