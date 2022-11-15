package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import lotto.util.InputValidator;

public class InputView {
    private static final String MONEY_INPUT_REQUEST = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_REQUEST = "\n당첨 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";
    private static final String BONUS_NUMBER_REQUEST = "\n보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static int requestMoneyInput() {
        System.out.println(MONEY_INPUT_REQUEST);
        return readSingleNumber(Console.readLine());
    }

    public static List<Integer> requestWinningNumber() {
        System.out.println(WINNING_NUMBER_REQUEST);
        return readWinningNumbers(Console.readLine());
    }

    public static int requestBonusNumber() {
        System.out.println(BONUS_NUMBER_REQUEST);
        return readSingleNumber(Console.readLine());
    }

    private static int readSingleNumber(String input) {
        return toInt(input);
    }

    private static List<Integer> readWinningNumbers(String input) {
        InputValidator.validateWinningNumberDelimiter(input);
        return transferToNumberList(new StringTokenizer(input, DELIMITER));
    }

    private static List<Integer> transferToNumberList(StringTokenizer tokenizer) {
        List<Integer> numbers = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            numbers.add(toInt(tokenizer.nextToken()));
        }
        return numbers;
    }

    private static int toInt(String input) {
        return InputValidator.validateParsingInteger(input);
    }
}
