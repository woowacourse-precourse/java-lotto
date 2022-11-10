package lotto;

import static lotto.ValidatorTest.WINNING_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    private final static int BONUS_NUMBER = 7;
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

    @DisplayName("반환 갯수 테스트")
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

        assertThat(lottoResults.stream()
                .filter(LottoResult.ELSE::equals)
                .count()
        ).isEqualTo(3);
    }

}