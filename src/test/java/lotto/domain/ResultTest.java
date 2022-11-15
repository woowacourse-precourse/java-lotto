package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ResultTest {
    @ParameterizedTest
    @MethodSource("resultCodes")
    @DisplayName("resultCode에 따른 결과 검사")
    void findByResultCodeTest(String resultCode, Result result) {
        Assertions.assertThat(Result.findByResultCode(resultCode)).isEqualTo(result);
    }

    static Stream<Arguments> resultCodes() {
        return Stream.of(
                Arguments.of("60", Result.FIRST),
                Arguments.of("51", Result.SECOND),
                Arguments.of("50", Result.THIRD),
                Arguments.of("41", Result.FOURTH),
                Arguments.of("30", Result.FIFTH),
                Arguments.of("21", Result.LOSE),
                Arguments.of("00", Result.LOSE)
        );
    }
}
