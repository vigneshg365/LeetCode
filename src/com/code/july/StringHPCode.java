package com.code.july;

import java.util.*;

public class StringHPCode {

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        longestSubstringWithoutDuplicates(str);
    }

    private static void longestSubstringWithoutDuplicates(String str) {

        Set<String> set = new HashSet<>();
        int len = str.length();
       for(int i=0;i<len;i++){
          set.add(removeDuplicates(str.substring(i)));
       }
        System.out.println(set);
        long max = set.stream().max(Comparator.comparingInt(String::length)).get().length();
        set.stream().filter(word->word.length()==max).forEach(System.out::println);
    }

    private static String removeDuplicates(String substring) {
        String str = "";
        for(char ch : substring.toCharArray()){
            if(str.contains(String.valueOf(ch))){
                break;
            }else{
                str+=(String.valueOf(ch));
            }
        }

        return str;
    }
}
