import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static String arab_font[] = {"1",  "2",   "3",  "4", "5",  "6",   "7",    "8",  "9", "10"};
    static String[] romn_font = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",  "X"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String [] str = s.split(" ");

        if(str.length != 3) throw new NumberFormatException("Incorrect entry of the operation");

        boolean check_arab = compareArabTypes(str[0]) && compareArabTypes(str[2]);    //range of values [1: 10] + int
        boolean check_romn = compareRomanTypes(str[0]) && compareRomanTypes(str[2]);  //range of values [1: 10] + int

        if (!check_arab && !check_romn) throw new NumberFormatException("Number types don't match. Number(-s) is (are) out of range");

        if(check_arab){
            int num1 = Integer.parseInt(str[0].trim());
            int num2 = Integer.parseInt(str[2].trim());

            System.out.println(calculation(num1, num2, str[1].charAt(0)));
        } else{
            int num1 = Arrays.asList(romn_font).indexOf(str[0]) + 1;
            int num2 = Arrays.asList(romn_font).indexOf(str[2]) + 1;

            System.out.println(convertToRoman(calculation(num1, num2, str[1].charAt(0))));
        }
    }

    static int calculation (int a, int b, char symbol_operation){
        switch (symbol_operation){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return Math.round((float) a / b);

            default: throw new NumberFormatException("Operation is not provided");
        }
    }

    static boolean compareArabTypes (String s){
        boolean flag = false;
            for(byte i = 0; i < arab_font.length; i++){
                if(s.equals(arab_font[i])) flag = true;
            }
        return flag;
    }

    static boolean compareRomanTypes (String s){
        boolean flag = false;
            for(byte i = 0; i < romn_font.length; i++){
                if(s.equals(romn_font[i])) flag = true;
            }
        return flag;
    }

    static String convertToRoman (int arab_num){
        String string = "";

        if(arab_num == 100){
            string += "C";
            arab_num -= 100;
        }
        while (arab_num >= 90) {
            string += "XC";
            arab_num -= 90;
        }
        while (arab_num >= 50) {
            string += "L";
            arab_num -= 50;
        }
        while (arab_num >= 40) {
            string += "XL";
            arab_num -= 40;
        }
        while (arab_num >= 10) {
            string += "X";
            arab_num -= 10;
        }
        while (arab_num >= 9) {
            string += "IX";
            arab_num -= 9;
        }
        while (arab_num >= 5) {
            string += "V";
            arab_num -= 5;
        }
        while (arab_num >= 4) {
            string += "IV";
            arab_num -= 4;
        }
        while (arab_num >= 1) {
            string += "I";
            arab_num -= 1;
        }

        return string;
    }
}