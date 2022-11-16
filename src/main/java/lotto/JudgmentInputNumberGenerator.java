package lotto;

public class JudgmentInputNumberGenerator {
    public static boolean JudgmentInputNumber(String InputUserMoney) {

        boolean isNumeric = true;
        for (int i = 0; i < InputUserMoney.length(); i++) {
            if (!Character.isDigit(InputUserMoney.charAt(i))) {
                isNumeric = false;
            }
        }

        return isNumeric;
    }
}
