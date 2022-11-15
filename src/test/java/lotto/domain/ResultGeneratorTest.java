package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ResultGeneratorTest {
    @ParameterizedTest
    @MethodSource("parameters")
    @DisplayName("일치 개수에 해당하는 결과 생성 검사")
    void getResultTest(List<Integer> lottoNumbers, List<Integer> prizeLottoNumbers, int bonusNumber, Result result) {
        Assertions.assertThat(ResultGenerator.getResult(new Lotto(lottoNumbers),
                        new PrizeLotto(prizeLottoNumbers, bonusNumber)))
                .isEqualTo(result);
    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 7, Result.FIRST),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), List.of(1, 2, 3, 4, 5, 6), 7, Result.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7), 8, Result.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 7, 8), 9, Result.FOURTH),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 7, 8, 9), 10, Result.FIFTH),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(7, 8, 9, 10, 11, 12), 13, Result.LOSE)
                );
    }
}
