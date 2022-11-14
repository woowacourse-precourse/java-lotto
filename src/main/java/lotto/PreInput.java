package lotto;

import lotto.exception.NonNumberFailure;

import java.util.regex.Pattern;

public class PreInput {
    private static final Pattern NOT_NUMBER = Pattern.compile("^\\D$");

    public static void checkInput(String money) {
        try {
            checkNonNumber(money);
        } catch (NonNumberFailure e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkNonNumber(String money) {
        if (!NOT_NUMBER.matcher(money).matches()) {
            throw new NonNumberFailure("[ERROR] 숫자가 아닌 문자를 입력했습니다.");
        }
    }

}
