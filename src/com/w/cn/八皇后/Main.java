package com.w.cn.八皇后;

import java.util.StringTokenizer;

/**
 *古老著名的问题，是回溯算法的典型案例。
 * 该问题是国际西洋棋马格斯。备塞于1848年提出：
 * 在8*8个格的国际象棋上摆放八个皇后，使其不能互相攻击
 * 任意两个皇后不能处于同一行、同一列或同一斜线上，问有多少中摆法？【92中】
 *
 * 回溯
 *
 * 图论得出 92种
 */
public class Main {

    public static void main(String[] args) {

        String [][]s={{"helloworld","hello world"},{"this is","a java program"}};

        System.out.println((new StringTokenizer(s[1][1])).countTokens()>2);

    }
}
