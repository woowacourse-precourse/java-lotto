package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {
    private int pay;
    private List<Lotto> lottos;

    public int getPay() {
        return this.pay;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int buy() {
        String amount = Console.readLine();
        Validator.validateAmount(amount);
        this.pay = Integer.parseInt(amount);
        return this.pay;
    }

    public void receive(List<Lotto> lottos) {
        this.lottos = lottos;
    }

}
