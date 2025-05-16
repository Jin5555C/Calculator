package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num1 = readDouble(scanner, "1つ目の数値を入力してください: ");
        char operator = readOperator(scanner, "演算子を入力してください (+, -, *, /): ");
        double num2 = readDouble(scanner, "2つ目の数値を入力してください: ");

        double result = 0;
        boolean valid = true;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("エラー: 0で割ることはできません。");
                    valid = false;
                }
                break;
            default:
               valid = false;
        }

        if (valid){
            System.out.println("結果: " + num1  + " " + operator + " "  + num2 + " = "+ result);
        }
        scanner.close();
    }

    // 数値入力が正しいかどうかチェック
    private static double readDouble(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextDouble();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("無効な入力です。数値を入力してください。");
                scanner.next();
            }
        }
        return value;
    }

    // 演算子入力が正しいかどうかのチェック
    private static char readOperator(Scanner scanner, String prompt) {
        char operator;
        while (true) {
            System.out.print(prompt);
            operator = scanner.next().charAt(0);
            if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                break;
            } else {
                System.out.println("無効な演算子です。+、-、*、/ のいずれかを入力してください。");
            }
        }
        return operator;
    }
}
