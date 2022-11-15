package lotto.controller;


import java.util.List;
import java.util.Map;
import lotto.abstraction.BuildHistory;
import lotto.domain.WinningAmount;
import lotto.shell.Amount;
import lotto.shell.BonusNumber;

// 결과 생성
public class HistoryBuilder implements BuildHistory {


    private final int matchCount;
    private final int winningAmount;
    private final double yield;
    private String matchHistory;
    private String yieldHistory;
    private final int bonusNumber;

    public HistoryBuilder() {

        this.matchCount = new Matcher().countMatcher();
        this.winningAmount = new WinningAmount().setWinningAmount();
        this.bonusNumber = new BonusNumber().buildBonusNumber();
        this.matchHistory = buildMatchHistory();
        this.yieldHistory = buildYieldHistory();
        this.yield = (winningAmount / new Amount().buildAmount()) * 100;

    }


    public boolean winningBonus() {

        return buildMatchCount() == 5 && new MatchBuilder().
                buildLottoNumbers.containsValue(buildBonusNumber());
    }


    @Override
    public int buildBonusNumber() {
        return bonusNumber;
    }

    @Override
    public Map<Integer, List<Integer>> buildLottoNumbers() {
        return null;
    }


    @Override
    public int buildMatchCount() {
        return matchCount;
    }

    @Override
    public String buildMatchHistory() {
        matchHistory = String.format("%d 일치, 보너스 볼 일치(%d 원) - {무엇?}개", matchCount, winningAmount);

        if (winningBonus()) {
            matchHistory = String.format("%d 일치, 보너스 볼 일치(%d 원) - {무엇?}개", matchCount, winningAmount);
        }

        return matchHistory;
    }

    @Override
    public String buildYieldHistory() {
        yieldHistory = String.format("총 수익률은 %.1f원 입니다.", yield);
        return yieldHistory;
    }
}
