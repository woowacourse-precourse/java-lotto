package lotto.domain.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusTest {

    @DisplayName("보너스 번호 객체 생성 테스트")
    @Test
    void createBonus() {
        assertThat(new Bonus(new FirstPlace("1,2,3,4,5,6"), "7")).isEqualTo(new Bonus(7));
    }

    @DisplayName("보너스 번호가 로또번호랑 겹치면 예외가 발생한다.")
    @Test
    void createBonusDuplicateByFirstPlace() {
        assertThatThrownBy(() -> new Bonus(new FirstPlace("1,2,3,4,5,6"), "5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 로또 번호와 보너스 번호가 일치하는 경우 true를 리턴한다.")
    @ParameterizedTest(name = "{index} {displayName} Input Bonus Number = {0}")
    @ValueSource(ints = {1, 4, 15, 24, 36, 44})
    void calculateMatchBonusByUserLotto(int input) {
        List<Integer> userLotto = List.of(1, 4, 15, 24, 36, 44);
        assertTrue(new Bonus(input).calculateMatch(userLotto));
    }

    @DisplayName("구매한 로또 번호와 보너스 번호가 일치하지 않는 경우 false를 리턴한다.")
    @ParameterizedTest(name = "{index} {displayName} Input Bonus Number = {0}")
    @ValueSource(ints = {2, 5, 30, 41, 9, 16})
    void calculateNotMatchBonusByUserLotto(int input) {
        List<Integer> userLotto = List.of(1, 4, 15, 24, 36, 44);
        assertFalse(new Bonus(input).calculateMatch(userLotto));
    }
}