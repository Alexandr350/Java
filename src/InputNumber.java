import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// класс ввода выражения
public  class InputNumber {
    static String MathEx;
    static String [] mathExSplit;

    public static String inputBuff () throws IOException {                                 // Ввод арифметического выращения
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           MathEx = reader.readLine();
           return MathEx;

    }
    public static Boolean check (String mathEx){                    //Проверка на наличие цифр в выражении
        return mathEx.matches("^[^0-9]*$");
    }

    public static String[] split(String mathEx) {                // Разделение выражения на составляющие
        try {
            mathExSplit = mathEx.split(" ");
            if(mathExSplit.length < 3){
            throw new ArrayIndexOutOfBoundsException("Некорректный ввод!!!");}
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
            System.exit(-1);
        }
        return mathExSplit;
    }

    public static void limit(String[] str){                     // Метод лимитных значений
        try {
            if(mathExSplit.length < 3){
                throw new ArrayIndexOutOfBoundsException("Некорректный ввод!!!");
            }
            if(check(str[0]) || check(str[2])){
                if(RussanNumerals.rusNumeral(RussanNumerals.helper(str[0])) < 1 || RussanNumerals.rusNumeral(RussanNumerals.helper(str[0])) >10){
                    throw new Exception("Некорректный ввод!!! \n" +
                            "Введите числа от 1 до 10 или от I до X");
                }
                if(RussanNumerals.rusNumeral(RussanNumerals.helper(str[2])) < 1 || RussanNumerals.rusNumeral(RussanNumerals.helper(str[2])) >10){
                    throw  new Exception("Некорректный ввод!!! \n" +
                            "Введите числа от 1 до 10 или от I до X");
                }
            }else {
                if (Integer.parseInt(str[0]) < 1 || Integer.parseInt(str[0]) > 10) {
                    throw new Exception("Некорректный ввод!!! \n" +
                            "Введите числа от 1 до 10 или от I до X");
                }
                if(Integer.parseInt(str[2]) < 1 || Integer.parseInt(str[2]) > 10){
                    throw new Exception("Некорректный ввод!!! \n" +
                            "Введите числа от 1 до 10 или от I до X");
                }
        }
        }catch (ArrayIndexOutOfBoundsException e ){
            System.out.println(e);
            System.exit(-1);
        }catch (Exception r){
            System.out.println(r);
            System.exit(-1);
        }
    }
    public static void error(String mathEx){                        // Метод проверки правильного ввода
        try {
            String[] str = split(mathEx);
            boolean boolStr0 = check(str[0]);
            boolean boolStr1 = check(str[2]);
            if (!boolStr0 && boolStr1) {
                throw new Exception("Некорректный ввод!!! Введите римские или арабские цифры");
            }
            if (boolStr0 && !boolStr1) {
                throw new Exception("Некорректный ввод!!! Введите римские или арабские цифры");
            }

            if (!str[1].equals(Calculator.Sum) && !str[1].equals(Calculator.Multi) && !str[1].equals(Calculator.Div) && !str[1].equals(Calculator.Defer)) {
                throw new Exception("Некорректный ввод!!! отсутсвует арифметический оператор!");
            }
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println(ex);
            System.exit(-1);

        }catch (Exception e){
            System.out.println(e);
            System.exit(-1);
        }


    }



}
