package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    public static void validateMoney(int money) {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 반드시 1,000원 단위여야 합니다.");
        }
    }

    public static void validateLottoNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 갯수는 반드시 6개여야 합니다.");
        }

        if (numbers.get(0) < 1 || numbers.get(numbers.size() - 1) > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 반드시 1과 45 사이의 숫자여야합니다.");
        }

        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    public static void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if(numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 발행번호와 일치하지 않아야 합니다.");
        }
    }
}
