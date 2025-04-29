package com.xiaodao;

import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        //1.创建一个map集合
        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        //2.创建单列集合存储市
        ArrayList<String> city1 = new ArrayList<>();
        Collections.addAll(city1,"扬州市", "苏州市", "南京市", "无锡市", "常州市");
        ArrayList<String> city2 = new ArrayList<>();
        Collections.addAll(city2,"武汉市", "孝感市", "十堰市", "宜昌市", "鄂州市");
        ArrayList<String> city3 = new ArrayList<>();
        Collections.addAll(city3,"石家庄市", "唐山市", "那台市", "保定市", "张家口市");

        // 3.把省份和城市批量添加到map中
        hm.put("江苏省", city1);
        hm.put("湖北省", city2);
        hm.put("河北省", city3);

        Set<Map.Entry<String, ArrayList<String>>> entries = hm.entrySet();
        for (Map.Entry<String, ArrayList<String>> entry : entries) {
            // entry表示每个键值对对象
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            StringJoiner sj = new StringJoiner(", ");
            for (String city : value) {
                sj.add(city);
            }
//            System.out.println(sj.toString());
            System.out.println(key + " = " + sj);
        }
    }
}
