package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {

    private static LottoGenerator generator;

    @BeforeAll
    static void init() {
        generator = new LottoGenerator();
    }

    @ParameterizedTest
    @DisplayName("로또 생성 1 미만 값이 들어갈 때 예외")
    @ValueSource(ints = {
            -1,
            0
    })
    void validatePositive(int actual) {
        assertThatThrownBy(() -> generator.makeLottos(actual))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("발행한 수량만큼 로또 생성 확인")
    @CsvSource(value = {
            "1,1",
            "4,4"
    })
    void makeLottos(int lottoTicket, int lottoSize) {
        assertThat(generator.makeLottos(lottoTicket).getLottos().size()).isEqualTo(lottoSize);
    }

    @Test
    @DisplayName("당첨 번호 로또 생성 확인")
    void makeWinningLotto() {
        Lotto lotto = generator.makeLotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }
}
