package lotto.domain;

import static lotto.constant.WinningResult.RANK_1;
import static lotto.constant.WinningResult.RANK_2;
import static lotto.constant.WinningResult.RANK_3;
import static lotto.constant.WinningResult.RANK_4;
import static lotto.constant.WinningResult.RANK_5;
import static lotto.constant.WinningResult.RANK_NONE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import lotto.constant.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AccountTest {
    WinningCalculator winningCalculator = new WinningCalculator();
    Account account;

    @BeforeEach
    void initWinningCalculator() {
        winningCalculator.setWinningNumbers("1,2,3,4,5,6");
        winningCalculator.setBonusNumber("7");
        account = new Account(winningCalculator);
    }

    @DisplayName("당첨 결과 내역을 가져온다.")
    @Test
    void should_HaveWinningResultValues_When_GetKeySetOfResults() {
        // given
        Account account = new Account(winningCalculator);
        // when
        Set<WinningResult> keys = account.getWinningResultTable().keySet();
        // then
        assertThat(keys).contains(RANK_1, RANK_2, RANK_3, RANK_4, RANK_5, RANK_NONE);
    }

    @DisplayName("당첨 결과를 저장한다.")
    @Test
    void should_AddToResultTable_When_SaveResults() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))));
        lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 11, 12, 13))));
        // when
        account.saveResult(lottos);
        // then
        assertThat(account.getWinningResultTable().get(RANK_2)).isEqualTo(1);
        assertThat(account.getWinningResultTable().get(RANK_5)).isEqualTo(1);
    }

    @DisplayName("수익률을 가져온다.")
    @Nested
    class GetYield {

        @DisplayName("2등과 5등 당첨")
        @Test
        void should_GetYield_When_WinRank2AndRank5() {
            // given
            List<Lotto> lottos = new ArrayList<>();
            lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))));
            lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 11, 12, 13))));
            account.saveResult(lottos);
            // when
            String yield = account.getYield();
            // then
            assertThat(yield).isEqualTo("1,500,250.0");
        }

        @DisplayName("5등과 꽝 당첨")
        @Test
        void should_GetYield_When_WinRank5AndRankNone() {
            // given
            List<Lotto> lottos = new ArrayList<>();
            lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 11, 12, 13))));
            lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 11, 12, 13, 14))));
            account.saveResult(lottos);
            // when
            String yield = account.getYield();
            // then
            assertThat(yield).isEqualTo("250.0");
        }

        @DisplayName("5등 1개, 꽝 2개 당첨")
        @Test
        void should_GetYield_When_WinRank5And2RankNone() {
            // given
            List<Lotto> lottos = new ArrayList<>();
            lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 11, 12, 13))));
            lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 11, 12, 13, 14))));
            lottos.add(new Lotto(new ArrayList<>(Arrays.asList(11, 12, 13, 14, 5, 6))));
            account.saveResult(lottos);
            // when
            String yield = account.getYield();
            // then
            assertThat(yield).isEqualTo("166.7");
        }

        @DisplayName("꽝 2개 당첨")
        @Test
        void should_GetYield_When_Win2RankNone() {
            // given
            List<Lotto> lottos = new ArrayList<>();
            lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 11, 12, 13, 14))));
            lottos.add(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 21, 22, 23, 24))));
            account.saveResult(lottos);
            // when
            String yield = account.getYield();
            // then
            assertThat(yield).isEqualTo("0.0");
        }
    }
}