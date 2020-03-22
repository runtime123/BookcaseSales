package com.controller.study;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: ZGQ
 * @DATA: 2020/3/21 13:31
 * @Description:
 */
public class StudyOne {
    public static void main(String[] args) {
        //getMin();
        //getsanjiaoxing();
        //getpaixu2();
        paixu();
    }

    //1、编写一个程序,从4个整数中找出最小的数,并显示此数。
    public static void getMin(){
        int a=1,b=9,c=2,d=7,min=10;
        int arr[] = {a,b,c,d};
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println(min);
    }

    //2、编程序实现用星号“*”打印一个等腰三角形
    public static void getsanjiaoxing(){
        System.out.println("你想打印的三角形行数为：");
        Scanner in = new Scanner(System.in);
        int hanshu = in.nextInt();
        for(int i=1;i<=hanshu;i++) {
            for(int j=hanshu;j>=i;j--) {
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void getpaixu(){
        int str[] = {10,9,8,7,6,5,4,3,2,1};
        Arrays.sort(str);


        for (int i = 0; i <10 ; i++) {
            System.out.println(str[i]);
        }
    }



    public static void paixu(){
        int str[] = {10,9,8,7,6,5,4,3,2,1};
        for(int j=0;j<str.length-1;j++) {
            for(int i=0;i<str.length-1-j;i++) {
                if(str[i]>str[i+1]) {
                    int temp =str[i];
                    str[i]=str[i+1];
                    str[i+1]=temp;
                }
            }
        }
        for(int i=0;i<str.length;i++) {
            System.out.print(str[i]+",");
        }

    }
}
