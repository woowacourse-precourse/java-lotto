package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.Application.isDuplicated;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IsDuplicatedMethodTest {
    @Test
    void isDuplicated_메소드_예외_테스트1() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 1, 3, 4, 5, 6));
        assertThatThrownBy(() -> isDuplicated(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호엔 중복된 숫자가 없어야 합니다.");
    }

    @Test
    void isDuplicated_메소드_예외_테스트2() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(6, 3, 8, 45, 5, 45));
        assertThatThrownBy(() -> isDuplicated(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호엔 중복된 숫자가 없어야 합니다.");
    }

    @Test
    void isDuplicated_메소드_예외_테스트3() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(45, 3, 8, 45, 5, 45));
        assertThatThrownBy(() -> isDuplicated(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호엔 중복된 숫자가 없어야 합니다.");
    }

    @Test
    void isDuplicated_메소드_정상_입력_테스트1() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 3, 8, 4, 5, 45));
        isDuplicated(winningNumbers);
    }
}