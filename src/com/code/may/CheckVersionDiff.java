package com.code.may;

public class CheckVersionDiff {


    public static void main(String[] args){
        String version1 = "1.0";
        String version2 ="1.0.0";
//         version1 = "1.01";
//         version2 ="1.001";
        version1 = "1.0.1";
        version2 = "1";
        version1="0.1";
        version2 ="0.0.1";
        System.out.println(compareVersionWorking(version1,version2));
    }

    private static int compareVersionWorking(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i=0;i<Math.max(v1.length,v2.length);i++){
            int num1 = i<v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i<v2.length ? Integer.parseInt(v2[i]) : 0;
            if(num1<num2){
                return -1;
            }
            if(num1>num2){
                return 1;
            }
        }
        return 0;
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");

        if (v1Arr.length == 1 && v2Arr.length != 1) {
            String sum = v2Arr[0] + ".";
            for (int i = 1; i < v2Arr.length; i++) {
                sum += v2Arr[i];
            }
            return checkDiff(version1+".0", sum);

        } else if (v1Arr.length != 1 && v2Arr.length == 1) {
            String sum = v1Arr[0] + ".";
            for (int i = 1; i < v1Arr.length; i++) {
                sum += v1Arr[i];
            }
            return checkDiff(sum, version2+".0");
        }else if(v1Arr.length>1 && v2Arr.length>1){
            String sum1 = v1Arr[0]+".";
            String sum2 = v2Arr[0]+".";
            for(int i=1;i<v1Arr.length;i++)
                sum1+=v1Arr[i];
            for(int j=1;j<v2Arr.length;j++)
                sum2+=v2Arr[j];
            return checkDiff(sum1,sum2);
        }

        else if (v1Arr.length == 1 && v2Arr.length == 1)
            return checkDiff(version1+".0", version2+".0");
        else if (v1Arr.length <= 2 && v2Arr.length <= 2) {
            int v1 = Integer.parseInt(v1Arr[1]);
            v1Arr[1] = String.valueOf(v1);
            int v2 = Integer.parseInt(v2Arr[1]);
            v2Arr[1] = String.valueOf(v2);
            return checkDiff(String.join(".", v1Arr), String.join(".", v2Arr));
        } else {
            if (v1Arr.length > 2)
                version1 = v1Arr[0] + "." + v1Arr[1] + v1Arr[2];
            if (v2Arr.length > 2)
                version2 = v2Arr[0] + "." + v2Arr[1] + v2Arr[2];

            return checkDiff(version1, version2);
        }

    }

    private static int checkDiff(String version1,String version2){
        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");
        int v1b = Integer.parseInt(v1Arr[1]);
        int v2b = Integer.parseInt(v2Arr[1]);
        int v1a = Integer.parseInt(v1Arr[0]);
        int v2a = Integer.parseInt(v2Arr[0]);

        if(v1a<v2a)
            return -1;
        else if(v1a>v2a)
            return 1;
        else
            if(v1b<v2b)
                return -1;
            else if(v1b>v2b)
                return 1;
            else
                return 0;


//        if(v1a<v1b && v2a<v2b)
//            return -1;
//        else if(v1a>v1b && v2a>v1b)
//            return 1;
//        else
//            return 0;



//        float fl1 = Float.parseFloat(version1);
//        float fl2 = Float.parseFloat(version2);
//        if(fl1<fl2)
//            return -1;
//        else if(fl1>fl2)
//            return 1;
//        else
//            return 0;
    }
}
