package lotto.service;

import static lotto.exception.ValidatorTest.WINNING_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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

        assertThat(lottoResults.stream()
                .filter(LottoResult.SIX::equals)
                .count()
        ).isEqualTo(1);

        assertThat(lottoResults.stream()
                .filter(LottoResult.FIVE::equals)
                .count()
        ).isEqualTo(1);

        assertThat(lottoResults.stream()
                .filter(LottoResult.FIVE_WITH_BONUS::equals)
                .count()
        ).isEqualTo(1);

        assertThat(lottoResults.stream()
                .filter(LottoResult.FOUR::equals)
                .count()
        ).isEqualTo(1);

        assertThat(lottoResults.stream()
                .filter(LottoResult.THREE::equals)
                .count()
        ).isEqualTo(1);

        //TODO
//        assertThat(lottoResults.stream()
//                .filter(LottoResult.ELSE::equals)
//                .count()
//        ).isEqualTo(3);
    }

    @DisplayName("calculateYield - 반환값 테스트")
//    @Test TODO
    void test2() {
//        List<LottoResult> results = List.of(
//                LottoResult.ELSE,
//                LottoResult.ELSE,
//                LottoResult.ELSE,
//                LottoResult.THREE
//        );
//        double yield = lottoService.calculateYield(results);
//        assertThat(yield).isEqualTo(125.0);
    }

}