package lotto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int amount;
    private List<Lotto> lotto = new ArrayList<>();
    private int numberOfLotto;

    public User(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나누어떨어지는 수여야 합니다.");
        }
    }

    public void buyLotto(LottoSeller lottoSeller) {
        lotto = lottoSeller.sellTo(amount);
        numberOfLotto = lotto.size();
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }
}
