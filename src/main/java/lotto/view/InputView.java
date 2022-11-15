package lotto.view;

import static lotto.domain.ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String LOTTO_PURCHASE_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int lottoPurchaseMoney() {
        System.out.println(LOTTO_PURCHASE_MONEY_INPUT_MESSAGE);

        return convertStringToInteger(Console.readLine());
    }

    public static List<Integer> winningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);

        return convertStringToNumbers(Console.readLine());
    }

    public static int bonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);

        return convertStringToInteger(Console.readLine());
    }

    private static int convertStringToInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private static List<Integer> convertStringToNumbers(String winningNumbers) {
        try {
            String[] lottoNumbers = winningNumbers.split(",");
            return Arrays.stream(lottoNumbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }
}
