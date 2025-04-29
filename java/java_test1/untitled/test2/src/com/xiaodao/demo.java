package com.xiaodao;
import java.util.*;


public class demo {
    private static final ArrayList<String> history = new ArrayList<>();

    // main 函数
    public static void main(String[] args) {
        // 创建 Scanner 对象 读取输入
        Scanner scanner = new Scanner(System.in);
        // 打印信息
        System.out.println("Java计算器（输入 exit 退出，输入 history 查看历史记录）");

        // 循环读取用户输入
        while (true) {
            // 打印提示信息
            System.out.print("请输入表达式：");
            // 读取数据并转换为字符串
            String input = scanner.nextLine().trim();

            // 判断用户输入是否为 exit 如果是就打断 退出程序
            if (input.equalsIgnoreCase("exit")) break;

            // 判断用户输入是否为 history 如果是就打印历史记录
            if (input.equalsIgnoreCase("history")) {
                // 调用 showHistory 方法 打印历史记录 然后继续循环
                showHistory(); // 缺失代码1
                continue;
            }

            // 计算输入的表达式
            try {
                // 调用 calculate 方法 计算表达式
                double result = calculate(input);
                // 将表达式与结果拼接为字符串 并用 record 临时存储字符串
                String record = input + " = " + result;
                // 将计算结果添加到历史记录中
                history.add(record); // 缺失代码2
                // 打印结果
                System.out.println("结果: " + result);
            } catch (Exception e) {
                // 若发生错误 则打印错误信息
                System.out.println("错误: " + e.getMessage());
            }
        }
        scanner.close();
    }

    // 计算函数
    private static double calculate(String expression) {
        expression = expression.replaceAll("\\s+", "");
        List<String> tokens = tokenize(expression);
        List<String> postfix = toPostfix(tokens);
        return evalPostfix(postfix);
    }

    // 分离数字与符号函数
    private static List<String> tokenize(String expr) {
        List<String> tokens = new ArrayList<>();
        int i = 0;
        while (i < expr.length()) {
            char c = expr.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                StringBuilder num = new StringBuilder();
                while (i < expr.length() && (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.')) {
                    num.append(expr.charAt(i++));
                }
                tokens.add(num.toString());
            } else {
                tokens.add(Character.toString(c));
                i++;
            }
        }
        return tokens;
    }

    // 转换为后缀表达式
    private static List<String> toPostfix(List<String> tokens) {
        List<String> output = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (token.matches("\\d+(\\.\\d+)?")) {
                output.add(token);
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                stack.pop(); // 弹出左括号
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    output.add(stack.pop());
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return output;
    }

    // 获取操作符的优先级
    private static int precedence(String op) {
        if (op.equals("+") || op.equals("-")) return 1;
        if (op.equals("*") || op.equals("/")) return 2;
        return 0;
    }

    // 计算后缀表达式
    private static double evalPostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfix) {
            if (token.matches("\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        if (b == 0) throw new ArithmeticException("除零错误");
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }

    // 打印历史记录
    private static void showHistory() {
        System.out.println("\n=== 计算历史 ===");
        if (history.isEmpty()) {
            System.out.println("无历史记录");
        } else {
            for (String record : history) {
                System.out.println(record);
            }
        }
        System.out.println("=================\n");
    }
}
