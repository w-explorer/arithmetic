package com.w.cn.稀疏数组;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-10-19:17
 *
 * 编写的五子棋程序中，有存盘退出和续上盘的功能
 * 二维数组记录很好多默认值为0的值，（没有意义的数据）-》稀疏数组  压缩存储
 *
 * 处理方法：
 * 1.记录数据共几行几列  和对应的行列的值
 *
 * 一个11* 11 的棋盘存了两个有效值
 *
 * 原始数组为：
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	1	0	0	0	0	0	0	0	0
 * 0	0	0	0	2	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 * 0	0	0	0	0	0	0	0	0	0	0
 *
 * 稀疏数组为：
 * 11	11	2
 * 1	2	1
 * 2	4	2
 *
 *  row col val
 *0 11  11  2(一共两个有效数 sum =2)
 *1 0   2   3
 *2 2   5   6
 *   n*3的二维数组  int [sum+1][3]
 *
 */
public class Sparsearray {
    public static void main(String[] args) {
        //创建一个原始的二维数组 11*11
        //0:表示没有棋子，1表示黑子  2表示蓝子
        int chessArry1[][] = new int[11][11];
        chessArry1[1][2]=1;
        chessArry1[2][4]=2;
        int cheseNum = 0;
        //输出原始二维数组
        System.out.println("原始数组为：");
        for (int[] row : chessArry1) {
            for (int data:row){
                if(data!=0){
                    cheseNum++;
                }
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //创建稀疏数组
        int sparseArr[][] = new int[cheseNum+1][3];
        int count = 0;
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=cheseNum;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArry1[i][j]!=0){
                    count++;
                    sparseArr[count][0] =i;
                    sparseArr[count][1] =j;
                    sparseArr[count][2] =chessArry1[i][j];
                }
            }
        }
        System.out.println("稀疏数组为：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        //将稀疏数组恢复为原始数组
        int cheseArry2 [][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            cheseArry2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("稀疏数组转原始数组：");
        for (int [] row:cheseArry2){
            for (int data :row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        
    }

}
