package lotto.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckException {
    public static void checkAmount(int amount) throws IllegalArgumentException {
        try {
            if (amount <= 0 || (amount % 1000) > 0) {
                throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 숫자 형태로 입력해주세요.");
        }
    }

    public static void checkSixSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수가 6개가 아닙니다.");
        }
    }

    public static void checkDuplicatedNumber(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }
}
