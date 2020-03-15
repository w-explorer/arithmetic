package com.字节;

import java.util.*;

/**
 * @author wencheng
 * @description
 * @email 2515106327@qq.com
 * @create 2020-03-15-19:03
 */
public class Demo1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int N = Integer.parseInt(n);

        //创建对象  类型  用户
        HashMap<String, String> beens = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str1 = sc.next();
            String str2 = sc.next();
            if(beens.containsKey(str2)){
                if(!beens.get(str2).contains(str1)){
                    beens.put(str2,beens.get(str2)+","+str1);
                }
            }
            else {
                beens.put(str2,str1);
            }
        }
        for (Map.Entry<String, String> map:beens.entrySet()
             ) {
            System.out.print(map.getKey()+" ");
            String[] split = map.getValue().split(",");
            List<String> list = Arrays.asList(split);
            Collections.sort(list);
            StringBuffer stringBuffer = new StringBuffer();
            list.forEach(r->{
                stringBuffer.append(r+" ");
            });
            System.out.println(stringBuffer.substring(0,stringBuffer.length()-1));
        }
    }

}
