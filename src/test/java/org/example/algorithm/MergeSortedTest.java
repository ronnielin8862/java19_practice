package org.example.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortedTest {

    @Test
    public void test(){
        int i = 0;
        while (i< 5){
            System.out.println(i++);
        }
    }

    @Test
    public void case1(){
        int[] num1 = {1,2,3,0,0,0};
        int m = 3;
        int[] num2 = {2,5,6};
        int n = 3;
        MergeSorted mergeSorted = new MergeSorted();
        mergeSorted.merge(num1,m,num2,n);
    }

    @Test
    public void case2(){
        int[] num1 = {1};
        int m = 1;
        int[] num2 = {};
        int n = 0;
        MergeSorted mergeSorted = new MergeSorted();
        mergeSorted.merge(num1,m,num2,n);
    }

    @Test
    public void case3(){
        int[] num1 = {0};
        int m = 0;
        int[] num2 = {1};
        int n = 1;
        MergeSorted mergeSorted = new MergeSorted();
        mergeSorted.merge(num1,m,num2,n);
    }

}