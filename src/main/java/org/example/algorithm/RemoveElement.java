package org.example.algorithm;

public class RemoveElement {

    public void removeElement(int[] nums, int val) {
//        removeElement1(nums, val);
        removeElement2(nums, val);

    }
    public int removeElement1(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length ==1 ){
            if (nums[0] == val){
                return 0;
            }else {
                return 1;
            }
        }
        int i = 0;
        int j = nums.length -1;

        while (i < nums.length){
            if (nums[i] == val){
                nums[i] = nums[j--];
                if (j<=0 || i == j){
                    break;
                }
                continue;
            }
            i++;
            if (j<=0 || i == j){
                break;
            }
        }
        if (nums[i]==val){
            i--;
        }
        int k = i +1;
        int[] nums2 = new int[k];
        for (int q = 0; q<k; q++){
            nums2[q] = nums[q];
        }

        if (nums2.length>0 && nums2[0] == val){
            return 0;
        }

        System.out.println("k =" + k);
        for (int num:nums2){
            System.out.println(num);
        }
        return nums2.length;
    }

    public int removeElement2(int[] nums, int val){
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        System.out.println("i =" + i);
        for (int num:nums){
            System.out.println(num);
        }
        return i;
    }

}
