package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("올바른 발행 회차가 들어오면 회차만큼 로또 번호를 생성한다.")
    @ParameterizedTest
    @CsvSource({"8,8", "10,10", "25,25"})
    void createLottoSizeByRound(int round, int expected) {
        LottoGenerator lottoGenerator = new LottoGenerator(round);
        assertThat(lottoGenerator.getLottoTickets().size()).isEqualTo(expected);
    }
}
