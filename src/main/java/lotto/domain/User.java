package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    private List<Lotto> lottos;

    public int buy() {
        String amount = Console.readLine();
        return Integer.parseInt(amount);
    }

}
