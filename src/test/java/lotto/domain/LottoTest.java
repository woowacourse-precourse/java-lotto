package lotto.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("로또 번호가 1부터 45를 벗어나면 예외 처리 한다.")
    @Test
    void createLottoOutOfRange() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("로또 번호가 포함되는지 확인한다.")
    @Test
    void isContainLottoNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertAll(
                () -> assertThat(lotto.isContainNumber(LottoBonusNumber.of(4))).isTrue(),
                () -> assertThat(lotto.isContainNumber(LottoBonusNumber.of(7))).isFalse()
        );
    }

    private static Stream<Arguments> provideForLottoResult() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), 5),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)), 5),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 9, 10)), 4),
                Arguments.of(new Lotto(List.of(1, 2, 3, 9, 10, 11)), 3),
                Arguments.of(new Lotto(List.of(1, 2, 9, 10, 11, 12)), 2),
                Arguments.of(new Lotto(List.of(1, 9, 10, 11, 12, 13)), 1),
                Arguments.of(new Lotto(List.of(9, 10, 11, 12, 13, 14)), 0)
        );
    }

    @ParameterizedTest(name = "로또 번호가 몇개 일치하는지 반환한다.")
    @MethodSource("provideForLottoResult")
    void matchCount(Lotto matchLotto, int count) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.matchCount(matchLotto)).isEqualTo(count);
    }

    @DisplayName("로또 번호들을 반환한다.")
    @Test
    void numbers() {
        assertThat(new Lotto(List.of(1, 6, 15, 27, 37, 42)).numbers())
                .containsExactly(1, 6, 15, 27, 37, 42);
    }
}
