package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.PreInput;
import lotto.exception.NonNumberFailure;

import java.util.regex.Pattern;

public class InputView {
    private static final String PURCHASE_GREETING = "구입금액을 입력해 주세요.";

    private static final Pattern NOT_NUMBER = Pattern.compile("^\\D$");


    public static int money() {
        String input = Console.readLine();
        checkInput(input);
        return Integer.parseInt(input);
    }

    public static void startGuide() {
        System.out.println(PURCHASE_GREETING);
    }
    private static void checkInput(String money) {
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
