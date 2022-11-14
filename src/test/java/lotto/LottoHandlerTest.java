package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import type.LottoGrade;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoHandlerTest {

    private static List<List<Integer>> multipleLottoNumbers = List.of(
            List.of(8, 21, 23, 41, 42, 43),
            List.of(3, 5, 11, 16, 32, 38),
            List.of(7, 11, 16, 35, 36, 44),
            List.of(1, 8, 11, 31, 41, 42),
            List.of(13, 14, 16, 38, 42, 45),
            List.of(7, 11, 30, 40, 42, 43),
            List.of(2, 13, 22, 32, 38, 45),
            List.of(1, 3, 5, 14, 22, 45)
    );

    @DisplayName("당첨 번호를 입력 받으면 쉼표(,)를 기준으로 번호를 분리하고 리스트로 변환한다.")
    @Test
    void getWinningNumbers() {
        String inputNumbers = "1,2,3,4,5,6";
        List<Integer> winningNumbers = LottoHandler.getWinningNumbers(inputNumbers);
        assertThat(winningNumbers).containsAll(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("구입 금액에 따라 최대 구매 가능한 만큼 로또를 발행한다.")
    @ParameterizedTest
    @MethodSource("providePurchaseAmount")
    void getLottos(Integer purchaseAmount, Integer numberOfLotto) {
        List<Lotto> lottos = LottoHandler.getLottos(purchaseAmount);
        assertThat(lottos.size()).isEqualTo(numberOfLotto);
    }

    @DisplayName("발행한 로또 번호와 당첨 번호를 비교하고 당첨 결과를 반환한다.")
    @Test
    void getResultOfLotto() {
        Map<LottoGrade, Integer> resultOfLotto = createLottosAndGetResultOfLotto();
        assertThat(resultOfLotto.size()).isEqualTo(6);
        assertThat(resultOfLotto.get(LottoGrade.FIRST)).isEqualTo(0);
        assertThat(resultOfLotto.get(LottoGrade.SECOND)).isEqualTo(0);
        assertThat(resultOfLotto.get(LottoGrade.THIRD)).isEqualTo(0);
        assertThat(resultOfLotto.get(LottoGrade.FOURTH)).isEqualTo(0);
        assertThat(resultOfLotto.get(LottoGrade.FIFTH)).isEqualTo(1);
    }

    @DisplayName("로또 당첨 내역과 구입 금액을 통해 수익률을 계산한다.")
    @Test
    void getRateOfReturn() {
        Integer purchaseAmount = 8000;
        Map<LottoGrade, Integer> resultOfLotto = createLottosAndGetResultOfLotto();
        Double rateOfReturn = LottoHandler.getRateOfReturn(resultOfLotto, purchaseAmount);
        assertThat(rateOfReturn).isGreaterThan(62);
        assertThat(rateOfReturn).isLessThan(63);
    }

    private static Stream<Arguments> providePurchaseAmount() {
        return Stream.of(
                Arguments.of(8000, 8),
                Arguments.of(10000, 10),
                Arguments.of(13000, 13)
        );
    }

    private Map<LottoGrade, Integer> createLottosAndGetResultOfLotto() {
        List<Lotto> lottos = multipleLottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
        String bonusNumber = "7";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        return LottoHandler.getResultOfLotto(lottos, winningNumbers, Integer.valueOf(bonusNumber));
    }


}
