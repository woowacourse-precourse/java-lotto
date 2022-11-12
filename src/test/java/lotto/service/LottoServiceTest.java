package lotto.service;

import static lotto.exception.ValidatorTest.WINNING_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    LottoService lottoService = new LottoService();

    public final static int BONUS_NUMBER = 7;

    private List<Lotto> lottoBundle = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
            new Lotto(List.of(1, 2, 3, 4, 5, 45)),
            new Lotto(List.of(1, 2, 3, 4, 44, 45)),
            new Lotto(List.of(1, 2, 3, 43, 44, 45)),
            new Lotto(List.of(1, 2, 42, 43, 44, 45)),
            new Lotto(List.of(1, 41, 42, 43, 44, 45)),
            new Lotto(List.of(40, 41, 42, 43, 44, 45))
    );

    @DisplayName("compareLottoNumbers - 반환 갯수 테스트")
    @Test
    void test1() {
        List<LottoResult> lottoResults = lottoService
                .compareLottoNumbers(lottoBundle, WINNING_NUMBERS, BONUS_NUMBER);
        assertThat(lottoResults.size()).isEqualTo(lottoBundle.size());

        Map<LottoResult, Long> LottoResultToNumber = lottoResults.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        assertThat(LottoResultToNumber.get(LottoResult.SIX)).isEqualTo(1);
        assertThat(LottoResultToNumber.get(LottoResult.FIVE_WITH_BONUS)).isEqualTo(1);
        assertThat(LottoResultToNumber.get(LottoResult.FIVE)).isEqualTo(1);
        assertThat(LottoResultToNumber.get(LottoResult.FOUR)).isEqualTo(1);
        assertThat(LottoResultToNumber.get(LottoResult.THREE)).isEqualTo(1);
        assertThat(LottoResultToNumber.get(LottoResult.TWO)).isEqualTo(1);
        assertThat(LottoResultToNumber.get(LottoResult.ONE)).isEqualTo(1);
        assertThat(LottoResultToNumber.get(LottoResult.ZERO)).isEqualTo(1);
    }

    @DisplayName("calculateYield - 반환값 테스트")
    @Test
    void test2() {
        List<LottoResult> results = List.of(
                LottoResult.ONE,
                LottoResult.ONE,
                LottoResult.TWO,
                LottoResult.THREE
        );
        double yield = lottoService.calculateYield(results);
        assertThat(yield).isEqualTo(125.0);
    }

}