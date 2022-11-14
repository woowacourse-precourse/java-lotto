package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final Character DELIMITER = ',';
    private static final int DELIMITER_COUNT = 5;
    private static final String TYPE_WRONG = "[ERROR] 정확히 숫자(또는 액수)를 입력해주세요.";
    private static final String WINNING_NUMBERS_DELIMITER_ERROR = "[ERROR] 구분자로 , 를 사용해야합니다.";

    public static int inputAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        return convertToInt(Console.readLine());
    }

    private static int convertToInt(String input) {
        if (!input.matches("[1-9][0-9]*")) {
            throw new IllegalArgumentException(TYPE_WRONG);
        }

        return Integer.parseInt(input);
    }

    public static WinningNumbers inputWinningNumbersAndBonus() {
        Lotto lotto = inputWinningNumbers();

        int bonusNumber = inputBonusNumber();


        return new WinningNumbers(lotto, bonusNumber);
    }

    public static Lotto inputWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);
        String winningNumbers = Console.readLine();
        System.out.println();
        return new Lotto(convertToList(winningNumbers));
    }

    private static int inputBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();
        return bonusNumber;
    }

    private static List<Integer> convertToList(String inputWinningNumbers) {
        if (inputWinningNumbers.chars().filter(ch -> ch == ',').count() != DELIMITER_COUNT){
            throw new IllegalArgumentException(WINNING_NUMBERS_DELIMITER_ERROR);
        }

        try {
            return Arrays.stream(inputWinningNumbers.split(String.valueOf(DELIMITER)))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(TYPE_WRONG);
        }
    }
}
