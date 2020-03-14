package com.w.cn.递归;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-14-16:56
 *
 * (1,1)  到  （6,5）
 * 共有多少条路径
 */
public class MiGong1 {
    public static void main(String[] args) {
        //先创建二维数据，模拟迷宫
        //地图
        int [][] map = new int[8][7];
        //使用1 为墙  0为可变化
        //上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        //左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][0]=1;
        map[3][1]=1;
        map[3][2]=1;
        map[2][2]=1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        setWey(map,1,1);
        System.out.println("走迷宫之后");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 如果能到map[6,5]终点返回 true  否则  返回false
     * 约定：当map[i][j]为0  表示该点没有走过，1 为墙；2 表示 通路可以走，3表示走过  为死路。
     * 在走迷宫时，需要确定一个策略，怎么走。下-右-上-左,如果该点走不通就回溯。
     * @param map 地图有
     * @param i 出发点
     * @param j
     * @return
     */
    public static boolean setWey(int[][] map,int i,int j){
        if(map[6][5]==2){//通路已经找到
            return true;
        }else {
            if(map[i][j]==0){ //如果当前这个点没有走过
                //按照策略走一遍 下-右-上-左,如果该点走不通就回溯。
                map[i][j] = 2;//假定该点时可以走通的
                if(setWey(map,i+1,j)){//下
                    return true;
                }else if(setWey(map, i, j+1)){//右
                    return true;
                }else if(setWey(map, i-1, j)){//上
                    return true;
                }else if(setWey(map,i,j-1)){//左
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }
            else {
                return false;
            }
        }
    }
}
