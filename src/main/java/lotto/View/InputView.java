package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String MONEY_INPUT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_SENTENCE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_SENTENCE = "보너스 번호를 입력해 주세요.";
    private static final String CHAR_EXCEPTION_SENTENCE = " 입력에 문자열이 포함되었습니다.";
    private static final String BONUS_WITH_CHAR_EXCEPTION = " 숫자만 입력 해야 합니다.";

    public static void inputAmount() {
        System.out.println(MONEY_INPUT);
        Money.setInputMoney(readLine());    }

    public static void printWinningNumberInput() {
        System.out.println(WINNING_NUMBER_SENTENCE);
        new Lotto(stringToList(readLine()));
    }

    public static void printBonusNumberInput() {
        System.out.println(BONUS_NUMBER_SENTENCE);
        String temp = readLine();
        Lotto.setBonusNumber(stringToInt(temp));
    }

    public static List<Integer> stringToList(String winningNumber) {
        List<String> numbers = Arrays.asList(winningNumber.split(","));
        return convertTypeStringToInteger(numbers);
    }

    private static List<Integer> convertTypeStringToInteger(List<String> numbers) {
        try{
            return numbers.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + CHAR_EXCEPTION_SENTENCE);
        }
    }

    private static int stringToInt(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        }catch (NumberFormatException e) {

            throw new IllegalArgumentException(ERROR_MESSAGE + BONUS_WITH_CHAR_EXCEPTION);
        }
    }

}
