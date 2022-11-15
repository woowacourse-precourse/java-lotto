package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BonusNumberTest {

    private static Stream<Arguments> createParameterForException() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 0),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 46),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 1),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6)
        );
    }

    @Test
    @DisplayName("보너스 숫자 객체 생성 테스트")
    void bonusNumberCreateTest() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonus = new BonusNumber(winningLotto, 7);
        assertThat(bonus).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("createParameterForException")
    @DisplayName("유효하지 않은 보너스 번호를 생성하려고 하는 경우 예외 발생")
    void bonusNumberExcetionTest(Lotto winningLotto, int bonusNumber) {
        assertThatThrownBy(() -> new BonusNumber(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("existIn 메서드 false 케이스")
    void bonusNumberExistInFalseTest() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonus = new BonusNumber(winningLotto, 7);
        Lotto lotto = new Lotto(List.of(11, 12, 10, 5, 3, 2));
        assertThat(bonus.existIn(lotto)).isEqualTo(false);
    }

    @Test
    @DisplayName("existIn 메서드 true 케이스")
    void bonusNumberExistInTrueTest() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonus = new BonusNumber(winningLotto, 12);
        Lotto lotto = new Lotto(List.of(11, 12, 10, 5, 3, 2));
        assertThat(bonus.existIn(lotto)).isEqualTo(true);
    }

}
