package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE;

public class InputView {

    private static final String PLAYER_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int playerMoney() {
        System.out.println(PLAYER_MONEY_MESSAGE);

        return convertStringToInteger(Console.readLine());
    }

    public static List<Integer> winningNumbers() {
        System.out.println(WINNING_NUMBER_MESSAGE);

        return convertStringToLotto(Console.readLine());
    }

    public static int bonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);

        return convertStringToInteger(Console.readLine());
    }

    private static int convertStringToInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> convertStringToLotto(String winningNumbers) {
        try {
            String[] lottoNumbers = winningNumbers.split(",");
            return Arrays.stream(lottoNumbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
