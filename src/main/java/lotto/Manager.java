package lotto;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    User user = new User();
    Map<Rank,Integer> winningBoard = new HashMap<>();
    Compare compareLotto = new Compare();
    private double rateOfReturns = 0.d;


    public void compareLotto() {
        for(Lotto lotto : user.getLottos()) {
            Rank rank = compareLotto.compareLotto(lotto);
            winningBoard.put(rank, (winningBoard.getOrDefault(rank,0))+1);
        }
    }

    public void calculatorReturns() {
        double rate = 0.d;

        for(Map.Entry<Rank,Integer> entry : winningBoard.entrySet()) {
            Rank rank = entry.getKey();
            if(rank.equals(Rank.RANK_NONE)) {
                continue;
            }

            if(entry.getValue() > 0) {
                rate += rank.getReward();
            }
        }

        this.rateOfReturns = rate / user.getAmount() * 100.d;

    }

    public void start() {
        user.inputAmount();
        user.buyLotto();
        UserOutput.printLottoCount(user.getAmount());
        UserOutput.printLottoList(user.getLottos());
        compareLotto.inputTargetNumbers();
        compareLotto.inputBonusNumber();
        compareLotto();
        UserOutput.printWinningStats(winningBoard);
        calculatorReturns();
        UserOutput.printWinningRate(rateOfReturns);
    }
}
