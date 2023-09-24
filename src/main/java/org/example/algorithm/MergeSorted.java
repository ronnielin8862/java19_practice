package org.example.algorithm;

import java.util.Map;
import java.util.TreeMap;

public class MergeSorted {

    public void merge(int[] nums1, int m, int[] nums2, int n){
//        solve1(nums1, m, nums2, n);
        solve2(nums1, m, nums2, n);
    }

    private void solve1(int[] nums1, int m, int[] nums2, int n){
        if (m == 0){
            nums1 = nums2;
            m = n;
        }else if (n != 0){
            for (int num2:nums2){
                for (int j = 0; j<= nums1.length;j ++){
                    if (nums1[j] == 0 ){
                        nums1[j] = num2;
                        break;
                    }

                    if (num2 <= nums1[j]){
                        for (int i = nums1.length-1; i >= j; i--){
                            nums1[i] = nums1[i-1];
                        }
                        nums1[j] = num2;
                        break;
                    }
                }
            }
        }
        System.out.println("nums1 length = " + nums1.length);
        for (int num:nums1) {
            System.out.println(num);
        }
    }

    private void solve2(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
