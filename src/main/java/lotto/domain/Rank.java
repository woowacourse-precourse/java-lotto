package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.view.Constants.*;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private final int countOfMatch;
    private final boolean acceptBonus;
    private final int winningMoney;

    Rank(int countOfMatch, boolean acceptBonus, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.acceptBonus = acceptBonus;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() { return countOfMatch; }
    public boolean getAcceptBonus() { return acceptBonus; }
    public int getWinningMoney() { return winningMoney; }

    public static List<Integer> getCountOfMatchValues() {
        return Stream.of(Rank.values())
                .map(Rank::getCountOfMatch)
                .collect(Collectors.toList());
    }

    public static List<Integer> getWinningMoneyValues() {
        return Stream.of(Rank.values())
                .map(Rank::getWinningMoney)
                .collect(Collectors.toList());
    }
}
