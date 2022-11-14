package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    private List<Lotto> lottos;

    public int buy() {
        String amount = Console.readLine();
        Validator.validateAmount(amount);
        return Integer.parseInt(amount);
    }

    public void receive(List<Lotto> lottos) {
        this.lottos = lottos;
    }

}
