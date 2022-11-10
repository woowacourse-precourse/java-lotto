package lotto.config;

import java.util.Set;

public class InputConfig {
    private static final String ERROR_MESSAGE = "[ERROR]";


    //
//    private void checkCorrectInput() {
//
//    }
//
    void isBonusNumberInLotto(Set<Integer> lotto, int bonus) {
        if(lotto.contains(bonus)) {
            throw new IllegalArgumentException();
        }
    }

    private void hasCorrectSize(Set<Integer> set) {
        if(set.size()!=6) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void isInCorrectRange(int value) {
        if (!(1 <= value && value <= 45)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    // 구입 금액 입력
    public static void checkPurchaseInput(String input) {
        long value = isLongType(input);
        isMoreThanZero(value);
        isDividedByThousand(value);
    }

    private static long isLongType(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void isMoreThanZero(long value) {
        if (value < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void isDividedByThousand(long value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

}


/*
[x] 1000원으로 나누어 떨어지지 않았을 때
- [x] **0원일 경우는?** (나누어 떨어지니 허용?)
- 당첨 번호 관련
- [x] 6개 미만 또는 초과하는 번호를 입력했을 때
- [x] 1 ~ 45 범위를 벗어나는 번호를 입력했을 때
- [ ] 쉼표(,) 구분되지 않는 입력이 주어졌을 때
- [x] 당첨 번호에 중복되는 숫자가 존재할 때  set --> set의 size가 6이 안됨
- [x] 보너스 번호가 당첨 번호와 중복될 때 set
 */