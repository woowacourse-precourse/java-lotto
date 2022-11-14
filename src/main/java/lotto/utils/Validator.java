package lotto.utils;

public class Validator {

    public Validator() {}

    public int convertToInt(String s) {
        return Integer.parseInt(s);
    }

    public boolean isValidPrice(int price) {
        if (price % 1000 != 0) {
            return false;
        }
        return true;
    }
}
