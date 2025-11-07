package com.code.may;

import java.util.Arrays;

public class BoatSavePeople {

    public static void main(String[] args){
     //   int[] people = {3,2,2,1};
      int[]  people = {3,5,3,4};
      //  int[] people = {2,4};
        int limit =5;
        int ans = numRescueBoatsSortedAnswer(people,limit);
        System.out.println(ans);
    }

    private static int numRescueBoatsSortedAnswer(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int i=0,j=people.length-1;
        while(i<=j){
            if((people[j]+people[i])<=limit){
                i++;
            }
            j--;
            count++;
        }
        return count;
    }

    private static int numRescueBoatsSorted(int[] people, int limit) {
        Arrays.sort(people);
        int count=0;
        int sum=0;
        for(int i=0;i<people.length;i++){
            if(people[i]==limit)
                count++;
            else{
                sum+=people[i];
                if(sum==limit){
                    count++;
                    sum=0;
                }
                else if((sum>limit && i== people.length-1)){
                    count++;
                    sum=0;
                }
                else if(sum>limit)
                    sum=0;
            }

        }
        return count;
    }

    private static int numRescueBoats(int[] people, int limit) {

        int count = 0;
        for (int i = 0; i < people.length; i++) {
            if (people[i] == limit || (i == people.length - 1 && people[i] != 0))
                count++;
            else if (people[i] < limit && i < people.length - 1) {
                int rem = count;
                int sum = 0;
                sum = people[i];
                for (int j = i + 1; j < people.length; j++) {
                    sum += people[j];
                    if (sum <= limit && people[j]!=0) {
                        people[j] = 0;
                        count++;
                    } else
                        sum -= people[j];
                }
                if (rem == count)
                    count++;
            }
        }


        return count;
    }
}
