package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinNumbersTest {

    @DisplayName("당첨 번호와 보너스 번호를 포함한 객체가 정상적으로 생성된다.")
    @Test
    void createWinNumbers() {
        WinNumbers winNumbers = new WinNumbers((new Lotto(List.of(1, 2, 3, 4, 5, 6))), 7);
        assertThat(winNumbers).isInstanceOf(WinNumbers.class);
    }

    @DisplayName("보너스 번호가 당첨번호에 존재하면 예외가 발생된다.")
    @Test
    void createWinNumbersWithDuplicateBonusNumber() {
        assertThatThrownBy(() -> new WinNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)),6))
                .isInstanceOf(IllegalArgumentException.class);

    }


}