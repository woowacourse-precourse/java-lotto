package lotto.controller;

import java.util.List;
import lotto.abstraction.BuildHistory;
import lotto.domain.LottoTicket;
import lotto.domain.WinningAmount;
import lotto.shell.Shell;

// 결과 생성
public class HistoryBuilder implements BuildHistory {

    private int bonusNumber;
    private List<Integer> lottoNumberList;
    private double yield;
    private int winningAmount;
    private int matchCount;
    private String matchHistory;
    private String yieldHistory;

    public HistoryBuilder() {
        this.matchCount = new Matcher().countMatcher();
        this.winningAmount = new WinningAmount().setWinningAmount();
        this.bonusNumber = new Shell().addBonusNumber();
//        this.lottoNumberList = new LottoTicket().publishLottoTicket();
        this.matchHistory = buildMatchHistory();
        this.yieldHistory = buildYieldHistory();
        this.yield = (winningAmount / new Shell().addAmount()) * 100;
    }



    public boolean winningBonus() {

        return buildMatchCount() == 5 && buildLottoNumberList().contains(buildBonusNumber());
    }


    @Override
    public int buildBonusNumber() {
        return bonusNumber;
    }

    @Override
    public List<Integer> buildLottoNumberList() {
        return lottoNumberList;
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
