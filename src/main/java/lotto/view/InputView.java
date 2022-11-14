package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String TYPE_ERROR = "[ERROR] 숫자만 입력 가능합니다.";

    private static final String INPUT_WINNING_LOTTO_AMOUNT = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL = "보너스 볼을 입력해 주세요.";

    private InputView() {
    }

    public static int inputAmount() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return convertToInt(Console.readLine());
    }

    private static int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }

    private static List<Integer> convertToIntegerList(String readLine) {
        try {
            List<Integer> numbers = new ArrayList<>();
            for (String s : readLine.split(",")) {
                numbers.add(Integer.parseInt(s));
            }
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }

    public static Lotto inputWinningNumber() {
        System.out.println(INPUT_WINNING_LOTTO_AMOUNT);
        return new Lotto(convertToIntegerList(Console.readLine()));
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_BALL);
        return convertToInt(Console.readLine());
    }
}
