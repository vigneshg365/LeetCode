package com.code.may;

import java.util.Arrays;

public class MaximumHappiness {
    public static void main(String[] args){
        int[] happiness = {12,1,42};
        int k=3;
        System.out.println(maximumHappinessSumOptimize(happiness,k));
    }
    public static long maximumHappinessSum(int[] happiness, int k) {
        long sum=0;
        while(k>0){
            int maxIndex = 0 ;
            for(int i=0;i<happiness.length;i++){
                if(happiness[i]>happiness[maxIndex])
                    maxIndex =i;
            }
            sum+=happiness[maxIndex];
            happiness[maxIndex] = 0;
            for(int i=0;i<happiness.length;i++){
                if(happiness[i]!=happiness[maxIndex]){
                    happiness[i] = happiness[i]-1 >0 ? happiness[i]-1 : 0;
                }
            }
            k--;
        }
        return sum;
    }

    public static long maximumHappinessSumOptimize(int[] happiness, int k) {
        long sum=0;
        Arrays.sort(happiness);
        int len = happiness.length-1,j=0;
        for(int i=len;i>len-k;i--){
            int hap = happiness[i]-(j++);
            sum+= hap >0 ? hap : 0;
        }
     return sum;
    }

}
