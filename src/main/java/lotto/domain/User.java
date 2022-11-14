package lotto.domain;

import java.util.List;

public class User {
    private final Integer numberOfPurchase;
    private final Integer amount;
    private final List<Lotto> lottoNumbers;

    public User(Integer numberOfPurchase, Integer amount, List<Lotto> lottoNumbers) {
        this.numberOfPurchase = numberOfPurchase;
        this.amount = amount;
        this.lottoNumbers = lottoNumbers;
    }
}
