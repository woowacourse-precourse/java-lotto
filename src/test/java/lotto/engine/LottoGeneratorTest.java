package lotto.engine;

import java.util.List;
import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator(new NextstepNumberGenerator());
    }

    @Nested
    @DisplayName("createLottos 메서드는")
    class DescribeCreateLottos {
        @ParameterizedTest
        @ValueSource(ints = {0, -2_147_483_648})
        @DisplayName("1보다 작은 숫자가 인자로 들어오면 IllegalArgumentException을 반환한다.")
        void throwIllegalArgumentExceptionWhenReceiveLowThanOne(int count) {
            Assertions.assertThatThrownBy(() -> lottoGenerator.createLottos(count))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 3, 5})
        @DisplayName("0보다 큰 숫자가 인자로 들어오면 해당 개수만큼의 Lotto리스트를 반환한다.")
        void returnLottosWhenReceiveBiggerThanZero(int count) {
            List<Lotto> actual = lottoGenerator.createLottos(count);

            Assertions.assertThat(actual.size()).isEqualTo(count);
        }
    }
}