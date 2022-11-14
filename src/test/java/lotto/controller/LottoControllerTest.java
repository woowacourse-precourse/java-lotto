package lotto.controller;

import lotto.controller.request.JudgeWinningRequest;
import lotto.controller.request.LottoPurchaseRequest;
import lotto.controller.result.LottoPurchaseResult;
import lotto.controller.result.WinningResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.money.Money;
import lotto.domain.statistics.Statistics;
import lotto.domain.winningnumber.WinningNumber;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.money.Money.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("LottoContoller는 ")
class LottoControllerTest {

    private final LottoService service = mock(LottoService.class);
    private final LottoController controller = new LottoController(service);

    @DisplayName("로또를 구입 요청을 통해 로또를 구입하고 결과를 반환한다.")
    @Test
    void purchaseLotto() {
        // given
        Money payment = valueOf(1000);
        LottoPurchaseRequest request = new LottoPurchaseRequest(payment);
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        when(service.purchaseLotto(payment)).thenReturn(lottos);

        // when
        LottoPurchaseResult result = controller.purchaseLotto(request);

        // then
        assertThat(result.getLottos()).isEqualTo(lottos);
    }

    @DisplayName("로또 당첨 판단 요청을 받아 처리 후 결과를 반환한다.")
    @Test
    void returnStatisticsByPrincipleAndPurchasedLottosAndWinningNumber() {
        // given
        Money principle = valueOf(1000);
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        WinningNumber winningNumber = new WinningNumber(
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                6
        );
        JudgeWinningRequest request = new JudgeWinningRequest(principle, lottos, winningNumber);
        Statistics statistics = mock(Statistics.class);

        when(service.judgeWinning(principle, lottos, winningNumber))
                .thenReturn(statistics);

        // when
        WinningResult result = controller.judgeWinning(request);

        // then
        assertThat(result.getStatistics()).isEqualTo(statistics);
    }
}