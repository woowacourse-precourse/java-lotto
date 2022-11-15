package lotto.service.LottoMachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 6개의 숫자를 입력해야 합니다. 숫자 개수를 올바르게 입력해주세요.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 중복된 숫자가 없어야 합니다.");
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호에 범위 내에 없는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 47)))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호에 포함된 보너스 번호를 넣으면 예외 발생.")
    @Test
    void createLottobyBonusIncludes() {
        int BONUS_NUMBER = 4;
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)).isValidBonusNumber(BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 보너스 번호는 로또번호에 포함되지 않은 값이어야 합니다.");
    }


    @DisplayName("범위 내에 없는 보너스 번호를 넣으면 예외 발생.")
    @Test
    void createLottobyBonusRange() {
        int BONUS_NUMBER = 46;
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)).isValidBonusNumber(BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}