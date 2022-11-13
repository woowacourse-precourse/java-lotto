package lotto.utils;

public class Validator {
    public static boolean validateInteger(String input){
        if (! input.matches("[0-9]+")) {
            return false;
        }
        return true;
    }
}
