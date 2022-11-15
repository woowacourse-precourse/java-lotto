package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ParserTest {

    @DisplayName("숫자 개수가 6개가 아닐때 예외가 발생한다")
    @Test
    void createWrongSizeNumber() {
        // given
        String inputString = "1,2,3,4,5,6,7";

        // when, then
        assertThatThrownBy(() -> Parser.convertStringToIntegerList(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 숫자 개수는 6개여야 합니다.");
    }

    @DisplayName("정해진 구분자가 아닐때 예외가 발생한다")
    @Test
    void createWrongSeparator() {
        // given
        String inputString = "1@2@3@4@5@6";

        // when, then
        assertThatThrownBy(() -> Parser.convertStringToIntegerList(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자 ','와 1 ~ 45 숫자 이외는 입력할 수 없습니다.");
    }

    @DisplayName("공백이 존재하면 예외가 발생한다")
    @Test
    void createStringWithSpace() {
        // given
        String inputString = "1 2 3 4 5 6";

        // when, then
        assertThatThrownBy(() -> Parser.convertStringToIntegerList(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자 ','와 1 ~ 45 숫자 이외는 입력할 수 없습니다.");
    }

    @DisplayName("숫자 입력 범위를 벗어나면 예외가 발생한다1")
    @Test
    void createWrongNumberOverMax() {
        // given
        String inputString = "1,2,3,4,5,46";

        // when, then
        assertThatThrownBy(() -> Parser.convertStringToIntegerList(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자 ','와 1 ~ 45 숫자 이외는 입력할 수 없습니다.");
    }

    @DisplayName("숫자 입력 범위를 벗어나면 예외가 발생한다2")
    @Test
    void createWrongNumberOverMin() {
        // given
        String inputString = "0,1,2,3,4,5";

        // when, then
        assertThatThrownBy(() -> Parser.convertStringToIntegerList(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자 ','와 1 ~ 45 숫자 이외는 입력할 수 없습니다.");
    }

    @DisplayName("중복된 숫자가 존재하면 예외가 발생한다2")
    @Test
    void createDuplicateNumberInString제() {
        // given
        String inputString = "1,2,3,4,5,5";

        // when, then
        assertThatThrownBy(() -> Parser.convertStringToIntegerList(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 당첨 숫자를 입력할 수 없습니다.");
    }
}