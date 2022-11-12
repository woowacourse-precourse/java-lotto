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
    private static final String DELIMITER = ",";
    private static final String TYPE_WRONG = "[ERROR] 숫자만 입력해주세요.";
    private static final String WINNING_NUMBERS_DELIMITER_ERROR = "[ERROR] 구분자로 , 를 사용해야합니다.";

    public static int inputAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        return convertToInt(Console.readLine());
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e){
            throw new IllegalArgumentException(TYPE_WRONG);
        }
    }

    public static WinningNumbers inputWinningNumbersAndBonus() {

        Lotto lotto = inputWinningNumbers();

        int bonusNumber = inputBonusNumber();


        return new WinningNumbers(lotto, bonusNumber);
    }

    public static Lotto inputWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);
        String winningNumbers = Console.readLine();

        return new Lotto(convertToList(winningNumbers));
    }

    private static int inputBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
        int bonusNumber = Integer.parseInt(Console.readLine());

        return bonusNumber;
    }

    private static List<Integer> convertToList(String inputWinningNumbers) {
        try {
            return Arrays.stream(inputWinningNumbers.split(DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(WINNING_NUMBERS_DELIMITER_ERROR);
        }
    }
}
