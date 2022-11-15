package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    private static LottoGenerator lottoGenerator;

    @BeforeEach
    void beforeEach() {
        lottoGenerator = new LottoGenerator();
    }

    @DisplayName("생성할 로또의 수와 생성된 로또의 수 비교")
    @ParameterizedTest
    @CsvSource(value = {
            "1, 1",
            "8, 8"
    })
    void checkNumberOfLottoTickets(int numberOfLottoTickets, int lottoSize) {
        assertThat(lottoGenerator.generateLottoTickets(numberOfLottoTickets).getLottoTickets().size()).isEqualTo(lottoSize);
    }
}
