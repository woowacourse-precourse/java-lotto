package lotto.aspect;

import java.util.List;

public class Validator {

    public static void validateDivisiblePayment(final long payment, final int price) throws IllegalArgumentException {
        if (payment <= 0) {
            throw new IllegalArgumentException(String.format("[ERROR] Lotto는 개당 %d원 입니다. 금액이 부족합니다.", price));
        }

        if (payment % price != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] Lotto는 개당 %d원 입니다. 정확한 금액을 지불해주세요.", price));
        }
    }

    public static void validateBonusNumber(final List<Integer> numbers, final int bonusNumber) throws IllegalArgumentException {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] Lotto의 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
