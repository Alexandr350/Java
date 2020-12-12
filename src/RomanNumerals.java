import java.util.ArrayList;
// класс перевода арабских цифр в римские
public class RomanNumerals {

    public static String romanCase(int a) {
        String numeral = "";
        switch (a) {
            case 1:
                numeral = "I";
                break;
            case 5:
                numeral = "V";
                break;
            case 10:
                numeral = "X";
                break;
            case 50:
                numeral = "L";
                break;
            case 100:
                numeral = "C";
                break;
        }
        return numeral;

    }

    public static ArrayList<Integer> dec(int a) {                       // определение числового порядка.
        int numberLength = String.valueOf(a).length();
        ArrayList<Integer> hundred = new ArrayList<>();
        if (numberLength > 2) {
            hundred.add(a / 100);
            hundred.add(a / 10 % 10);
            hundred.add(a % 10);
        } else if (numberLength > 1) {
            hundred.add(a / 10);
            hundred.add(a % 10);
        } else if (numberLength == 1) {
            hundred.add(a);
        }
        return hundred;
    }

    public static StringBuffer romanNumeral(int b) {                                    // Преоброзовние арабских в римские цифры до 100
        StringBuffer romanBuff = new StringBuffer();
        String str;
        ArrayList<Integer> list = dec(b);
        if (list.size() == 1){                                      //Единицы
            for(int i = 1; i <= list.get(0); i++){
                int d =1;
                if (i == 4 || i == 9) {
                    romanBuff.delete(romanBuff.length() -2, romanBuff.length());
                    if(i == 9){romanBuff.deleteCharAt(0);}
                    str = romanCase(i + 1);
                    romanBuff.append(str);
                }
                if (i == 5 || i == 10 ) {
                    romanBuff.deleteCharAt(0);
                }
                str = romanCase(d);
                romanBuff.append(str);
                if(i == 4 || i == 5 || i == 9){
                    romanBuff.delete(romanBuff.length()-1,romanBuff.length());
                }

            }
        }if(list.size() == 2){                                              //Деятки

            for(int i = 1; i <= list.get(0); i++){
                int t = 1;
                str = romanCase(t*10);
                romanBuff.append(str);
                if (i == 4 || i == 9) {
                    romanBuff.delete(romanBuff.length()-3, romanBuff.length());
                    if(i==9){romanBuff.deleteCharAt(0);}
                    str = romanCase((i +1) * 10 );
                    romanBuff.append(str);
                }

                if (i == 5 || i == 10 || i == 9) {
                    if(i == 9){romanBuff.delete(2, romanBuff.length());}
                    if(i == 5){romanBuff.delete(0, romanBuff.length());}
                    str = romanCase(i * 10);
                    romanBuff.append(str);
                }


            }
                for (int j = 1; j <= list.get(1); j++){
                    int d = 1;
                    if (j == 5 || j == 10 ) {
                        romanBuff.delete(romanBuff.length() -2, romanBuff.length());
                        str = romanCase(j);
                        romanBuff.append(str);
                    }
                    if (j == 4 || j == 9) {
                        romanBuff.delete(romanBuff.length() - 2, romanBuff.length());
                        str = romanCase(j+1);
                        romanBuff.append(str);
                    }
                    str = romanCase(d);
                    romanBuff.append(str);
                    if(j == 4 || j == 5 || j == 9){
                        romanBuff.delete(romanBuff.length()-1,romanBuff.length());
                        if(romanBuff.length() == 4){
                            if(j==9){romanBuff.deleteCharAt(1);}
                        }
                        if(romanBuff.length() == 5){
                            if(j==9){romanBuff.deleteCharAt(2);}
                        }
                        if(romanBuff.length() == 6){
                            if(j==9){romanBuff.deleteCharAt(3);}
                        }
                        if(romanBuff.length() == 7){
                            if(j==9){romanBuff.deleteCharAt(4);}
                        }
                    }


                }
        }
        if(list.size() == 3) {                                          //Сотни
            int i = 1;
            String st = romanCase(i *100);
            romanBuff.append(st);
        }
        return romanBuff;
        }

}
