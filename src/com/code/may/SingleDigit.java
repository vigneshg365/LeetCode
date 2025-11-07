package com.code.may;

public class SingleDigit {
    public static void main(String[] args){
        int n = 5665;
        System.out.println(singleDigit(n));
    }
    static int singleDigit(int n) {

        long sum=n;
        while(sum>9){
           String binary = binaryConvert(sum);
            sum = sumBinary(binary);
        }
        return (int)sum;
        //your code here
    }

    private static long sumBinary(String n) {
        int sum=0;
//        while(n>0) {
//            long rem = n % 10;
//            sum += rem;
//            n /= 10;
//        }
        for(int i=0;i<n.length();i++){
            sum+=Integer.parseInt(String.valueOf(n.charAt(i)));
        }

        return sum;
    }

    static String binaryConvert(long n){
        StringBuilder sbr = new StringBuilder();
        while(n>0){
            long rem = n%2;
            sbr.insert(0,rem);
            n/=2;
        }

       // return Long.parseLong(sbr.toString());
        return sbr.toString();
    }
}
