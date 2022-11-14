package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LottoTest {
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

    @DisplayName("로또 번호가 1 ~ 45 범위를 벗어나는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 1, 2, 3, 4, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로뽀 번호 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideLotto")
    void createLotto(List<Integer> list) {
        Lotto lotto = new Lotto(list);
        assertNotNull(lotto);
    }

    private static Stream<Arguments> provideLotto() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 45)),
                Arguments.of(List.of(7, 2, 3, 4, 5, 6))
        );
    }
}
