package lotto.domain;

import java.util.List;

public class User {

    private final int inputMoney;
    private List<Lotto> lottos;

    public User(int money, List<Lotto> lottos) {
        this.inputMoney = money;
        this.lottos = lottos;
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void validateMoney(int inputMoney){
    }
}
