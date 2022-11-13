package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoResultTest {
    private static Stream<Arguments> generateLottoResult() {
        return Stream.of(
                Arguments.of(0, LottoResult.ZERO_CORRECT),
                Arguments.of(1, LottoResult.ONE_CORRECT),
                Arguments.of(2, LottoResult.TWO_CORRECT),
                Arguments.of(3, LottoResult.THREE_CORRECT),
                Arguments.of(4, LottoResult.FOUR_CORRECT),
                Arguments.of(5, LottoResult.FIVE_CORRECT),
                Arguments.of(6, LottoResult.SIX_CORRECT)
        );
    }

    @DisplayName("from 메서드는 0부터 6까지의 숫자에 따른 결과를 생성한다")
    @ParameterizedTest
    @MethodSource("generateLottoResult")
    void case1(int key, LottoResult result) {
        assertThat(LottoResult.from(key)).isEqualTo(result);
    }

    @DisplayName("from 메서드는 범위 바깥의 숫자가 들어오면 IEA 예외 반환")
    @ParameterizedTest
    @ValueSource(ints = {-1, 7})
    void case2(int input) {
        assertThrows(IllegalArgumentException.class, () -> LottoResult.from(input));
    }
}
