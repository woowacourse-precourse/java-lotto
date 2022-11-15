package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String ERROR_MESSAGE_MONEY_UNIT = "[ERROR] 구입금액은 1,000원 단위여야 합니다.";
    private static final String ERROR_MESSAGE_NUMBER_FORMAT = "[ERROR] 숫자 외 문자가 입력되었습니다.";
    private static final String INPUT_MESSAGE_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_MESSAGE_ANSWER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_BONUS = "보너스 번호를 입력해 주세요.";
    private static final int MONEY_UNIT = 1000;

    public static int getInputMoney() {
        System.out.println(INPUT_MESSAGE_MONEY);
        String input = Console.readLine();
        validateNumberFormat(input);
        int money = Integer.parseInt(input);
        validateInputMoneyUnit(money);
        return money;
    }

    public static void validateInputMoneyUnit(int inputMoney) {
        if (inputMoney % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_UNIT);
        }
    }

    public static void validateNumberFormat(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_FORMAT);
        }
    }

    public static Lotto getInputAnswer() {
        System.out.println(INPUT_MESSAGE_ANSWER);
        String[] inputAnswer = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputAnswer) {
            validateNumberFormat(input);
            numbers.add(Integer.parseInt(input));
        }
        return new Lotto(numbers);

    }

    public static int getInputBonusNumber() {
        System.out.println(INPUT_MESSAGE_BONUS);
        String input = Console.readLine();
        validateNumberFormat(input);
        return Integer.parseInt(input);
    }


}
