package com.xiaodao;

import java.util.ArrayList;

class Train1_4_Person {
    int age;
    String name;
    String familyStatus;
    ArrayList<String> children = new ArrayList<>();

    public Train1_4_Person(String name, int age, String familyStatus) {
        this.age = age;
        this.familyStatus = familyStatus;
        this.name = name;
    }

    void growUp() {
        age++;
    }

    void changeName(String newName) {
        name = newName;
    }

    void addChild(String child) {
        children.add(child);
    }

    void changeFamilyStatus(String newFamilyStatus) {
        familyStatus = newFamilyStatus;
    }

    void printInfo() {
        System.out.println("姓名：" + name +"，年龄：" + age + "，身份：" + familyStatus);
        System.out.println("孩子" + children);
    }
}
