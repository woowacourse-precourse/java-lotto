package lotto.uitls;

import java.util.List;

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

    public static boolean hasNonDigitCharacter(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    public static boolean isDividedByLottoPrice(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) % LOTTO_PRICE == 0;
    }

    public static boolean isPossiblePrice(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) > 0;
    }

    public static boolean isSeperatedByComma(String input) {
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
