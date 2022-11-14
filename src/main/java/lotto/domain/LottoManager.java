package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class LottoManager {

    public LottoManager() {
    }

    public int inputPrice() {
        return Integer.parseInt(Console.readLine());
    }

    public int setCount(int price) {
        return price / 1000;
    }
}
