package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Picker {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public Picker(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Rank> pick(List<Lotto> lottos) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Rank rank = Rank.from(lotto.countMatchesWith(winningLotto), lotto.contains(bonusNumber));
            ranks.add(rank);
        }
        return ranks;
    }
}
