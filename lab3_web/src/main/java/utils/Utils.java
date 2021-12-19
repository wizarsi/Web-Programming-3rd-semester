package utils;

public class Utils {
    public static boolean isNumeric(String str) {
        //str.replaceFirst(",", ".");
        return str.matches("-?\\d+(\\.\\d+)?");
    }

}
