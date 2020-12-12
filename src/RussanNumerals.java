import java.util.ArrayList;
// класс перевода римских цифр в арабские
public class RussanNumerals {
    public static int russanCase(String str){
        int iter = 0;
        switch (str){
            case "I":
                iter = 1;
                break;
            case "V":
                iter = 5;
                break;
            case "X":
                iter = 10;

        }
        return iter;
    }

    public static int rusNumeral(ArrayList<String> list){                           // Метод переводит римские цифры в арабские до 10
        int rusNumeral = 0;
        for(int i = 0; i < list.size() ; i++){
            if(list.size() == 2 && rusNumeral != 5){
                for (int j = 0; j < list.size() -1; j++){
               if(russanCase(list.get(j)) < russanCase(list.get(j+1))){
                    rusNumeral = - 1;
                }
                }
            }
            rusNumeral += russanCase(list.get(i));
        }
        return rusNumeral;
    }

    public static ArrayList<String> helper(String str){                             // Метод заливает символы римского числа в ArrayList
        ArrayList<String> listRomanNumeral = new ArrayList<>();
        char[] romanNumeral = str.toCharArray();
        int i = 0;
        while (true){
            if(romanNumeral.length == i){
                break;
            }
            listRomanNumeral.add(String.valueOf(romanNumeral[i]));
            i++;
        }
        return listRomanNumeral;
    }
}
