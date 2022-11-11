package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputManager {
    private final InputValidator inputValidator = new InputValidator();
    public static final int LOTTO_PRICE = 1_000;

    public int inputPurchaseAmount() {
        System.out.println(ConsoleMessage.REQUEST_PURCHASE);
        String input = Console.readLine();
        inputValidator.validateInputPurchaseAmount(input);

        return Integer.parseInt(input) / LOTTO_PRICE;
    }

    public Lotto inputWinningNumbers() {
        System.out.println(ConsoleMessage.REQUEST_WINNING_NUMBERS);
        String input = Console.readLine();
        inputValidator.validateInputWinningNumbers(input);
        List<Integer> inputToList = Arrays.stream(input.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return new Lotto(inputToList);
    }

    public int inputBonusNumber() {
        throw new UnsupportedOperationException();
    }
}