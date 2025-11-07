package com.code.may;

public class CountSplChars {
    public static void main(String[] args) {
        String word = "EAdEecD";
        System.out.println(numberOfSpecialChars(word));
    }

    public static int numberOfSpecialChars(String word) {
        String ans = "";
        int count=0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)>='a' && word.charAt(i)<='z'){
                String upperCase = String.valueOf(word.charAt(i)).toUpperCase();
                if(word.contains(upperCase) && (i < word.indexOf(upperCase))) {
                    count++;
                    ans += ans.contains(String.valueOf(word.charAt(i))) ? "" : word.charAt(i);
                }
                if(i>word.indexOf(upperCase)&& word.contains(upperCase)){
                    count--;
                    ans="";
                }


            }
        }


        return count;
    }
}
