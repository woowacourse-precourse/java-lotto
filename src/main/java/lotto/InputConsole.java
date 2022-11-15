package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.ErrorMessage.*;
import static lotto.LottoMachine.LOTTO_PRICE;

public class InputConsole {

    public static final String PURCHASE_MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int purchaseMoney() {
        System.out.println(PURCHASE_MONEY_INPUT_MESSAGE);
        String input = Console.readLine();
        validateMoney(input);
        int money = Integer.parseInt(input);
        return money;
    }

    private static void validateMoney(String money) {
        if (!isDigit(money) || !isEnoughMoney(money) || !isOneThousandUnits(money)) {
            throw new IllegalArgumentException(INVALID_MONEY_ERROR.getMessage());
        }
    }

    private static boolean isEnoughMoney(String money) {
        if (Integer.parseInt(money) < LOTTO_PRICE) {
            return false;
        }
        return true;
    }

    private static boolean isOneThousandUnits(String money) {
        if (Integer.parseInt(money) % LOTTO_PRICE != 0) {
            return false;
        }
        return true;
    }

    private static boolean isDigit(String money) {
        boolean isNumeric =  money.matches("[+-]?\\d*(\\.\\d+)?");
        return isNumeric;
    }

    public static List<Integer> winningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
        String numbers = Console.readLine();
        validateWinningNumber(numbers);
        List<Integer> winningNumbers = splitNumber(numbers);
        return winningNumbers;
    }

    private static void validateWinningNumber(String numbers) {
        checkFormat(numbers);
        checkSize(numbers);
        checkDuplicate(numbers);
        checkNumberRange(numbers);
    }

    private static void checkFormat(String numbers) {
        if (!numbers.matches("([0-9]+,)*[0-9]+")) {
            throw new IllegalArgumentException(INVALID_LOTTO_FORM_ERROR.getMessage());
        }
    }

    private static void checkSize(String numbers) {
        String[] splitNumbers = numbers.split(",");
        if (splitNumbers.length != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private static void checkDuplicate(String numbers) {
        String[] splitNumbers = numbers.split(",");
        Set<String> deleteDuplicateNumbers = new HashSet<String>(Arrays.asList(splitNumbers));
        if (deleteDuplicateNumbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    private static void checkNumberRange(String numbers) {
        List<Integer> splitNumbers  = splitNumber(numbers);
        for (int i = 0; i < splitNumbers.size(); i++) {
            if (splitNumbers.get(i) < 1 || splitNumbers.get(i) > 45) {
                throw new IllegalArgumentException(INVALID_LOTTO_RANGE_ERROR.getMessage());
            }
        }
    }

    private static List<Integer> splitNumber(String numbers) {
        int[] splitNumbers = Stream.of(numbers.split(",")).mapToInt(Integer::parseInt).toArray();
        List<Integer> winningNumbers = Arrays.stream(splitNumbers).boxed().collect(Collectors.toList());
        return winningNumbers;
    }

    public static int bonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }
}
