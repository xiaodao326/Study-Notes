package com.xiaodao;

public class TestPerson {
    public static void main(String[] args) {
        Train1_4_Person p = new Train1_4_Person("张三", 30, "父亲");
        p.growUp();
        p.changeName("李四");
        p.changeFamilyStatus("爷爷");
        p.addChild("小李");
        p.printInfo();
    }
}
