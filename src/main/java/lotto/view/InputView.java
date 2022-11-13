package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoInputException;

import java.util.regex.Pattern;

public class InputView {
    private static final String PURCHASE_GREETING = "구입금액을 입력해 주세요.";

    private static final Pattern NOT_NUMBER = Pattern.compile("^\\D$");

    public static String inputMoney() {
        String money = Console.readLine();
        checkMoney(money);
        return money;
    }

    private static void checkMoney(String money) {
        try {
            validateMoney(money);
        } catch (LottoInputException e) {
            System.out.println(e.getMessage());;
        }
    }

    private static void validateMoney(String money) {
        if (!NOT_NUMBER.matcher(money).matches()) {
            throw new LottoInputException("[ERROR] 숫자가 아닌 문자를 입력했습니다.");
        }
    }
}
