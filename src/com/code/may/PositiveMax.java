package com.code.may;

public class PositiveMax {
    public static void main(String[] args){
        int[] nums = {14,33,40,-33,8,-24,-42,30,-18,-34};
        System.out.println("maxElement : "+findMaxK(nums));
    }
    public static int findMaxK(int[] nums) {
        int max=0,min=-100;
        for(int i=0;i<nums.length;i++){
            if(max>nums[i] && nums[i]<0)
                max = nums[i];
            if(min<nums[i] && nums[i]<0)
                min = nums[i];
        }
        int maxElement = -1;
        for(int i=0;i<nums.length;i++){
            if(maxElement<nums[i] && nums[i]>=(min *-1) && nums[i] <=(max*-1))
                if(checkPresent(nums[i],nums))
                 maxElement = nums[i];
        }
        System.out.println("min : "+min+" \nmax : "+max);


        return maxElement;

    }

    private static boolean checkPresent(int num, int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(num==-1*nums[i])
                return true;
        }
        return false;
    }
}
