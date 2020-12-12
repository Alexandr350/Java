public class Calculator {
    static String Div = "/";
    static String Sum = "+";
    static String Multi = "*";
    static String Defer = "-";
    public static int calc(String[] str, int a, int b){
        int result = 0;
        if(str[1].equals(Sum))
            result = a+b;
        if(str[1].equals(Div))
            result = a/b;
        if(str[1].equals(Multi))
            result = a*b;
        if(str[1].equals(Defer))
            result = a-b;

        return result;
    }


}
