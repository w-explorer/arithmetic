//import java.util.Scanner;
//
///**
// * @author wencheng
// * @description
// * @email 2515106327@qq.com
// * @create 2020-03-12-19:07
// */
//public class Main {
//    private static int cont=0;
//    private static void move(char[][] mg,int x,int y){
//        int N = mg[0].length-1;
//        int M = mg.length-1;
//        if(x==1&&y==N){
//            cont++;
//        }else {
//            //右移动
//            if (y<N&&mg[x][y+1]!='X'){
//                mg[x][y]='X';
//                move(mg,x,y+1);
//                mg[x][y]='.';
//            }
//            //右上
//            if (y<N&&x<=M&&x>0&&mg[x-1][y+1]!='X'){
//                mg[x][y]='X';
//                move(mg,x-1,y+1);
//                mg[x][y]='.';
//            }
//            //右下
//            if (y<=N&&x<=M&&x>0&&mg[x+1][y+1]!='X'){
//                mg[x][y]='X';
//                move(mg,x+1,y-1);
//                mg[x][y]='.';
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String n = sc.nextLine();
//        int N = Integer.parseInt(n);
//        char map[][] = new char[2][N];
//        int intMap[][] = new int[2][N];
//
//        String str1 = sc.nextLine();
//        char[] chars1 = str1.toCharArray();
//
//        String str2 = sc.nextLine();
//        char[] chars2 = str2.toCharArray();
//        for (int i = 0; i < N; i++) {
//            map[0][i] = chars1[i];
//        }
//        for (int i = 0; i < N; i++) {
//            map[1][i] = chars2[i];
//        }
//        move(map,0,0);
//        System.out.println(cont);
//
//    }
//}