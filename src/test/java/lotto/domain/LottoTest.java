package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    private static Stream<Arguments> generateBasicLotto() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), "[1, 2, 3, 4, 5, 6]"),
                Arguments.of(new Lotto(List.of(1, 11, 22, 33, 44, 45)), "[1, 11, 22, 33, 44, 45]")
        );
    }

    @DisplayName("로또 생성시 null 이 들어오면 예외가 발생한다")
    @Test
    void Lotto_생성자_null_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Lotto(null));
    }

    @DisplayName("로또 생성시 46이상의 숫자가 들어오면 예외가 발생한다")
    @Test
    void Lotto_생성자_범위_초과_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(1, 2, 3, 4, 5, 46)));
    }

    @DisplayName("로또 생성시 0이하의 숫자가 들어오면 예외가 발생한다")
    @Test
    void Lotto_생성자_범위_미만_예외() {
        assertThrows(IllegalArgumentException.class, () -> new Lotto(List.of(0, 1, 2, 3, 4, 5)));
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void LOtto_생성자_인자_길이_초과_예외() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void Lotto_생성자_중복_예외() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("toPrintableFormat 메서드는 로또의 값을 String 으로 반환해줌")
    @ParameterizedTest
    @MethodSource("generateBasicLotto")
    void toPrintableFormat_메서드_정상작동(Lotto lotto, String expected) {
        assertThat(lotto.toPrintableFormat()).isEqualTo(expected);
    }

    @DisplayName("contains 메서드는 로또 안에 특정 숫자가 있는지 검사한다")
    @ParameterizedTest
    @MethodSource("generateBasicLotto")
    void contains_메서드_정상작동(Lotto lotto) {
        assertThat(lotto.contains(1)).isTrue();
        assertThat(lotto.contains(43)).isFalse();
    }

    @DisplayName("contains 메서드는 로또 안에 보너스 넘버가 중복으로 있는지 검사한다")
    @ParameterizedTest
    @MethodSource("generateBasicLotto")
    void contains_메서드_보너스_정상작동(Lotto lotto) {
        BonusNumber bonus1 = new BonusNumber(1);
        BonusNumber bonus43 = new BonusNumber(43);
        assertThat(lotto.contains(bonus1)).isTrue();
        assertThat(lotto.contains(bonus43)).isFalse();
    }

    @DisplayName("calculateTotalSameCount 메서드는 로또를 받아서 일치하는 숫자의 수를 계산한다")
    @ParameterizedTest
    @MethodSource("generateBasicLotto")
    void calculateTotalSameCount_메서드_정상작동(Lotto lotto) {
        Lotto lotto1 = new Lotto(List.of(1, 13, 14, 15, 16, 17));
        assertThat(lotto.calculateTotalSameCount(lotto)).isEqualTo(6);
        assertThat(lotto.calculateTotalSameCount(lotto1)).isEqualTo(1);
    }
}
