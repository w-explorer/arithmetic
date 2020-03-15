package com.字节;

import java.util.Scanner;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-15-19:54
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String d = sc.next();
        int D = Integer.parseInt(d);
        String w = sc.next();
        int W = Integer.parseInt(w);
        String str1 = sc.nextLine();
        str1 = sc.nextLine();
        String[] map1 = str1.split(" ");
        String str2 = sc.nextLine();
        String[] map2 = str2.split(" ");
        int countWater = W;
        int count = 0;
        for (int i = 0; i < map2.length; i++) {
            if(countWater<Integer.parseInt(map1[i])){
                count=-1;
                return;
            }else if(countWater>=D){
                break;
            }
            else {
                countWater+=Integer.parseInt(map2[i]);
                count++;
            }
        }
        System.out.println(count);
    }
}
