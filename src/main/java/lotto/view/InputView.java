package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Validator;

public class InputView {
    private static final String MESSAGE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_INPUT_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static final Validator validator = new Validator();

    public static String inputMoney() {
        System.out.println(MESSAGE_INPUT_MONEY);
        return readLine();
    }

    public static List<Integer> inputNumbers() {
        System.out.println(MESSAGE_INPUT_NUMBERS);
        String input = readLine();
        validator.validateInputNumbers(input);
        return Arrays.stream(input.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println(MESSAGE_INPUT_BONUS_NUMBER);
        String input = readLine();
        validator.validateInput(input);
        return Integer.parseInt(input);
    }
}
