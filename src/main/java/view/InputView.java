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

    public static Money inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT);

        return new Money(Integer.parseInt(Console.readLine()));
    }

    public static Lotto inputWinningNumber() {
        System.out.println(WINNING_NUMBER);
        List<Integer> numbers = toIntegerList(Console.readLine());
        return new Lotto(numbers);
    }

    private static List<Integer> toIntegerList(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    public static BonusNumber inputBonusNumber() {
        System.out.println(BONUS_NUMBER);
        return new BonusNumber(Integer.parseInt(Console.readLine()));
    }
}