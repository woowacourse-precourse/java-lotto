package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersServiceTest {
    @DisplayName("보너스 숫자를 제외한 당첨 숫자 6개를 뽑는 기능 테스트")
    @Test
    void createWinningNumbers() {
        // 6개 당첨 번호 입력의 예외 처리 테스트
        assertThatThrownBy(() -> new WinningNumbersService("1,2,3,4,5", "10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningNumbersService(",2,3,4,5,6", "10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningNumbersService("1,2,3,4,5,", "10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningNumbersService("1,2,3,4,4", "10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningNumbersService("", "10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningNumbersService("1,2,3,4,5,46", "10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        
        // 보너스 번호 입력의 예외 처리 테스트
        assertThatThrownBy(() -> new WinningNumbersService("1,2,3,4,5,6", ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningNumbersService("1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningNumbersService("1,2,3,4,5,6", "--"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
        assertThatThrownBy(() -> new WinningNumbersService("1,2,3,4,5,6", "46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
