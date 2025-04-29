## 题目：

- 创建类对象，要求写一个人的类，内容包括：
	- 值：
		- 年龄
		- 姓名
		- 家庭身份
	- 函数：
		- 年龄++
		- 姓名修改
		- 家庭身份修改
		- 生孩子

## 代码：

```JAVA
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
```

```JAVA
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
```

## 实现思路：

- 根据题目要求创建一个类->逐步实现每个需求->写一个Test类进行试验，确保代码正确无误

## 感悟：

- 回顾刚开学习面向对象时学习的知识，帮助巩固之前所月的知识
- 在敲代码时要合理运用快捷键，可以提升敲代码的效率
- 在实现需求时要一点一点的完成，以防遗漏
- 最后检查时，需要仔细核对代码是否实现所有需求