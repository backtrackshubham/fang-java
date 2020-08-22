package edu.knoldus.coursesera.weeks.one;

import java.util.Arrays;
import java.util.Random;

public class UnionQuickFindMain {
    public static void main(String[] args) {
        UnionQuickFind obj = new UnionQuickFind(100);
        System.out.println(obj);
        obj.union(1,99);
        obj.union(99,98);
        System.out.println(obj.isConnected(1,98));
    }
}
//Eager
class UnionQuickFind{
    private int[] arr;
    private Random rand;

    @Override
    public String toString() {
        return "UnionQuickFind{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public UnionQuickFind(int n){
        this.arr = new int[n];
        this.rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = this.rand.nextInt(n + 2000);
        }
    }

    public boolean isConnected(int x, int y){
        if(x < 0 || x >= arr.length ||  y < 0 || y >= arr.length){
            throw new RuntimeException("Enter valid entries, entries must be greater then -1 and less then "+arr.length);
        }
        return arr[x] == arr[y];
    }

    public void union(int x, int y){
        if(x < 0 || x >= arr.length ||  y < 0 || y >= arr.length){
            throw new RuntimeException("Enter valid entries, entries must be greater then -1 and less then "+arr.length);
        }
        int vx = arr[x];
        int vy = arr[y];

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == vx){
                arr[i] = vy;
            }
        }
    }
}


//Lazy
class UnionQuickFindLazy{
    private int[] arr;
//    private Random rand;

    @Override
    public String toString() {
        return "UnionQuickFind{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public UnionQuickFindLazy(int n){
        this.arr = new int[n];
//        this.rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    private int root(int i){
        while (i != arr[i]) i = arr[i];
        return i;
    }

    public boolean isConnected(int x, int y){
        if(x < 0 || x >= arr.length ||  y < 0 || y >= arr.length){
            throw new RuntimeException("Enter valid entries, entries must be greater then -1 and less then "+arr.length);
        }
        return root(x) == root(y);
    }

    public void union(int x, int y){
        if(x < 0 || x >= arr.length ||  y < 0 || y >= arr.length){
            throw new RuntimeException("Enter valid entries, entries must be greater then -1 and less then "+arr.length);
        }

        arr[root(x)] = root(y);
    }
}