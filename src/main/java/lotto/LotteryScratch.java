package lotto;

import lotto.ENUMS.Rank;

import java.util.List;
import java.util.Map;

public class LotteryScratch {
    WinningNumber winningNumber;
    User user;
    List<Lotto> lottos;
    int count;

    public LotteryScratch(WinningNumber winningNumber, LotteryDrawMachine lotteryDrawMachine) {
        this.winningNumber = winningNumber;
        user = lotteryDrawMachine.getUser();
        lottos = lotteryDrawMachine.getLottos();
        compareLotto();
    }

    public void compareLotto() {
        Lotto winningLotto = winningNumber.getWinningLotto(); // 1, 2, 3, 4, 5, 6
        for (Lotto lotto : lottos) { // 1, 3, 5, 14, 22, 45
            lotto.retainAll(winningLotto);
            recordLotteryResult(lotto);
        }
    }

    public void recordLotteryResult(Lotto lotto) {
        int size = lotto.size();
        Map<Rank, Integer> ranks = user.getRanks();
        if (size == 6) {
            ranks.put()
        } else if (size == 5) {

        } else if (size == 4) {

        } else if (size == 3) {

        }
    }
}
