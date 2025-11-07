package com.code.may;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args){
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double ans = findMedianSortedArrays(nums1,nums2);
        System.out.println(ans);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] merge = new double[nums1.length+nums2.length];
        int index =0;
//        mergeArray(nums1,merge,index);
//        mergeArray(nums2,merge,index);
        for(int i=0;i<nums1.length;i++){
            merge[index++] = nums1[i];
        }
        for(int i=0;i<nums2.length;i++){
            merge[index++] = nums2[i];
        }
        System.out.println("before sort--");
        for(double num : merge){
            System.out.print(num+" ");
        }
        System.out.println();
        System.out.println("after sort");
        Arrays.sort(merge);
        for(double num : merge){
            System.out.print(num+" ");
        }
        System.out.println();
        if(merge.length%2!=0){
            System.out.println("odd");
            return (merge[merge.length/2]);
        }else{
            int mid =  merge.length / 2;
            System.out.println("even");
            return ((merge[mid]+merge[(mid-1)])/2);
        }

    }

//    private static int[] mergeArray(int[] nums1,int[] nums2, int[] merge, int index){
//        for(int i=0;i<nums.length;i++){
//            merge[index++] = nums[i];
//        }
//        return merge;
//    }
}
