package lotto.domain;

import java.util.List;
import lotto.utils.CheckException;

public class User {
    private final int amount;
    private final List<Lotto> lottos;

    public User(int amount, List<Lotto> lottos) {
        CheckException.checkAmount(amount);
        this.amount = amount;
        this.lottos = lottos;
    }
}
