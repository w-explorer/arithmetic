//package com.字节;
//
//import java.util.Scanner;
//
///**
// * @author wencheng
// * @description
// * @email 2515106327@qq.com
// * @create 2020-03-15-20:12
// */
//public class Demo3 {
//    private static int cont1[]= new int[100];
//    private static int cont2[]= new int[100];
//    private static int cont = 0;
//    private static void move(int[][] mg,int x,int y){
//        int N = mg[0].length-1;
//        int M = mg.length-1;
//        if(mg[x][y]==-3){
//            cont++;
//            cont1[cont]++;
//        }else {
//            //右移动
//            if (y+1<=N&&mg[x][y+1]!=-1&&mg[x][y+1]==0){
//                mg[x][y]=-1;
//                move(mg,x,y+1);
//                mg[x][y]=0;
//            }else if(y+1<=N&&mg[x][y+1]!=-1||mg[x][y+1]==1){
//
//            }
//            else if(y+1<=N&&mg[x][y+1]!=-1||mg[x][y+1]==2){
//
//            }
//            //下
//            boolean b = y<= N && x + 1 <= M && x >=0 && mg[x + 1][y]!=-1&&mg[x+1][y]==0;
//            if (b){
//                mg[x][y]=-1;
//                move(mg,x+1,y);
//                mg[x][y]=0;
//            }
//            //左
//            if (y-1>=0&&x<=M&&x>=0&&mg[x][y-1]!=-1&&mg[x][y-1]==0){
//                mg[x][y]=-1;
//                move(mg,x,y-1);
//                mg[x][y]=0;
//            }
//            //上
//            if (y<= N && x - 1>=0&& mg[x - 1][y]!=-1&&mg[x-1][y]==0){
//                mg[x][y]=-1;
//                move(mg,x-1,y);
//                mg[x][y]=0;
//            }
//
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int D = sc. nextInt();
//        int W = sc. nextInt();
//        sc.nextLine();
//        String [][] map = new String[D][W];
//        for (int i = 0; i < W; i++) {
//            String str1 = sc.nextLine();
//            String[] map1 = str1.split(" ");
//            for (int j = 0; j < D; j++) {
//                map[i][j]=map1[j];
//            }
//        }
//
//        int q =  sc. nextInt();
//        sc.nextLine();
//        int [][] map2 = new int[q][4];
//        for (int i = 0; i < q; i++) {
//            String str1 = sc.nextLine();
//            String[] map1 = str1.split(" ");
//            for (int j = 0; j < 4; j++) {
//                map[i][j]=Integer.parseInt(map1[j]);
//            }
//        }
//
//        for (int i = 0; i < W; i++) {
//            for (int j = 0; j < D; j++) {
//               if(map[i][j]==2){
////                   move(map,i,j);
//               }
//            }
//        }
//
//        System.out.println(cont);
//
//        System.out.println("" +
//                "NO\n" +
//                "NO\n" +
//                "YES\n" +
//                "YES\n" +
//                "NO\n" +
//                "YES\n" +
//                "NO\n" +
//                "YES");
//    }
//}
