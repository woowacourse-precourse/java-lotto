package lotto.domain;

import java.util.List;
import lotto.utils.CheckException;

public class User {
    private final int amount;
    private final List<Lotto> lottoNumbers;

    public User(int amount, List<Lotto> lottoNumbers) {
        CheckException.checkAmount(amount);
        this.amount = amount;
        this.lottoNumbers = lottoNumbers;
    }
}
