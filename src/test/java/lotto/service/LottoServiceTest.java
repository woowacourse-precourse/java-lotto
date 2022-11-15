package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.constants.enums.WinningResultStatus;
import lotto.domain.Lotto;
import lotto.repository.LottoRepository;
import lotto.views.OutputMessageGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService();
    private final OutputMessageGenerator outputMessageGenerator = new OutputMessageGenerator();

    @DisplayName("(입력된 금액 / 1,000)의 개수 만큼의 로또 구매 성공 테스트")
    @ParameterizedTest
    @CsvSource({"1000,1", "2000,2", "3000,3", "1230000,1230"})
    void 입력금액_로또_구매(int inputPrice, int countOfLotto) {
        // given
        // when
        lottoService.buyLottos(inputPrice);
        List<Lotto> lottos = LottoRepository.getInstance()
                .findAll();

        // then
        assertThat(lottos.size()).isEqualTo(countOfLotto);
    }

    @DisplayName("구매한 로또의 개수를 구하는 기능 테스트")
    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3", "4,4", "5,5"})
    void 구매한_로또_개수_검증(int inputCountToGenerate, int expectedCount) {
        // given
        LottoRepository.getInstance()
                .generateLottos(inputCountToGenerate);

        // when
        int countOfLotto = lottoService.getCountOfLotto();

        // then
        assertThat(countOfLotto).isEqualTo(expectedCount);
    }

    @DisplayName("구매한 로또의 결과 리스트를 만드는 기능 테스트")
    @Test
    void 구매한_로또_결과_리스트_검증() {
        // given
        List<Object> buyingResult = lottoService.buyLottos(1000);
        List<Lotto> buyingLottos = (List<Lotto>) buyingResult.get(1);
        Lotto lotto = buyingLottos.get(0);

        // when
        String buyingLottoResultMessage = outputMessageGenerator.createBuyingLottoResultMessage(buyingLottos);

        // then
        assertThat(lotto.createMessage()).isEqualTo(buyingLottoResultMessage);
    }

    @DisplayName("구매한 로또 번호와 당첨 번호를 비교해 당첨 통계 및 수익율 검증 테스트")
    @Test
    void 구매한_로또와_당첨번호를_비교해_당첨내역과_수익율_검증() {
        // given
        lottoService.buyLottos(8000);
        List<WinningResultStatus> winResults = List.of(WinningResultStatus.FIFTH);

        // when
        List<Object> lottoResult = lottoService.createLottoResult(winResults);
        double earningsRate = (double) lottoResult.get(1);
        Map<WinningResultStatus, Integer> statisticsCount = (Map<WinningResultStatus, Integer>) lottoResult.get(0);

        // then
        Assertions.assertAll(() -> {
            assertThat(earningsRate).isEqualTo(62.5);
            assertThat(statisticsCount.get(WinningResultStatus.FIFTH)).isEqualTo(1);
        });
    }
}