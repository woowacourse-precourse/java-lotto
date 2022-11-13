package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.model.LottoWinningStatus.*;
import static org.assertj.core.api.Assertions.*;

class LottoWinningStatisticsTest {

    private LottoWinningStatistics winningStatistics;
    private final LottoIssuingMachine issuingMachine = new LottoIssuingMachine();
    private final LottoDrawingMachine drawingMachine = new LottoDrawingMachine();

    @BeforeEach
    void setUp() {
        winningStatistics = new LottoWinningStatistics();
        issuingMachine.getLottos().clear();
    }

    @DisplayName("로또 하나도 당첨되지 않는 경우")
    @Test
    void generateTestNothing() {
        //given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18)),
                new Lotto(List.of(19, 20, 21, 22, 23, 24))
        );
        issuingMachine.getLottos().addAll(lottos);
        drawingMachine.draw(List.of(1, 2, 3, 4, 5, 6), 7);

        //when
        winningStatistics.generate(issuingMachine, drawingMachine);

        //then
        assertThat(winningStatistics.getWinningCount(THREE_NUMBERS_MATCH)).isEqualTo(0);
        assertThat(winningStatistics.getWinningCount(FOUR_NUMBERS_MATCH)).isEqualTo(0);
        assertThat(winningStatistics.getWinningCount(FIVE_NUMBERS_MATCH)).isEqualTo(0);
        assertThat(winningStatistics.getWinningCount(FIVE_NUMBERS_WITH_BONUS_NUMBER_MATCH)).isEqualTo(0);
        assertThat(winningStatistics.getWinningCount(SIX_NUMBERS_MATCH)).isEqualTo(0);
        assertThat(winningStatistics.getEarningsRate()).isEqualTo(0);
    }

    @DisplayName("로또 1등 당첨되는 경우")
    @Test
    void generateTest1st() {
        //given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18)),
                new Lotto(List.of(19, 20, 21, 22, 23, 24))
        );
        issuingMachine.getLottos().addAll(lottos);
        drawingMachine.draw(List.of(1, 2, 3, 4, 5, 6), 7);

        //when
        winningStatistics.generate(issuingMachine, drawingMachine);

        //then
        assertThat(winningStatistics.getWinningCount(THREE_NUMBERS_MATCH)).isEqualTo(0);
        assertThat(winningStatistics.getWinningCount(FOUR_NUMBERS_MATCH)).isEqualTo(0);
        assertThat(winningStatistics.getWinningCount(FIVE_NUMBERS_MATCH)).isEqualTo(0);
        assertThat(winningStatistics.getWinningCount(FIVE_NUMBERS_WITH_BONUS_NUMBER_MATCH)).isEqualTo(0);
        assertThat(winningStatistics.getWinningCount(SIX_NUMBERS_MATCH)).isEqualTo(1);

        double lottoEarnings = SIX_NUMBERS_MATCH.getWinningMoney();
        double lottoExpense = lottos.size() * LOTTO_PRICE;
        double expectedEarningsRate = (lottoEarnings / lottoExpense) * 100;
        assertThat(winningStatistics.getEarningsRate()).isEqualTo(expectedEarningsRate);
    }

    @DisplayName("로또 2등, 3등 당첨되는 경우")
    @Test
    void generateTest2nd3rd() {
        //given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18)),
                new Lotto(List.of(19, 20, 21, 22, 23, 24))
        );
        issuingMachine.getLottos().addAll(lottos);
        drawingMachine.draw(List.of(1, 2, 3, 4, 5, 6), 7);

        //when
        winningStatistics.generate(issuingMachine, drawingMachine);

        //then
        assertThat(winningStatistics.getWinningCount(THREE_NUMBERS_MATCH)).isEqualTo(0);
        assertThat(winningStatistics.getWinningCount(FOUR_NUMBERS_MATCH)).isEqualTo(0);
        assertThat(winningStatistics.getWinningCount(FIVE_NUMBERS_MATCH)).isEqualTo(1);
        assertThat(winningStatistics.getWinningCount(FIVE_NUMBERS_WITH_BONUS_NUMBER_MATCH)).isEqualTo(1);
        assertThat(winningStatistics.getWinningCount(SIX_NUMBERS_MATCH)).isEqualTo(0);

        double lottoEarnings = FIVE_NUMBERS_MATCH.getWinningMoney() + FIVE_NUMBERS_WITH_BONUS_NUMBER_MATCH.getWinningMoney();
        double lottoExpense = lottos.size() * LOTTO_PRICE;
        double expectedEarningsRate = (lottoEarnings / lottoExpense) * 100;
        assertThat(winningStatistics.getEarningsRate()).isEqualTo(expectedEarningsRate);
    }

    @DisplayName("로또 4등, 5등 당첨되는 경우")
    @Test
    void generateTest4th5th() {
        //given
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18)),
                new Lotto(List.of(19, 20, 21, 22, 23, 24))
        );
        issuingMachine.getLottos().addAll(lottos);
        drawingMachine.draw(List.of(1, 2, 3, 4, 5, 6), 7);

        //when
        winningStatistics.generate(issuingMachine, drawingMachine);

        //then
        assertThat(winningStatistics.getWinningCount(THREE_NUMBERS_MATCH)).isEqualTo(1);
        assertThat(winningStatistics.getWinningCount(FOUR_NUMBERS_MATCH)).isEqualTo(1);
        assertThat(winningStatistics.getWinningCount(FIVE_NUMBERS_MATCH)).isEqualTo(0);
        assertThat(winningStatistics.getWinningCount(FIVE_NUMBERS_WITH_BONUS_NUMBER_MATCH)).isEqualTo(0);
        assertThat(winningStatistics.getWinningCount(SIX_NUMBERS_MATCH)).isEqualTo(0);

        double lottoEarnings = THREE_NUMBERS_MATCH.getWinningMoney() + FOUR_NUMBERS_MATCH.getWinningMoney();
        double lottoExpense = lottos.size() * LOTTO_PRICE;
        double expectedEarningsRate = (lottoEarnings / lottoExpense) * 100;
        assertThat(winningStatistics.getEarningsRate()).isEqualTo(expectedEarningsRate);
    }
}
