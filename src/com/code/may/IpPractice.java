package com.code.may;

public class IpPractice {

    public static void main(String[] args){

        String ip = "1.1.1.1";
       String ans="";
//        char[] ch = ip.toCharArray();
//        for(int i=0;i<ch.length;i++){
//            if(ch[i] == '.')
//                ans = ans+"["+ch[i]+"]";
//            else
//                ans=ans+ch[i];
//        }
//        System.out.println(ans);
        ans = ip.replaceAll("\\.","[.]");
        System.out.println(ans);
    }

}
