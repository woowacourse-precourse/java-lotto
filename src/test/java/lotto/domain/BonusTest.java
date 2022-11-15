package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusTest {
    @DisplayName("보너스 번호 예외처리 테스트")
    @ParameterizedTest(name = "[{index}] {0}, {1}")
    @CsvSource({"1,'[ERROR] 보너스 번호는 담첨 번호와 중복될 수 없습니다.'",
    "46, '[ERROR} 보너스 번호의 범위는 1 ~ 45 사이어야만 합니다.'",
    "3, '[ERROR] 보너스 번호는 담첨 번호와 중복될 수 없습니다.'"})
    void bonusNumberExceptionTest(int bonusNumber, String errorMessage) {
        List<Integer> numbers = new ArrayList<Integer>(List.of(1,2,3,4,5,6));
        Lotto winningLotto = new Lotto(numbers);

        assertThatThrownBy(() -> new Bonus(bonusNumber, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    @DisplayName("보너스 번호 형식 예외처리 테스트")
    @ParameterizedTest(name = "[{index}] {0}, [ERROR] 보너스 번호는 양의 정수 형태이어야 합니다.")
    @ValueSource(strings = {"1a", "ab", "12.0", "-12"})
    void bonusNumberExceptionTest2(String bonusNumber) {

        assertThatThrownBy(() -> Bonus.bonusIsNumeric(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 양의 정수 형태이어야 합니다.");
    }
}