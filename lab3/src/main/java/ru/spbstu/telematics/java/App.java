package ru.spbstu.telematics.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;



class Compute extends Thread
{

    private static ArrayList<ArrayList<Double>> matrix;
    private static ArrayList<ArrayList<Double>> result;
    int r;
    int c;
    Compute(ArrayList<ArrayList<Double>> matrix, ArrayList<ArrayList<Double>> result,int r){
        this.matrix=matrix;
        this.result = result;
        this.r = r;
    }
    @Override

    public void run()
    {
        ArrayList<Double> temp = new ArrayList<Double>();
        for (int j = 0; j < matrix.size(); j++) {
            temp.add(computeElement(r,j,matrix));
        }
        result.set(r,temp);
    }

    Double computeElement(int r, int c, ArrayList<ArrayList<Double>> matrix){
        Double sum=0d;

        if(r!=0&&c!=0) {
            sum = sum + matrix.get(r - 1).get(c-1);
        }
        if(r!=matrix.size()-1&&c!=0) {
            sum = sum + matrix.get(r).get(c-1);
        }
        if(r!=matrix.size()-1) {
            sum = sum + matrix.get(r).get(c);
        }
        if(r!=matrix.size()-1&&c!=matrix.size()-1) {
            sum = sum + matrix.get(r).get(c);
        }
        if(c!=matrix.size()-1) {
            sum = sum + matrix.get(r).get(c+1);
        }
        if(r!=0&&c!=matrix.size()-1) {
            sum = sum + matrix.get(r - 1).get(c+1);
        }
        if(r!=0) {
            sum = sum + matrix.get(r - 1).get(c);
        }
        if(c!=0) {
            sum = sum + matrix.get(r).get(c-1);
        }

        System.out.println(sum);
        return sum;
    }


}


class Foo{

    private ArrayList<ArrayList<Double>> matrix = new ArrayList<ArrayList<Double>>();
    private ArrayList<ArrayList<Double>> result = new ArrayList<ArrayList<Double>>();
    ArrayList<Compute> threads;

    public Foo(int a){
        Random r = new Random();
        r.nextDouble();
        for(int i=0;i<a;i++) {
            ArrayList<Double> temp = new ArrayList<Double>(); // added ()
            ArrayList<Double> temp2 = new ArrayList<Double>(); // added ()
            for (int j = 0; j < a; j++) {
                temp.add(r.nextDouble());
                temp2.add(0d);
            }
            matrix.add(temp);
            result.add(temp2);        }
    }


    public Foo(ArrayList<ArrayList<Double>> matrix){
        this.matrix=matrix;
        int a = matrix.size();
        Random r = new Random();
        r.nextDouble();
        for(int i=0;i<a;i++) {
            ArrayList<Double> temp2 = new ArrayList<Double>(); // added ()
            for (int j = 0; j < a; j++) {
                temp2.add(0d);
            }
            result.add(temp2);
        }
    }


    ArrayList<ArrayList<Double>> getResult(){
        return result;
    }
    public void start(){
        threads=new ArrayList<Compute>();
        for(int i=0;i<matrix.size();i++){
            threads.add(new Compute(matrix,result,i));	//Создание потока

            threads.get(i).start();
            try{
                threads.get(i).join();
            }catch(InterruptedException e){
                System.out.println("ERROR");
            }//Запуск потока
        }

    }
}


public class App
{
    public static void main(String[] args){


    }

}
