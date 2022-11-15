package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public long getCount() {
        return lottos.size();
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
