package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.Lotto;

public class ValidationUtility {

    private ValidationUtility() {}

    private static final List<Integer> lottoRange = IntStream.rangeClosed(1, 45).boxed()
        .collect(Collectors.toList());

    private static void assertError(String msg) {
        throw new IllegalArgumentException("[ERROR] " + msg);
    }

    protected static void validationTest(String input, int type) {
        if (type == Type.AMOUNT.getValue()) {
            isValidAmount(input);
        }

        if (type == Type.LOTTO.getValue()) {
            isValidLotto(input);
        }
        if (type == Type.BONUS.getValue()) {
            isValidBonus(input);
        }

    }

    private static void isValidAmount(String input) {
        if (!isDigits(input)) {
            assertError("숫자가 아닙니다 숫자를 입력해주세요");
        }
        int amount = Integer.parseInt(input);
        if (!isValidAmountRange(amount)){
            assertError("0이하의 숫자를 입력하셨습니다. 0이상을 입력해주세요");
        }
        if (!isMultipleOfThousand(amount)) {
            assertError("잘못된 금액입력입니다.");
        }
    }

    private static void isValidLotto(String input) {
        if (!isValidLottoInput(input)) {
            assertError("유효하지 않은 문자가 들어있습니다. ");
        }

        List<Integer> lotto = InputUtility.parseLotto(input);

        if (isOutOfIndex(lotto)) {
            assertError("숫자6개를 입력해주십시오");
        }
        if (!isValidLottoRangeALL(lotto)) {
            assertError("1-45 사이의 숫자를 입력해주세요");
        }
        if (!isDistinct(lotto)) {
            assertError("중복된 숫자가 있습니다.");
        }

    }

    public static void isValidBonus(Lotto lotto, int bonus) {
        if (!isDistinct(lotto, bonus)) {
            assertError("중복된 숫자입니다.");
        }
    }

    private static void isValidBonus(String input) {
        if (!isDigits(input)) {
            assertError("숫자가 아닙니다 숫자를 입력해주세요");
        }
        int bonus = Integer.parseInt(input);
        if (!isValidLottoRange(bonus)) {
            assertError("보너스는 1-45숫자 중 하나로 선택해주세요 ");
        }

    }

    private static boolean isValidLottoInput(String input) {
        return input.matches("[0-9,]+");
    }

    private static boolean isValidLottoRange(int input) {
        return lottoRange.contains(input);
    }

    private static boolean isValidLottoRangeALL(List<Integer> lotto) {
        return lotto.stream().allMatch(ValidationUtility::isValidLottoRange);

    }

    private static boolean isDistinct(List<Integer> lotto) {
        return lotto.size() == new HashSet<>(lotto).size();
    }

    private static boolean isDistinct(Lotto lotto, int bonus) {
        return !lotto.contains(bonus);
    }

    private static boolean isValidAmountRange(int amount) {
        return amount >0;
    }
    private static boolean isMultipleOfThousand(int amount) {
        return amount % 1000 == 0;
    }

    private static boolean isOutOfIndex(List<Integer> lotto) {
        return lotto.size() != 6;
    }

    private static boolean isDigits(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

}
