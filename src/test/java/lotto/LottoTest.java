package lotto;

import lotto.domain.WinNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
    @DisplayName("당첨 번호 입력시 숫자 이외의 입력이 발생할 경우 예외 발생")
    @Test
    void notIntegerInput() {
        assertThrows(IllegalArgumentException.class, () -> new WinNumber("1,2,3,4,5,A"));
    }

    @DisplayName("당첨 번호 입력시 정해진 형태로 입력하지 않을 경우 예외 발생")
    @Test
    void invalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> new WinNumber("1,2,3,4,5 6"));
    }

    @DisplayName("당첨 번호 입력시 중복된 수를 입력하는 경우 예외 발생")
    @Test
    void isNotDuplicate() {
        assertThrows(IllegalArgumentException.class, () -> new WinNumber("1,2,3,4,5,5"));
    }
}
