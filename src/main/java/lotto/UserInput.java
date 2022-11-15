package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요";
    private static final String MONEY_ERROR_MESSAGE = "[ERROR] 잘못된 금액 값을 입력했습니다.";
    private static final String BONUS_NUMBERS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요";
    private static final String TARGET_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요";

    public static int moneyInput() {
        System.out.println(MONEY_INPUT_MESSAGE);
        String userInputMoney = Console.readLine();

        try {
            return Integer.parseInt(userInputMoney);
        } catch (Exception e) {
            throw new IllegalArgumentException(MONEY_ERROR_MESSAGE);
        }
    }

    public static List<Integer> inputTargetNumbers() {
        System.out.println(TARGET_NUMBERS_INPUT_MESSAGE);
        String input = Console.readLine();
        String[] targets = input.split(",");
        List<Integer> targetNumbers = new ArrayList<>();
        for (String num : targets) {
            targetNumbers.add(Integer.parseInt(num.trim()));
        }
        return targetNumbers;
    }

    public static int inputBonusNumber() {
            System.out.println(BONUS_NUMBERS_INPUT_MESSAGE);
            String input = Console.readLine();

            return Integer.parseInt(input);
    }
}

