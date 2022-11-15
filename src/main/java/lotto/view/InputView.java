package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {
    private static final String INPUT_MONEY_COMMENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUM_COMMENT = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_LOTTO_NUM_COMMENT = "\n보너스 번호를 입력해 주세요.";

    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_COMMENT);
        return readSingleNumber(Console.readLine());
    }

    public static List<Integer> inputLottoNum() {
        System.out.println(INPUT_LOTTO_NUM_COMMENT);
        return readWinningNumbers(Console.readLine());
    }

    public static int inputBonusNum() {
        System.out.println(INPUT_BONUS_LOTTO_NUM_COMMENT);
        return readSingleNumber(Console.readLine());
    }

    private static int readSingleNumber(String input) {
        return stringToInt(input);
    }

    private static List<Integer> readWinningNumbers(String input) {
        InputValidator.validateWinningNumberDelimiter(input);
        return transferToNumberList(new StringTokenizer(input, DELIMITER));
    }

    private static List<Integer> transferToNumberList(StringTokenizer tokenizer) {
        List<Integer> numbers = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            numbers.add(stringToInt(tokenizer.nextToken()));
        }
        return numbers;
    }

    public static int stringToInt(String input) {
        return InputValidator.validateParsingInteger(input);
    }
}
