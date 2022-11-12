package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.Application.checkRange;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CheckRangeMethodTest {
    @Test
    void checkRange_메소드_정상_입력_테스트1() {
        List<Integer> winningNumbers = new ArrayList<>();
        for (int number = 1; number <= 45; number++) winningNumbers.add(number);
        checkRange(winningNumbers);
    }

    @Test
    void checkRange_메소드_예외_테스트1() {
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(0);
        assertThatThrownBy(() -> checkRange(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }

    @Test
    void checkRange_메소드_예외_테스트2() {
        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(46);
        assertThatThrownBy(() -> checkRange(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 1이상 45이하의 자연수로 구성해야 합니다.");
    }
}