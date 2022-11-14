package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호에 1~45범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45범위를 벗어난 숫자면 예외가 발생한다.")
    @Test
    void TEST_BONUS_NO_CASES() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        Lotto m_Lotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));
        Integer bonusNumber_test1 = 46;
        Integer bonusNumber_test2 = 45;

        IllegalArgumentException illegalArgumentException1 = assertThrows(IllegalArgumentException.class, () ->
                m_Lotto.VALIDATE_BONUS_NO(bonusNumber_test1));
        IllegalArgumentException illegalArgumentException2 = assertThrows(IllegalArgumentException.class, () ->
                m_Lotto.VALIDATE_BONUS_NO(bonusNumber_test2));

    }


}
