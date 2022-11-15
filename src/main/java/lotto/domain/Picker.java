package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.constant.Rank;

public class Picker {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public Picker(Lotto winningLotto, LottoNumber bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 겹치면 안됩니다");
        }
    }

    public List<Rank> pick(List<Lotto> lottos) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            ranks.add(pick(lotto));
        }
        return ranks;
    }

    private Rank pick(Lotto lotto) {
        int matchCount = lotto.countMatchesWith(winningLotto);
        boolean hasBonusNumber = lotto.contains(bonusNumber);
        return Rank.from(matchCount, hasBonusNumber);
    }
}
