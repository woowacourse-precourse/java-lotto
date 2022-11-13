package lotto.game.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.game.domain.Lotto;
import lotto.game.domain.LottoGrade;
import lotto.game.domain.Money;
import lotto.game.domain.TotalResult;
import lotto.game.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("로또 구매가 정상적으로 되야한다")
    void buyLotto() {
        // given
        Money money = Money.of(10000);

        // when
        List<Lotto> lottos = lottoService.buyLotto(money);

        // then
        assertThat(lottos.size())
                .isEqualTo(10);
    }


    @Test
    @DisplayName("로또 번호가 3개 같으면 5등이어야 한다")
    void winningConfirmBy3NumberMatch() {
        // given
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.FIFTH);
    }

    @Test
    @DisplayName("로또 번호가 3개 같고 보너스 번호가 맞으면 4등이어야 한다")
    void winningConfirmBy3NumberMatchAndBonusMatch() {
        // given
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.FOURTH);
    }

    @Test
    @DisplayName("로또 번호가 4개 같으면 4등이어야 한다")
    void winningConfirmBy4NumberMatch() {
        // given
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 10));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.FOURTH);
    }

    @Test
    @DisplayName("로또 번호가 5개 같으면 3등이어야 한다")
    void winningConfirmBy5NumberMatch() {
        // given
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 10));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.THIRD);
    }

    @Test
    @DisplayName("로또 번호가 6개 같으면 1등이어야 한다")
    void winningConfirmBy6NumberMatch() {
        // given
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.FIRST);
    }

    @Test
    @DisplayName("로또 번호가 5개 같고 보너스 번호가 맞으면 2등이어야 한다")
    void winningConfirmBy5NumberMatchAndBonusMatch() {
        // given
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", "7");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        // expect
        assertThat(lottoService.winningConfirm(winningLotto, lotto))
                .isEqualTo(LottoGrade.SECOND);
    }

    @Test
    @DisplayName("로또를 10000원치 구매하고 5등이 1개면 수익률은 50.0% 여야한다")
    void buyLotto10000WonAndFifthGradeThenProfitRateMust_50Percent() {
        // given
        Money money = Money.of(10000);
        TotalResult totalResult = TotalResult.of(List.of(LottoGrade.FIFTH));

        // expect
        assertThat(lottoService.calculateProfitPercent(money, totalResult.getTotalProfit()))
                .isEqualTo("50.0%");
    }

    @Test
    @DisplayName("로또를 10000원치 구매하고 1등이 1개면 수익률은 20,000,000.0% 여야한다")
    void buyLotto10000WonAndFirstGradeThenProfitRateMust_2_000_000Percent() {
        // given
        Money money = Money.of(10000);
        TotalResult totalResult = TotalResult.of(List.of(LottoGrade.FIRST));

        // expect
        assertThat(lottoService.calculateProfitPercent(money, totalResult.getTotalProfit()))
                .isEqualTo("20,000,000.0%");
    }

    @Test
    @DisplayName("로또를 1000000원치 구매하고 5등이 1개면 수익률은 0.5% 여야한다")
    void buyLotto1000000WonAndFirstGradeThenProfitRateMust_2_000_000Percent() {
        // given
        Money money = Money.of(1_000_000);
        TotalResult totalResult = TotalResult.of(List.of(LottoGrade.FIFTH));

        // expect
        assertThat(lottoService.calculateProfitPercent(money, totalResult.getTotalProfit()))
                .isEqualTo("0.5%");
    }

    @Test
    @DisplayName("로또를 10000원치 구매하고 등수가 없으면 수익률은 0.0% 여야한다")
    void buyLotto10000WonAndNothingThenProfitRateMust_0Percent() {
        // given
        Money money = Money.of(10000);
        TotalResult totalResult = TotalResult.of(List.of());

        // expect
        assertThat(lottoService.calculateProfitPercent(money, totalResult.getTotalProfit()))
                .isEqualTo("0.0%");
    }

    @Test
    @DisplayName("로또를 10000원치 구매하고 5등이 3개, 4등이 1개, 3등이 1개면 수익률은 15,650.0% 여야한다")
    void buyLotto10000WonAndMixGradeThenProfitRateMust_0Percent() {
        // given
        Money money = Money.of(10000);
        TotalResult totalResult = TotalResult.of(
                List.of(
                        LottoGrade.FIFTH,
                        LottoGrade.FIFTH,
                        LottoGrade.FIFTH,
                        LottoGrade.FOURTH,
                        LottoGrade.THIRD
                )
        );

        // expect
        assertThat(lottoService.calculateProfitPercent(money, totalResult.getTotalProfit()))
                .isEqualTo("15,650.0%");
    }
}