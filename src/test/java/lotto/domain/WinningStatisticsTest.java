package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningStatisticsTest {

    @Test
    @DisplayName("당첨 내역 출력")
    void getWinningStatisticsMap() {
        List<Ranking> rankingList = new ArrayList<>();
        rankingList.add(Ranking.FIFTH);
        rankingList.add(Ranking.SIXTH);
        rankingList.add(Ranking.SIXTH);
        rankingList.add(Ranking.SIXTH);
        rankingList.add(Ranking.SIXTH);
        rankingList.add(Ranking.SIXTH);
        rankingList.add(Ranking.SIXTH);
        rankingList.add(Ranking.SIXTH);
        WinningStatistics winningStatistics = new WinningStatistics(rankingList);
        Assertions.assertThat(winningStatistics.getWinningStatisticsMap().get(Ranking.FIFTH)).isEqualTo(1);
        Assertions.assertThat(winningStatistics.getWinningStatisticsMap().get(Ranking.SIXTH)).isEqualTo(7);
    }


    @Test
    @DisplayName("수익률 출력")
    void calculateProfitRate() {
        List<Ranking> rankingList = new ArrayList<>();
        rankingList.add(Ranking.FIFTH);
        rankingList.add(Ranking.SIXTH);
        rankingList.add(Ranking.SIXTH);
        rankingList.add(Ranking.SIXTH);
        rankingList.add(Ranking.SIXTH);
        rankingList.add(Ranking.SIXTH);
        rankingList.add(Ranking.SIXTH);
        rankingList.add(Ranking.SIXTH);
        WinningStatistics winningStatistics = new WinningStatistics(rankingList);
        double profitRate = winningStatistics.calculateProfitRate(8000);
        Assertions.assertThat(Math.round(profitRate*100)/100.0).isEqualTo(62.5);
    }
}