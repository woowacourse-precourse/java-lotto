package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Store {

    public static void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 천원 단위로 입력해야 합니다.");
        }
    }

    public static int countLines(int money) {
        validate(money);
        return money / 1000;
    }

    public static List<Integer> makeNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

}
