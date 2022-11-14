package lotto.service;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGenerator;
import lotto.domain.money.Money;
import lotto.domain.rank.Rank;
import lotto.domain.statistics.Statistics;
import lotto.domain.winningnumber.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static lotto.domain.money.Money.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("LottoService는 ")
class LottoServiceTest {

    private final Money pricePerLotto = Money.valueOf(1000);
    private final LottoGenerator generator = mock(LottoGenerator.class);
    private final LottoService lottoService = new LottoService(pricePerLotto, generator);

    @Test
    @DisplayName("로또를 구매할 수 있다.")
    void purchaseLotto() {
        // given
        final Money payment = valueOf(10000);
        final List<Lotto> lottos = Collections.emptyList();

        when(generator.generateByCount(
                payment.exchangeFor(pricePerLotto).size())
        ).thenReturn(lottos);

        // when
        final List<Lotto> purchaseLottos = lottoService.purchaseLotto(payment);

        // then
        assertThat(purchaseLottos).isEqualTo(lottos);
    }

    @Test
    @DisplayName("로또 구매 시 지불한 가격이 로또 가격으로 나누어 떨어지지 않으면 오류가 발생한다.")
    void purchaseLottoThrowExceptionWhenPaymentIsNotValidate() {
        // given
        final Money payment = valueOf(10001);
        final LottoGenerator generator = mock(LottoGenerator.class);
        final LottoService lottoService = new LottoService(pricePerLotto, generator);

        // when, then
        assertThatThrownBy(() -> lottoService.purchaseLotto(payment))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("원금과 구매한 로또들, 당첨 번호를 가지고 당첨 통계를 내어 반환한다.")
    void returnStatisticsByPrincipleAndPurchasedLottosAndWinningNumber() {
        // given
        final Money principle = valueOf(10000);
        final List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 10, 11))
        );
        final WinningNumber winningNumber = new WinningNumber(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                7
        );

        // when
        final Statistics statistics =
                lottoService.judgeWinning(principle, lottos, winningNumber);

        // then
        assertThat(statistics.count(Rank.FIRST)).isEqualTo(1L);
    }
}