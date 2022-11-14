package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class LottoManager {

    public LottoManager() {
    }

    public int inputPrice() {
        return Integer.parseInt(Console.readLine());
    }
}
