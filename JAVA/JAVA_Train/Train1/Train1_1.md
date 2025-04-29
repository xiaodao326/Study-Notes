## 题目：

- 计算从出生那天到现在的天数
## 代码：

```JAVA
package com.xiaodao;  
  
public class Train1_1 {  
    public static void main(String[] args) {  
/*        // 1. 获取用户出生年月日  
        Scanner sc = new Scanner(System.in);  
        String data ="";        
        while (true) {            
	        System.out.println("请输入出生日期（格式：yyyy-mm-dd）:");  
            data = sc.nextLine();  
            // 1.1用户输入检测  
            if (data.length() != 10) {
	            System.out.println("您输入的日期格式有问题，请重新输入");  
            } else {                
	            break; // 输入正确，退出循环  
            }        
        }*/  
        String date = InputDate.Input();  
  
/*        // 2. 计算用户生活时间  
        LocalDate Birthday = LocalDate.parse(data);        
        LocalDate now = LocalDate.now();        
        long days = ChronoUnit.DAYS.between(Birthday, now);*/  
        long days = CalculateDaysToToday.CountDay(date);  
  
        // 3. 打印计算结果  
        System.out.println("您已经在地球online中游玩了" + days + "天");  
    }  
}
```

```JAVA
package com.xiaodao;  
  
import java.util.Scanner;  
  
public class InputDate {  
    public static String Input() {  
        Scanner sc = new Scanner(System.in);  
        String data ="";  
        while (true) {  
            System.out.println("请输入出生日期（格式：yyyy-mm-dd）:");  
            data = sc.nextLine();  
  
            // 1.1用户输入检测  
            if (data.length() != 10) {  
                System.out.println("您输入的日期格式有问题，请重新输入");  
            } else {  
                return data;// 输入正确，退出循环  
            }  
        }  
    }  
}
```

```JAVA
package com.xiaodao;  
  
import java.time.LocalDate;  
import java.time.temporal.ChronoUnit;  
  
public class CalculateDaysToToday {  
    public static long CountDay (String day) {  
        LocalDate inputDate = LocalDate.parse(day);  
        LocalDate now = LocalDate.now();  
        return ChronoUnit.DAYS.between(inputDate, now);  
    }  
}
```

## 实现思路：

- 思路是：
	获取用户输入的出生日期->将数据进行计算得出到今天的天数->打印计算的天数

## 感悟：

- 最开始理清思路后开始敲代码，先初步的完成代码，后再考虑是否会出现问题，若出现问题应当如何解决