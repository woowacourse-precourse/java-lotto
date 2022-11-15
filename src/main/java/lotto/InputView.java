package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.utils.Messages.ERROR_DIGIT_MESSAGE;
import static lotto.utils.Messages.ERROR_PATTERN_MESSAGE;
import static lotto.utils.Messages.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.utils.Messages.INPUT_PURCHASE_MESSAGE;
import static lotto.utils.Messages.INPUT_WIN_LOTTO_MESSAGE;

public class InputView {

    private static final String WIN_LOTTO_NUMBER_REGEX = "^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$";

    public static int inputPurchase() {
        System.out.println(INPUT_PURCHASE_MESSAGE);
        String purchase = Console.readLine();
        IsInteger(purchase);
        return Integer.parseInt(purchase);
    }

    public static List<Integer> inputWinLotto() {
        System.out.println(INPUT_WIN_LOTTO_MESSAGE);
        String inputWinLotto = Console.readLine();
        isCorrectPattern(inputWinLotto);
        List<Integer> WinLotto = Arrays.stream(inputWinLotto.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return WinLotto;
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bonus = Console.readLine();
        IsInteger(bonus);
        return Integer.parseInt(bonus);
    }

    private static void IsInteger(String purchase) {
        for (int index = 0; index < purchase.length(); index++) {

            if (!Character.isDigit(purchase.charAt(index))) {
                System.out.println(ERROR_DIGIT_MESSAGE);
                throw new IllegalArgumentException();
            }
        }
    }

    private static void isCorrectPattern(String inputWinLotto) {
        if (!Pattern.matches(WIN_LOTTO_NUMBER_REGEX, inputWinLotto)) {
            throw new IllegalArgumentException(ERROR_PATTERN_MESSAGE);
        }
    }
}
