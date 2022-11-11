package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private final static String PLAYER_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String WINNIG_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private final static String NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자를 입력해야 합니다.";

    public static int playerMoney() {
        System.out.println(PLAYER_MONEY_MESSAGE);

        return convertStringToInteger(Console.readLine());
    }

    public static Lotto winningNumbers() {
        System.out.println(WINNIG_NUMBER_MESSAGE);

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

    private static Lotto convertStringToLotto(String winningNumbers) {
        try {
            String[] lottoNumbers = winningNumbers.split(",");
            List<Integer> numbers = Arrays.stream(lottoNumbers)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            return new Lotto(numbers);
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_FORMAT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
