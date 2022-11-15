package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    public static void validateIsNumber(String each) {
        try {
            Integer.parseInt(each);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 입력이 숫자가 아닙니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateRange(int number) {
        if (number < LottoConst.START_RANGE || LottoConst.END_RANGE < number) {
            System.out.println("[ERROR] 범위를 벗어난 숫자입니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateInputLength(List<Integer> numbers) {
        if (numbers.size() != LottoConst.LOTTO_LENGTH) {
            System.out.println("[ERROR] 입력된 숫자가 너무 많습니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> deletedDuplicate = new HashSet<>(numbers);
        if (deletedDuplicate.size() != numbers.size()) {
            System.out.println("[ERROR] 중복된 숫자가 있습니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice % LottoConst.PURCHASE_UNIT != 0) {
            System.out.println("[ERROR] 구매할 수 없는 금액입니다.");
            throw new IllegalArgumentException();
        }
    }
}
