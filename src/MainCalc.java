import java.io.IOException;

public class MainCalc {
    public static void main(String[] args) throws IOException {
        String inputStr = InputNumber.inputBuff();
        InputNumber.error(inputStr);
        InputNumber.limit(InputNumber.split(inputStr));
        String[] numerals = InputNumber.split(inputStr);
        if(InputNumber.check(numerals[0])){
            int a = RussanNumerals.rusNumeral(RussanNumerals.helper(numerals[0]));
            int b = RussanNumerals.rusNumeral(RussanNumerals.helper(numerals[2]));
            try {
                int result = Calculator.calc(numerals, a, b);
                if(result == 0){
                    System.out.println(RomanNumerals.romanCase(result));
                }
                System.out.println(RomanNumerals.romanNumeral(result));
                if (result < 0) {
                    throw new Exception("Римляне не использовали отрицательных чисел!");
                }
            }catch (Exception e){
                System.out.println(e);
                System.exit(-1);
            }

        }else {
            int a = Integer.parseInt(numerals[0]);
            int b = Integer.parseInt(numerals[2]);
            int result = Calculator.calc(numerals, a , b);
            System.out.println(result);
        }
    }
}
