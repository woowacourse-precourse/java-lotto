package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoScanner {
    private static final String READ_MONEY_PROMPT = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String DELIMITER = ",";
    public static final String REQUIRE_NUMERIC_VALUE = "숫자를 입력해주세요.";
    public static final String SHOULD_BE_DIVIDED_INTO_PRICE = "구입금액은 가격으로 나누어 떨어져야합니다.";
    public static final String INVALID_RANGE_OF_PURCHASE_AMOUNT = "구입금액은 가격 이상이어야합니다.";
    public static final String DO_NOT_INCLUDE_INVALID_CHARACTER = "유효하지 않은 문자가 있습니다.";

    public static int readPurchaseAmount() {
        System.out.println(READ_MONEY_PROMPT);
        int purchaseAmount = readLineAsInteger();
        validate(purchaseAmount);
        return purchaseAmount;
    }

    private static void validate(int purchaseAmount) {
        validateRangeOf(purchaseAmount);
        validateDivideIntoPrice(purchaseAmount);
    }

    private static void validateDivideIntoPrice(int purchaseAmount) {
        if (divideIntoPrice(purchaseAmount)) {
            throw new IllegalArgumentException(SHOULD_BE_DIVIDED_INTO_PRICE);
        }
    }

    private static boolean divideIntoPrice(int purchaseAmount) {
        return (purchaseAmount % LottoSystem.LOTTO_PRICE) != 0;
    }

    private static void validateRangeOf(int purchaseAmount) {
        if (outOfRange(purchaseAmount)) {
            throw new IllegalArgumentException(INVALID_RANGE_OF_PURCHASE_AMOUNT);
        }
    }

    private static boolean outOfRange(int purchaseAmount) {
        return purchaseAmount < LottoSystem.MIN_PURCHASE_AMOUNT || purchaseAmount > LottoSystem.MAX_PURCHASE_AMOUNT;
    }

    private static int readLineAsInteger() {
        Long PurchaseAmountInput = readPurchaseAmountAsNumber();
        return convertToInteger(PurchaseAmountInput);
    }

    private static int convertToInteger(Long input) {
        int purchaseAmount;
        try {
            purchaseAmount = Math.toIntExact(input);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(INVALID_RANGE_OF_PURCHASE_AMOUNT);
        }
        return purchaseAmount;
    }

    private static Long readPurchaseAmountAsNumber() {
        Long input;
        try {
            input = Long.parseLong(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(REQUIRE_NUMERIC_VALUE);
        }
        return input;
    }

    public static WinningNumber readWinningNumber() {
        List<Integer> numbers = readSixNumbers();
        int bonusNumber = readBonusNumber();
        return new WinningNumber(numbers, bonusNumber);
    }

    private static List<Integer> readSixNumbers() {
        System.out.println(READ_WINNING_NUMBER_PROMPT);
        String[] numbersSplitByDelimiter = Console.readLine().split(DELIMITER);

        List<Integer> parsedNumbers = parseNumberOrThrow(numbersSplitByDelimiter);
        return parsedNumbers;
    }

    private static List<Integer> parseNumberOrThrow(String[] numbersSplitByDelimiter) {
        return Arrays.stream(numbersSplitByDelimiter)
                .mapToInt(LottoScanner::parseIntOrThrowException)
                .boxed().collect(Collectors.toList());
    }

    private static Integer parseIntOrThrowException(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DO_NOT_INCLUDE_NUMERIC_VALUE);
        }
    }


    private static int readBonusNumber() {
        System.out.println(READ_BONUS_NUMBER_PROMPT);
        return Integer.parseInt(Console.readLine());
    }

}