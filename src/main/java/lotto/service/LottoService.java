package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;

import java.util.LinkedList;
import java.util.List;

public class LottoService {

    private LottoIssuer lottoIssuer;

    public LottoService(LottoIssuer lottoIssuer) {
        this.lottoIssuer = lottoIssuer;
    }

    public List<Lotto> purchaseLotto(int amount) {
        return lottoIssuer.generateAllLotto(amount);
    }

    public List<Rank> compareAllLottoAndWinningNumber(List<Lotto> lottos, WinningNumber winningNumber) {
        List<Rank> ranks = new LinkedList<>();
        for (Lotto lotto : lottos) {
            ranks.add(compareLottoAndWinningNumber(lotto, winningNumber));
        }

        return ranks;
    }

    public Rank compareLottoAndWinningNumber(Lotto lotto, WinningNumber winningNumber) {
        int count = lotto.compareLotto(winningNumber.getNumbers());
        boolean bonus = lotto.containBonus(winningNumber.getBonus());
        return Rank.calculateRank(count, bonus);
    }
}
