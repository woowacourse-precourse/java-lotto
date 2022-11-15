package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoNumber;
import lotto.domain.PurchaseMoney;

import java.util.*;

public class InputView {

    private static final String REGEX_ONLY_NUMBER = "^[0-9]*$";
    private static final String REGEX_WINNING_NUMBERS_FORMAT = "^([0-9]|(,[0-9]))*$";
    private static final String ERROR_WITH_TEXT_MESSAGE = "[ERROR] 숫자만 입력해야 합니다.";
    private static final String ERROR_WRONG_WINNING_NUMBERS_FORMAT_MESSAGE = "[ERROR] 올바른 형식을 입력해 주세요.";
    private static final String WINNING_NUMBERS_SPLIT_DELIMITER = ",";

    public static PurchaseMoney inputPurchaseMoney() {
        String input = Console.readLine();
        validatePositiveInputPurchaseMoney(input);
        return convertInputPurchaseMoney(input);
    }

    private static void validatePositiveInputPurchaseMoney(String input) {
        if (!input.matches(REGEX_ONLY_NUMBER)) {
            throw new IllegalArgumentException(ERROR_WITH_TEXT_MESSAGE);
        }
    }

    private static PurchaseMoney convertInputPurchaseMoney(String input) {
        int money = Integer.parseInt(input);
        return new PurchaseMoney(money);
    }

    public static List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        validatePositiveInputWinningNumbers(input);
        return convertInputWinningNumbers(input);
    }

    private static void validatePositiveInputWinningNumbers(String input) {
        if (!input.matches(REGEX_WINNING_NUMBERS_FORMAT)) {
            throw new IllegalArgumentException(ERROR_WRONG_WINNING_NUMBERS_FORMAT_MESSAGE);
        }
    }

    private static List<Integer> convertInputWinningNumbers(String input) {
        Set<Integer> winningLottoNumbers = new HashSet<>();
        String[] numbers = input.split(WINNING_NUMBERS_SPLIT_DELIMITER);

        Arrays.stream(numbers)
                .forEach(s -> {
                    int number = Integer.parseInt(s);
                    new LottoNumber(number);
                    winningLottoNumbers.add(number);
                });

        return new ArrayList<>(winningLottoNumbers);
    }

    public static int inputBonusNumber() {
        String input = Console.readLine();
        validatePositiveInputBonusNumber(input);
        return convertInputBonusNumber(input);
    }

    private static void validatePositiveInputBonusNumber(String input) {
        if (!input.matches(REGEX_ONLY_NUMBER)) {
            throw new IllegalArgumentException(ERROR_WITH_TEXT_MESSAGE);
        }
    }

    public static int convertInputBonusNumber(String input) {
        int bonusNumber = Integer.parseInt(input);
        new LottoNumber(bonusNumber);
        return bonusNumber;
    }
}
