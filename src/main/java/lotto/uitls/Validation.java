package lotto.uitls;

import static lotto.uitls.Converter.convertToIntegerList;

import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    private static final int LOTTO_PRICE = 1_000;
    private static final int COUNT_OF_NUMBERS_IN_LOTTO = 1_000;
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;

    public static void validateLottoPurchaseAmount(String purchaseAmount) {
        if (hasNonDigitCharacter(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액에는 숫자 외의 문자가 포함될 수 없습니다.");
        }
        if (!isDividedByLottoPrice(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 로또는 1,000원 단위로만 구매할 수 있습니다.");
        }
        if (!isPossiblePrice(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 0원 이하의 금액은 입력할 수 없습니다.");
        }
    }

    public static void validateLottoWinningNumber(String winningNumber) {
        if (!hasOnlyDigitAndComma(winningNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자를 쉼표로 구분하여 입력해야 합니다.");
        }
        if (!hasCorrectNumberOfNumbers(winningNumber)) {
            throw new IllegalArgumentException("[ERROR] 총 6개의 당첨 번호를 입력해야 합니다.");
        }

        List<Integer> winningNumbers = convertToIntegerList(winningNumber);
        if (hasDuplicatedNumber(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 중복되는 당첨 번호가 존재합니다.");
        }
        if (!isCorrectRange(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static boolean hasNonDigitCharacter(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }

    public static boolean isDividedByLottoPrice(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) % LOTTO_PRICE == 0;
    }

    public static boolean isPossiblePrice(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) > 0;
    }

    public static boolean hasOnlyDigitAndComma(String input) {
        String digitAndComma = "^([0-9,])*$";
        return Pattern.matches(digitAndComma, input);
    }

    public static boolean hasCorrectNumberOfNumbers(String input) {
        String[] lottoNumbers = input.split(",");
        return lottoNumbers.length == COUNT_OF_NUMBERS_IN_LOTTO;
    }

    public static boolean hasDuplicatedNumber(List<Integer> lottoNnumbers) {
        return lottoNnumbers.size() != lottoNnumbers.stream().distinct().count();
    }

    public static boolean isCorrectRange(List<Integer> lottoNumbers) {
        return lottoNumbers.stream().anyMatch(number -> number > LOTTO_MAX || number < LOTTO_MIN);
    }
}
