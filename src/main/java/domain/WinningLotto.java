package domain;

import Util.InputUtils;
import lotto.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;


public class WinningLotto {
    public static final int ZERO = 0;
    private static final InputUtils utils = new InputUtils();
    private final Lotto winningNumber;
    private final int bonus;
    private final Map<Rank,Integer> winningCount;

    public WinningLotto() {
        this.winningNumber = utils.StringToWinningLottoNumber();
        this.bonus = utils.StringToBonus(this.winningNumber);
        this.winningCount = new HashMap<>(){{
            for (Rank key : Rank.values()) {
                put(key, ZERO);
            }
        }};
    }

    public Map<Rank,Integer> checking(List<Lotto> tickets){
        for (Lotto ticket : tickets) {
            boolean checkBonus = false;
            int winningNumberCount = getMyWinningNumberCount(ticket);
            if(ticket.getNumbers().contains(bonus)){
                checkBonus = true;
                winningNumberCount++;
            }
            addWinningCount(checkBonus, winningNumberCount);
        }
        return this.winningCount;
    }

    private void addWinningCount(boolean checkBonus, int winningNumberCount) {
        if(winningNumberCount >= Rank.FIFTH.getWinningCount()){
            Rank rank = getRank(checkBonus, winningNumberCount);
            this.winningCount.put(rank, this.winningCount.get(rank) + 1);
        }
    }

    private Rank getRank(boolean checkBonus, int winningNumberCount) {
        if (winningNumberCount >= Rank.FIRST.getWinningCount() && !checkBonus) {
            return Rank.FIRST;
        }
        if (winningNumberCount >= Rank.SECOND.getWinningCount()) {
            return Rank.SECOND;
        }
        if (winningNumberCount >= Rank.THIRD.getWinningCount()) {
            return Rank.THIRD;
        }
        if (winningNumberCount >= Rank.FOURTH.getWinningCount()) {
            return Rank.FOURTH;
        }
        return Rank.FIFTH;
    }

    private int getMyWinningNumberCount(Lotto ticket) {
        return (int) ticket.getNumbers()
                .stream()
                .filter(number -> winningNumber.getNumbers()
                        .stream()
                        .anyMatch(Predicate.isEqual(number))
                )
                .count();
    }

}