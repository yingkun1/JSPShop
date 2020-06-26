package online.luffyk.util;

import online.luffyk.domain.Category;

import java.util.ArrayList;

public class Demo {
    private int sum = 0;
    public static void main(String[] args) {
        Demo demo = new Demo();
        int calculateAdd = demo.calculateAdd(10);
        System.out.println(calculateAdd);
    }

    public int calculateAdd(int num){
        for(int i = 0;i<num;i++){
            sum = sum+i;
        }
        return sum;
    }
}
