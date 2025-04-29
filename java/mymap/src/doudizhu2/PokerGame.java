package doudizhu2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {

    // 牌盒Map

    // 此时只需要吧牌和序号产生对应关系就可以了
    static HashMap<Integer, String> hm = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<Integer>();


    static {
        // 准备牌
        // "♠", "♣", "♥", "♦"
        // "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"
        String[] color = {"♠", "♣", "♥", "♦"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //细节
        int serialNumer = 1;
        for (String n : number) {
            for (String c : color) {
                hm.put(serialNumer, c + n);
                list.add(serialNumer);
                serialNumer++;
            }
        }

        hm.put(serialNumer, "小王");
        list.add(serialNumer);
        serialNumer++;
        hm.put(serialNumer, "大王");
        list.add(serialNumer);

        System.out.println(hm);
    }

    public PokerGame() {
        // 洗牌
        Collections.shuffle(list);

        //发牌
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            int serialNumber = list.get(i);

            if (i <= 2){
                lord.add(serialNumber);
                continue;
            }

            if (i % 3 == 0){
                player1.add(serialNumber);
            }else if (i % 3 == 1){
                player2.add(serialNumber);
            }else{
                player3.add(serialNumber);
            }
        }
//        System.out.println(lord);
//        System.out.println(player1);
//        System.out.println(player2);
//        System.out.println(player3);

        // 看牌
        lookPoker("底牌",lord);
        lookPoker("刚脑阔",player1);
        lookPoker("大帅比",player2);
        lookPoker("蛋筒",player3);
    }
    public void lookPoker(String name,TreeSet<Integer> ts){
        System.out.print(name + "：");
        for (int serialNumber : ts) {
            String poker = hm.get(serialNumber);
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
