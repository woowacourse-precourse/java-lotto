package lotto;

import lotto.ENUMS.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LotteryScratch {
    WinningNumber winningNumber;
    User user;
    List<Lotto> lottos;

    public LotteryScratch(WinningNumber winningNumber, List<Lotto> lottos, User user) {
        this.user = user;
        this.winningNumber = winningNumber;
        this.lottos = lottos;
        compareLotto();
        settleEarningRate();
    }

    public void settleEarningRate() {
        user.settleEarningsRate();
    }

    public void compareLotto() {
        for (Lotto lotto : lottos) { // 1, 3, 5, 14, 22, 45
            recordLotteryResult(lotto);
        }
    }

    public void recordLotteryResult(Lotto lotto) {
        Map<Rank, Integer> ranks = user.getRanks();
        List<Integer> lottoNumbers = lotto.getNumbers();
        List<Integer> temp = new ArrayList<>(winningNumber.getWinningLotto().getNumbers());
        temp.retainAll(lottoNumbers);
        int size = temp.size();
        Rank r = judgeRank(lotto, size);
        ranks.put(r, ranks.get(r) + 1);
    }

    public Rank judgeRank(Lotto lotto, int size) {
        if (size == 6) {
            return Rank.RANK1;
        } else if (size == 5) {
            if (lotto.contains(winningNumber.getBonusNumber())) {
                return Rank.RANK2;
            }
            return Rank.RANK3;
        } else if (size == 4) {
            return Rank.RANK4;
        } else if (size == 3) {
            return Rank.RANK5;
        }
        return Rank.RANK_NONE;
    }
}
