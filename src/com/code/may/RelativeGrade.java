package com.code.may;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeGrade {
    public static void main(String[] args){
        int[] score = {10,3,8,9,4}; //1 5 3 2 4
        String[] medal = findRelativeRank(score);
        for(int i=0;i<medal.length;i++){
            System.out.print(medal[i]+" ");
        }
     //   System.out.println(findRelativeRanks(score));
    }

    public static String[] findRelativeRank(int[] score) {
        String[] medal = new String[score.length];
        String[] list = {"Gold Medal","Silver Medal","Bronze Medal"};
        Map<Integer,String> map = new HashMap<>();

        int[] orgScore = new int[score.length];
        for(int i=0;i<score.length;i++)
            orgScore[i] = score[i];
        Arrays.sort(orgScore);
        int index=1;
        for(int i=orgScore.length-1;i>=0;i--){
            if(index<= list.length){
                map.put(orgScore[i],list[index-1]);
                index++;
            }else {
                map.put(orgScore[i], String.valueOf(index));
                index++;
            }
        }
        for(int i=0;i<score.length;i++){
            medal[i] = map.get(score[i]);
        }
        return medal;
    }

}
