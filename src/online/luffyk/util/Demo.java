package online.luffyk.util;

public class Demo {
    public static void main(String[] args) {
//        int num = 0;
//        for(int i = 3;i<1000000;i++){
//            boolean flag = true;
//            for(int j = 2;j<=Math.sqrt(i);j++){
//                if(i%j == 0){
//                    flag = false;
//                }
//            }
//            if(flag){
//                num++;
//                System.out.println(i+"是素数");
//            }
//        }
//        System.out.println(num+"个素数");
//        int a = 3;
//        int b = 2;
//        double ceil = Math.ceil((double) a / b);i
//        System.out.println(ceil);
//        int a = 42;
//        int b = 5;
//        int i = (int)((double)a / b);
//        System.out.println(i);
        int sum = 0;
        for(int i = 0;i<=100;i++){
            sum+=i;
        }
        System.out.println(sum);
    }
}
