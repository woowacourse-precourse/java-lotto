package lotto.inputtool;

public class TextConverter {
    public static String[] splitComma(String text) {
        String[] numberArray = text.split(",");
        return numberArray;
    }
}
