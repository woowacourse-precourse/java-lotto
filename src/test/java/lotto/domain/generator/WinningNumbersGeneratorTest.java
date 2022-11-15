package lotto.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersGeneratorTest {
    @DisplayName("당첨번호목록 생성시 쉼표 뒤에 공백에 있으면 예외처리한다.")
    @Test
    void generateWinningNumbersWithSpace() {
        assertThatThrownBy(() -> WinningNumbersGenerator.generateWinningNumbers("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호목록 생성시 쉼표로 구분이 안되면 예외처리한다")
    @Test
    void generateWinningNumbersWithoutComma() {
        assertThatThrownBy(() -> WinningNumbersGenerator.generateWinningNumbers("1:2:3:4:5:6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호목록 생성시 숫자가 아닌게 있으면 예외처리한다 - 문자")
    @Test
    void generateWinningNumbersWithNoNumeric1() {
        assertThatThrownBy(() -> WinningNumbersGenerator.generateWinningNumbers("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호목록 생성시 숫자가 아닌게 있으면 예외처리한다 - 실수")
    @Test
    void generateWinningNumbersWithNoNumeric2() {
        assertThatThrownBy(() -> WinningNumbersGenerator.generateWinningNumbers("1,2,3,4,5,1.2"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
