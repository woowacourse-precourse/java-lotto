package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String ERROR_NOT_INT = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String MESSAGE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_INPUT_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    
    public static int inputMoney() {
        System.out.println(MESSAGE_INPUT_MONEY);
        return convertInt(readLine());
    }

    public static List<Integer> inputNumbers() {
        System.out.println(MESSAGE_INPUT_NUMBERS);
        String input = readLine();
        return Arrays.stream(input.split(","))
                .map(InputView::convertInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println(MESSAGE_INPUT_BONUS_NUMBER);
        return convertInt(readLine());
    }

    private static int convertInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_NOT_INT);
            throw new IllegalArgumentException(ERROR_NOT_INT);
        }
    }
}
