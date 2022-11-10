package lotto;

public class Util {

    public static boolean isNumberic(String str){
        return str.chars().allMatch(Character::isDigit);
    }
}
