package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WinningResult {
    private static final int FIRST_PLACE = 4;
    private static final int SECOND_PLACE = 3;
    private static final int THIRD_PLACE = 2;
    private static final int FOURTH_PLACE = 1;
    private static final int FIFTH_PLACE = 0;


    private User user;
    private WinningNumber winningNumber;
    private double yield;
    private List<Integer> winningResult;

    public WinningResult(User user, WinningNumber winningNumber) {
        this.user = user;
        this.winningNumber = winningNumber;
        this.winningResult = new ArrayList<>(Collections.nCopies(5, 0));
        this.yield = 0;
    }


    public double getYield() {
        return yield;
    }

    public List<Integer> getWinningResult() {
        return winningResult;
    }

    public void makeWinningResult() {
        List<Lotto> lottos = user.getLotto();

        for (Lotto lotto : lottos) {
            addWinningResult(lotto);
        }
        calculateYield();
    }

    public void addWinningResult(Lotto lotto) {
        if (lotto.countMatchNumbers(winningNumber) == LottoPlace.FIFTH.getMatchNumbers()) {
            winningResult.set(FIFTH_PLACE, winningResult.get(FIFTH_PLACE) + 1);
        }

        if (lotto.countMatchNumbers(winningNumber) == LottoPlace.FOURTH.getMatchNumbers()) {
            winningResult.set(FOURTH_PLACE, winningResult.get(FOURTH_PLACE) + 1);
        }

        if (lotto.countMatchNumbers(winningNumber) == LottoPlace.THIRD.getMatchNumbers() && !lotto.haveBonusNumber(winningNumber)) {
            winningResult.set(THIRD_PLACE, winningResult.get(THIRD_PLACE) + 1);
        }

        if (lotto.countMatchNumbers(winningNumber) == LottoPlace.SECOND.getMatchNumbers() && lotto.haveBonusNumber(winningNumber)) {
            winningResult.set(SECOND_PLACE, winningResult.get(SECOND_PLACE) + 1);
        }

        if (lotto.countMatchNumbers(winningNumber) == LottoPlace.FIRST.getMatchNumbers()) {
            winningResult.set(FIRST_PLACE, winningResult.get(FIRST_PLACE) + 1);
        }
    }

    public void calculateYield() {
        long money = user.getMoney();
        long profit = 0;
        for (Integer place = 0; place < winningResult.size(); place++) {
            profit += addWinningLottoMoney(place);
        }
        this.yield = roundYield(profit / (double) money * 100);
    }

    public Integer addWinningLottoMoney(Integer place) {
        return winningResult.get(place) * LottoPlace.values()[place].getWinMoney();
    }

    public double roundYield(double yield) {
        return Math.round(yield * 10) / 10.0;
    }
}
