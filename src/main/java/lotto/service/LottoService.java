package lotto.service;

import lotto.domain.*;

import java.util.LinkedList;
import java.util.List;

public class LottoService {

    private LottoIssuer lottoIssuer;

    public LottoService(LottoIssuer lottoIssuer) {
        this.lottoIssuer = lottoIssuer;
    }

    public List<Lotto> purchaseLotto(Amounts amount) {
        return lottoIssuer.generateAllLotto(amount);
    }

    public WinStatistics compareAllLottoAndWinningNumber(Amounts amounts, List<Lotto> lottos, WinningNumber winningNumber) {
        List<Rank> ranks = new LinkedList<>();
        for (Lotto lotto : lottos) {
            ranks.add(compareLottoAndWinningNumber(lotto, winningNumber));
        }

        return WinStatistics.calculateWinningAmount(amounts,ranks);
    }

    public Rank compareLottoAndWinningNumber(Lotto lotto, WinningNumber winningNumber) {
        int count = lotto.compareLotto(winningNumber.getNumbers());
        boolean bonus = lotto.containBonus(winningNumber.getBonus());
        return Rank.calculateRank(count, bonus);
    }
}
