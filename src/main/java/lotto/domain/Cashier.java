package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Cashier {
    static final int LOTTO_PRICE = 1000;

    private int checkInputPrice(int userValue) {
        if (!isBiggerThanZero(userValue)) {
            System.out.println("[ERROR] 음수 값이 입력되었습니다.");
            throw new IllegalArgumentException();
        }
        if (!isDividedByThousand(userValue)) {
            System.out.println("[ERROR] 1,000원으로 나누어 떨어지지 않는 값이 입력되었습니다.");
            throw new IllegalArgumentException();
        }
        return userValue;
    }

    public int sellLotto(int userValue) {
        int lottoAmount = checkInputPrice(userValue) / 1000;
        System.out.println(lottoAmount + "개를 구매했습니다.");
        return lottoAmount;
    }

    private boolean isBiggerThanZero(int userValue) {
        return userValue >= 0;
    }

    private boolean isDividedByThousand(int userValue) {
        return userValue % 1000 == 0;
    }
}
