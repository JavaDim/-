import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.copyOf;

public class Calculyator {
   private static String[] rimArray = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
   private static String[] arabArray = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
   private static char[] operationArray = {'+', '-', '*', '/'};
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные в калькулятор от 1 до 10 - число, операция, число:");
        String str = sc.nextLine();
        char operation = getOperation(str);
        int index = str.indexOf(operation);
        if(index==0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Сначала вводим число, отрицательные числа не принимаются");
            }
        } else if (index<0) {
                System.out.println("Используйте операторы('+', '-', '*', '/')");
            }
         else {
           String num1 = getNum(str, index, 0);
           String num2 = getNum(str, index, 1);
           System.out.println(calculation(num1, num2, operation));
       }

    }
    private static String getNum(String str, int index, int number){
       String num = "";
       ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(arabArray));
        list.addAll(Arrays.asList(rimArray));
        String st = "";
        if(number==0) {
            st = str.substring(number, index);
        }
        if(number==1) {
            st = str.substring((index+number));
        }
        for(String s: list) {
            if (st.equals(s)) {
               num = st;
            }
        }
            if (num.equals("")) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Вводите два числа от 1 до 10 и один оператор");
                }
            }
        return num;
    }
    private static char getOperation(String str) {
       char op = 0;
       for(char c: operationArray){
           if(str.contains(String.valueOf(c))) {
               op = c;
               break;
           }
       } return op;
    }
    private static boolean isArab(String num) {
       for(String number: arabArray) {
           if(num.equals(number)) return true;
       } return false;
    }
    private  static boolean isRome(String num) {
       for(String number: rimArray) {
           if(num.equals(number)) return true;
       } return false;
    }
    private static String calculation(String num1, String num2, char operate) {
       String result = "Попробуйте снова";
       if(isArab(num1)&&isArab(num2)) {
           int a = Integer.parseInt(num1);
           int b = Integer.parseInt(num2);
           int c = switch(operate) {
               case '+' -> a+b;
               case '-' -> a-b;
               case '*' -> a*b;
               case '/' -> a/b;
               default -> 0;
           };
           result = String.valueOf(c);
       } else if(isRome(num1)&&isRome(num2)) {
           String str1 = Test.convert(num1);
           int a = Integer.parseInt(str1);
           String str2 = Test.convert(num2);
           int b = Integer.parseInt(str2);
           int c = switch(operate) {
               case '+' -> a+b;
               case '-' -> a-b;
               case '*' -> a*b;
               case '/' -> a/b;
               default -> 0;
           };
           if(c<1) {
               try {
                   throw new ArithmeticException();
               } catch (ArithmeticException e) {
                   System.out.println("Результат меньше еденицы \nВ римской системе их не существует");
               }
           }
           result = Test.convert(String.valueOf(c));
       } else if ((isRome(num1)&&isArab(num2))||(isArab(num1)&&isRome(num2))){
           try {
               throw new IOException();
           } catch (IOException e) {
               System.out.println("арабское число не работает с римским");
           }
       } return result;
    }


}
