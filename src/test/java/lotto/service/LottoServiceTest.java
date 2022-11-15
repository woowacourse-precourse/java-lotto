package lotto.service;

import lotto.model.Lottos;
import lotto.model.Prize;
import lotto.model.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoService의 메서드를 테스트한다.")
class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @DisplayName("Result와 로또를 비교하면 로또결과(1 ~ 5등) 5개가 반환된다.")
    @Test
    void returnFiveSizeEnumMapWhenCompareResultLottos() {
        //given
        Lottos lottos = Lottos.purchaseLottos(10000);
        Result result = Result.of(List.of(1, 2, 3, 4, 5, 6), 7);

        //when
        Map<Prize, Long> prizeResult = lottoService.compareResult(lottos, result);

        //then
        assertThat(prizeResult).hasSize(5);
    }

    @DisplayName("inputMoney와 winningResults를 비교하여 수익률을 계산할 수 있다.")
    @ParameterizedTest
    @MethodSource("initInputMoneyAndWinningResults")
    void getEarningRatesWhenCompareInputMoneyAndWinningResults(
            String inputMoney,
            Map<Prize, Long> winningResult,
            Double earningRates
    ) {
        //when
        Double result = lottoService.calculateEarningRates(inputMoney, winningResult);

        //then
        assertThat(result).isEqualTo(earningRates);
    }

    private static Stream<Arguments> initInputMoneyAndWinningResults() {
        return Stream.of(
                Arguments.of("5000", createWinningResults(0, 0, 0, 0, 1), 100.0),
                Arguments.of("10000", createWinningResults(0, 0, 0, 1, 1), 550.0),
                Arguments.of("15000", createWinningResults(0, 0, 1, 1, 0), 10_333.3),
                Arguments.of("25000", createWinningResults(0, 1, 0, 0, 0), 120_000.0),
                Arguments.of("1000", createWinningResults(1, 0, 0, 0, 0), 200_000_000.0)
        );
    }

    private static Map<Prize, Long> createWinningResults(long firstPrize, long secondPrize, long thirdPrize, long fourthPrize, long fifthPrize) {
        Map<Prize, Long> winningResult = new HashMap<>();
        winningResult.put(Prize.FIRST, firstPrize);
        winningResult.put(Prize.SECOND, secondPrize);
        winningResult.put(Prize.THIRD, thirdPrize);
        winningResult.put(Prize.FOURTH, fourthPrize);
        winningResult.put(Prize.FIFTH, fifthPrize);

        return winningResult;
    }
}