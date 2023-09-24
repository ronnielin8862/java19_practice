package org.example.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveElementTest {
    @Test
    public void case1(){
        int[] nums = {3,2,2,3};
        int val = 3;
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(nums,val);
    }

    @Test
    public void case2(){
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(nums,val);
    }

    @Test
    public void case3(){
        int[] nums = {1};
        int val = 1;
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(nums,val);
    }

    @Test
    public void case4(){
        int[] nums = {2};
        int val = 3;
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(nums,val);
    }

    @Test
    public void case5(){
        int[] nums = {4,5};
        int val = 5;
        RemoveElement removeElement = new RemoveElement();
        removeElement.removeElement(nums,val);
    }

}