package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseMoney;

import java.util.*;

public class InputView {

    private static final String WINNING_NUMBERS_SPLIT_DELIMITER = ",";

    public static PurchaseMoney inputPurchaseMoney() {
        String input = Console.readLine();
        return convertInputPurchaseMoney(input);
    }

    private static PurchaseMoney convertInputPurchaseMoney(String input) {
        int money = Integer.parseInt(input);
        return new PurchaseMoney(money);
    }

    public static List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        return convertInputWinningNumbers(input);
    }

    private static List<Integer> convertInputWinningNumbers(String input) {
        Set<Integer> winningLottoNumbers = new HashSet<>();
        String[] numbers = input.split(WINNING_NUMBERS_SPLIT_DELIMITER);

        Arrays.stream(numbers)
                .forEach(s -> {
                    int number = Integer.parseInt(s);
                    winningLottoNumbers.add(number);
                });

        return new ArrayList<>(winningLottoNumbers);
    }

    public static int inputBonusNumber() {
        String input = Console.readLine();
        return convertInputBonusNumber(input);
    }

    public static int convertInputBonusNumber(String input) {
        return Integer.parseInt(input);
    }
}
