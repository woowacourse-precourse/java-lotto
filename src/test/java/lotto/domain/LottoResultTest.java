package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    private static final String LOTTO_LENGTH_ERR_MESSAGE = "[ERROR] 로또의 개수가 올바르지 않습니다.";
    private static final String LOTTO_RANGE_ERR_MESSAGE = "[ERROR] 로또의 범위가 올바르지 않습니다.";
    private static final String LOTTO_DUPLICATION_ERR_MESSAGE = "[ERROR] 로또에 중복이 존재합니다.";
    private static final String BONUS_DUPLICATION_ERR_MESSAGE = "[ERROR] 보너스 번호가 당첨번호에 이미 존재합니다.";

    @ParameterizedTest
    @MethodSource("generateLottoResult")
    @DisplayName("당첨번호, 보너스번호 예외처리 테스트")
    void LottoResult(List<Integer> winningNumbers, int bonusNumber, String expected) {
        assertThatThrownBy(() -> new LottoResult(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }

    static Stream<Arguments> generateLottoResult() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 5), 6, LOTTO_DUPLICATION_ERR_MESSAGE),
                Arguments.of(Arrays.asList(1, 2, 3), 6, LOTTO_LENGTH_ERR_MESSAGE),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 46), 6, LOTTO_RANGE_ERR_MESSAGE),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6, BONUS_DUPLICATION_ERR_MESSAGE)
        );
    }
}