package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Store {

    public static void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public static int countLines(int money) {
        validate(money);
        return money / 1000;
    }

}
