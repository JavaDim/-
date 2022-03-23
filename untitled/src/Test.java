import java.util.ArrayList;
import java.util.Scanner;
public class Test {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите число от 1 до 3999 : ");
        String str = console.nextLine();
        System.out.println(convert(str));
    }

    public static String getRome(int number) {
        ArrayList<Integer> list = new ArrayList<>();
        String st = "";
        while (number > 0) {
            int x = number % 10;
            list.add(x);
            number = number / 10;
        }
        for (String s : Convertor.getNumber(list)) {
            st = st + s;
        }
        return st;
    }

    public static boolean isNumeric(String str){
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static String convert(String str) {
        String s = "";
        int number = 0;
        if(isNumeric(str)) {
            number = Integer.parseInt(str);
            if(number>0 && number<3999) {
                return getRome(number);
            } else {
                s = "";
            } return s;
        } else {
            number = 1;
            while(number<4000){
                if(str.equals(getRome(number))){
                    s = String.valueOf(number);
                    break;
                }
                number++;
            } return s;
        }
    }
}
