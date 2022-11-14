package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(Money money) {
        lottos = new ArrayList<>();
        issueLottos(money);
    }

    private void issueLottos(Money money) {
        long count = money.countPurchasable(Lotto.PRICE);
        for (long number = 0; number < count; number++) {
            Lotto lotto = issueLotto();
            lottos.add(lotto);
        }
    }

    private Lotto issueLotto() {
        return new Lotto(LottoNumberGenerator.generateNumbers());
    }

    public long getCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public void rank(LottoResult lottoResult, Lotto winningLotto, BonusNumber bonusNumber) {
        for (Lotto lotto : lottos) {
            Ranking ranking = Ranking.rank(lotto, winningLotto, bonusNumber);
            lottoResult.add(ranking);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto.toString());
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
