package lotto.view;

import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_INTRO = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String INPUT_SHOULD_INTEGER = "[ERROR] 입력 번호는 정수이어야 합니다.";
    private static final String DELIMITER = ",";
    private static final int LIMIT = -1;

    public int inputPurchasingPrice() {
        System.out.println(INPUT_INTRO);
        return convertToInteger();
    }

    private int convertToInteger() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_SHOULD_INTEGER);
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_LOTTO_GUIDE);
        return Arrays.stream(nextLineWithSplit())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String[] nextLineWithSplit() {
        return Console.readLine()
                .split(DELIMITER, LIMIT);
    }

    public int inputBonusBallNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return convertToInteger();
    }
}
