package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Money;
import lotto.exception.InputException;

import java.util.regex.Pattern;

public class InputView {
    private static final String PURCHASE_GREETING = "구입금액을 입력해 주세요.";

    private static final Pattern Non_Number = Pattern.compile("^\\D$");


    public static Money money() {
        String input = Console.readLine();
        checkInput(input);
        return new Money(convertInt(input));
    }

    private static int convertInt(String input) {
        return Integer.parseInt(input);
    }

    public static void startGuide() {
        System.out.println(PURCHASE_GREETING);
    }

    private static void checkInput(String money) {
        try {
            checkNonNumber(money);
        } catch (InputException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void checkInput() {
        String money = Console.readLine();
        try {
            checkNonNumber(money);
        } catch (InputException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void checkNonNumber(String money) {
        if (!Non_Number.matcher(money).matches()) {
            throw new InputException("[ERROR] 숫자가 아닌 문자를 입력했습니다.");
        }
    }
}
