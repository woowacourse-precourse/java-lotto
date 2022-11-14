package lotto;

import lotto.ENUMS.Rank;

import java.util.List;
import java.util.Map;

public class LotteryScratch {
    WinningNumber winningNumber;
    User user;
    List<Lotto> lottos;
    int count;

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
        List<Integer> original = lotto.getNumbers();
        Lotto winningLotto = winningNumber.getWinningLotto(); // 1, 2, 3, 4, 5, 6
        (lotto.getNumbers()).retainAll(winningLotto.getNumbers());
        int size = lotto.size();

        if (size == 6) {
            ranks.put(Rank.RANK1, ranks.get(Rank.RANK1) + 1);
        } else if (size == 5) {
            if (original.contains(winningNumber.getBonusNumber())) {
                ranks.put(Rank.RANK2, ranks.get(Rank.RANK2) + 1);
            } else {
                ranks.put(Rank.RANK3, ranks.get(Rank.RANK3) + 1);
            }
        } else if (size == 4) {
            ranks.put(Rank.RANK4, ranks.get(Rank.RANK4) + 1);
        } else if (size == 3) {
            ranks.put(Rank.RANK5, ranks.get(Rank.RANK5) + 1);
        }

        // 테스트 후에 ranks의 주소가 복사된게 아니었다면 삭제할 것
        user.setRanks(ranks);
    }
}
