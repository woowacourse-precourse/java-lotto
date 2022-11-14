package view;

import camp.nextstep.edu.missionutils.Console;
import model.BonusNumber;
import model.Lotto;
import model.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String TYPE_ERROR = "숫자를 입력해야 합니다.";

    private InputView() {

    }

    public static Money inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);

        return new Money(toInteger(Console.readLine()));
    }

    public static Lotto inputWinningNumber() {
        System.out.println(WINNING_NUMBER);
        List<Integer> numbers = toIntegerList(Console.readLine());
        return new Lotto(numbers);
    }

    public static BonusNumber inputBonusNumber() {
        System.out.println(BONUS_NUMBER);
        return new BonusNumber(toInteger(Console.readLine()));
    }

    private static int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }

    private static List<Integer> toIntegerList(String winningNumbers) {
        try {
            return Arrays.stream(winningNumbers.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TYPE_ERROR);
        }
    }
}    