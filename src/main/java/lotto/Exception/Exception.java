package lotto.Exception;

import lotto.lotto.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {
    public static void isNum(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public static void isThousands(String input) {
        int money = Integer.parseInt(input);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력할 수 있습니다.");
        }
    }

    public static void checkSize(List<Integer> numberList) {
        if (numberList.size() != 6) {
            throw new IllegalArgumentException("6개의 수를 입력할 수 있습니다.");
        }
    }

    public static void checkDup(List<Integer> numberList) {
        Set dupChecker = new HashSet<>(numberList);
        if (dupChecker.size() != 6) {
            throw new IllegalArgumentException("중복되는 수를 입력할 수 없습니다.");
        }
    }

    public static void checkRange(List<Integer> numberList) {
        for (Integer number : numberList) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("1 ~ 45의 숫자만 입력할 수 있습니다.");
            }
        }
    }

    public static void checkRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("1 ~ 45의 숫자만 입력할 수 있습니다.");
        }
    }

    public static void checkBonusInLotto(Lotto lotto, int bonusNumber) {
        if(lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 로또 번호와 중복 됩니다.");
        }
    }
}
