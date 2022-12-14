package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    private static Stream<Arguments> generateLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(5, 6, 7, 8, 9, 10)),
                Arguments.of(List.of(1, 45, 44, 43, 42, 2)),
                Arguments.of(List.of(6, 5, 4, 3, 2, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("generateLottoNumbers")
    @DisplayName("로또 도메인 정상 생성 테스트")
    void createLotto_success(List<Integer> numbers) {
        // given
        // when
        // then
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Lotto(numbers));
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1 ~ 45를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoByOutOfBoundNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.OUT_OF_BOUNDS_LOTTO_NUMBER_ERROR);
    }
}
