package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoInfoTest {
    private static Stream<Arguments> provideLottoInfoAdnInfoValue() {
        return Stream.of(
                Arguments.of(LottoInfo.MAX_NUMBER, 45),
                Arguments.of(LottoInfo.MIN_NUMBER, 1),
                Arguments.of(LottoInfo.LOTTO_LENGTH, 6),
                Arguments.of(LottoInfo.LOTTO_PRICE, 1000)
        );
    }

    @ParameterizedTest
    @MethodSource("provideLottoInfoAdnInfoValue")
    void infoValueTest(LottoInfo info, int value) {
        assertThat(info.getValue()).isEqualTo(value);
    }
}