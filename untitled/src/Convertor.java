import java.util.ArrayList;
import java.util.Collections;

public class Convertor {
    public static ArrayList<String> getNumber(ArrayList<Integer> test) {
       ArrayList <String> convert = new ArrayList<>();
        Collections.reverse(test);
       for(int i = 0; i < test.size(); i++) {
           String s ="";
           int x = test.get(test.size()-i-1);
           while(i==0) {
               s = switch(x) {
                   case 1 -> "I";
                   case 2 -> "II";
                   case 3 -> "III";
                   case 4 -> "IV";
                   case 5 -> "V";
                   case 6 -> "VI";
                   case 7 -> "VII";
                   case 8 -> "VIII";
                   case 9 -> "IX";
                   case 0 -> "";
                   default -> "";
               };
               convert.add(s);
               break;
           }
           while(i==1) {
               s = switch(x) {
                   case 1 -> "X";
                   case 2 -> "XX";
                   case 3 -> "XXX";
                   case 4 -> "XL";
                   case 5 -> "L";
                   case 6 -> "LX";
                   case 7 -> "LXX";
                   case 8 -> "LXXX";
                   case 9 -> "XC";
                   case 0 -> "";
                   default -> "";
               };
               convert.add(s);
               break;
           }
           while(i==2) {
               s = switch (x) {
                   case 1 -> "C";
                   case 2 -> "CC";
                   case 3 -> "CCC";
                   case 4 -> "CD";
                   case 5 -> "D";
                   case 6 -> "DC";
                   case 7 -> "DCC";
                   case 8 -> "DCCC";
                   case 9 -> "CM";
                   case 0 -> "";
                   default -> "";
               };
               convert.add(s);
               break;
           }
           while (i==3) {
               s = switch (x) {
                   case 1 -> "M";
                   case 2 -> "MM";
                   case 3 -> "MMM";
                   default -> "";
               };
               convert.add(s);
               break;
           }
       }
       Collections.reverse(convert);
       return convert;
    }
}
