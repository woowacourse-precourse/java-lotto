package lotto;

public class LottoUtil {

    public int StringToInt(String input) {
        if(!isNumeric(input))
            throw new IllegalArgumentException("[ERROR] 입력이 숫자가 아닙니다.");

        return Integer.parseInt(input);
    }

    public static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.]+");
    }
}
