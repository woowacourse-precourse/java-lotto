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

    @BeforeEach
    void initWinningCalculator() {
        winningCalculator.setWinningNumbers("1,2,3,4,5,6");
        winningCalculator.setBonusNumber("7");
    }

    @DisplayName("당첨 결과 내역을 가져온다.")
    @Test
    void shouldHaveWinningResultValues_WhenGetKeySetOfResults() {
        // given
        Account account = new Account(winningCalculator);
        // when
        Set<WinningResult> keys = account.getResults().keySet();
        // then
        assertThat(keys).contains(
                RANK_1,
                RANK_2,
                RANK_3,
                RANK_4,
                RANK_5,
                RANK_NONE
        );
    }

    @DisplayName("당첨 결과를 저장한다.")
    @Test
    void shouldBeAdded_WhenSaveResults() {
        // given
        Account account = new Account(winningCalculator);
        List<Lotto> lottos = new ArrayList<>();
        Lotto lottoRank2 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
        Lotto lottoRank5 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 11, 12, 13)));
        lottos.add(lottoRank2);
        lottos.add(lottoRank5);
        // when
        account.saveResult(lottos);
        // then
        assertThat(account.getResults().get(RANK_2)).isEqualTo(1);
        assertThat(account.getResults().get(RANK_5)).isEqualTo(1);
    }

    @DisplayName("수익률을 가져온다.")
    @Nested
    class ShouldGetYield {
        @DisplayName("2등과 5등 당첨")
        @Test
        void winRank2AndRank5() {
            // given
            Account account = new Account(winningCalculator);
            List<Lotto> lottos = new ArrayList<>();
            Lotto lottoRank2 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
            Lotto lottoRank5 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 11, 12, 13)));
            lottos.add(lottoRank2);
            lottos.add(lottoRank5);
            // when
            account.saveResult(lottos);
            // then
            assertThat(account.getYield()).isEqualTo("1,500,250.0");
        }

        @DisplayName("5등과 꽝 당첨")
        @Test
        void winRank5AndRankNone() {
            // given
            Account account = new Account(winningCalculator);
            List<Lotto> lottos = new ArrayList<>();
            Lotto lottoRank5 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 11, 12, 13)));
            Lotto lottoRankNone = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 11, 12, 13, 14)));
            lottos.add(lottoRank5);
            lottos.add(lottoRankNone);
            // when
            account.saveResult(lottos);
            // then
            assertThat(account.getYield()).isEqualTo("250.0");
        }

        @DisplayName("꽝 2개 당첨")
        @Test
        void winRankNoneTwice() {
            // given
            Account account = new Account(winningCalculator);
            List<Lotto> lottos = new ArrayList<>();
            Lotto lottoRankNone1 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 11, 12, 13, 14)));
            Lotto lottoRankNone2 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 21, 22, 23, 24)));
            lottos.add(lottoRankNone1);
            lottos.add(lottoRankNone2);
            // when
            account.saveResult(lottos);
            // then
            assertThat(account.getYield()).isEqualTo("0.0");
        }
    }
}