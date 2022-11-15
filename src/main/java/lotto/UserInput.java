package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class UserInput {
    private static final String AMOUNT_INPUT_MSG = "구입금액을 입력해 주세요";
    private static final String TARGET_NUMBERS_INPUT_MSG = "당첨 번호를 입력해 주세요";
    private static final String BONUS_NUMBERS_INPUT_MSG = "보너스 번호를 입력해 주세요";
    private static final String AMOUNT_ERROR_MSG = "[ERROR] 잘못된 금액 값을 입력했습니다.";

    public static int inputAmount() {
        System.out.println(AMOUNT_INPUT_MSG);
        String str = Console.readLine();

        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            throw new IllegalArgumentException(AMOUNT_ERROR_MSG);
        }
    }

    public static List<Integer> inputTargetNumbers() {
        System.out.println(TARGET_NUMBERS_INPUT_MSG);
        String input = Console.readLine();
        String[] targets = input.split(",");

        List<Integer> targetNumbers = new ArrayList<>();

        for(String num : targets) {
            targetNumbers.add(Integer.parseInt(num.trim()));
        }

        return targetNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBERS_INPUT_MSG);
        String input = Console.readLine();

        return Integer.parseInt(input);
    }
}
