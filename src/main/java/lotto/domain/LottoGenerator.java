package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    static final int LOTTO_SIZE = 6;
    static final int LOTTO_PRICE = 1000;

    private final int numberOfLotto;
    private final List<Lotto> lottos;

    public LottoGenerator(int purchaseAmount) {
        numberOfLotto = purchaseAmount / LOTTO_PRICE;
        lottos = generate(numberOfLotto);
    }

    private List<Lotto> generate(int numberOfLotto){
        return Collections.EMPTY_LIST;
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
