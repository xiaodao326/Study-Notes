## 题目：

- 输入一个时间，计算从那个时间到现在的天数

## 代码：

```JAVA
package com.xiaodao;  
  
import java.util.List;  
  
public class Train1_2 {  
    public static void main(String[] args) {  
        // 1. 获取用户输入的年月日  
        List<String> dateList = InputDateStream.input();  
  
        // 2. 计算时间  
        dateList.stream()  
                .map(date -> {  
                    long days = CalculateDaysToToday.CountDay(date);  
                    return "日期" + date + "至今" + days + "天";  
                })  
                // 3. 打印计算结果  
                .forEach(System.out::println);  
    }  
}
```

```JAVA
package com.xiaodao;  
  
import java.util.Arrays;  
import java.util.List;  
import java.util.Scanner;  
import java.util.stream.Collectors;  
  
public class InputDateStream {  
    public static List<String> input() {  
        Scanner sc = new Scanner(System.in);  
        System.out.println("请输入日期(格式：yyyy-mm-dd(可输入多个日期，但多个日期之间请用“,”做分割)):");  
        String date = sc.nextLine();  
        return Arrays.stream(date.split(","))  
                .map(String::trim)  
                .collect(Collectors.toList());  
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

## 实现思路

- 思路是：
	获取用户输入的日期->将数据进行计算得出到今天的天数->打印计算的天数

## 感悟：

- 在读完题目后发现与第一题代码的实现思路一致，想起可以将相同功能的代码单独出来，成为一个工具类
- 于是尝试开始优化代码，首先将相同功能的代码单独出去，后又尝试用一些不同的解法去实现功能
- 在研究这两道题的时候自己也乐在其中并且复习了之前所学过的知识，感受到了不同的代码带来的多样解法