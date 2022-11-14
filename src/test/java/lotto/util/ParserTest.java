package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ParserTest {

    @Test
    void 숫자_개수가_6개가_아닐때_예외가_발생한다() {
        // given
        String inputString = "1,2,3,4,5,6,7";

        // when, then
        assertThatThrownBy(() -> Parser.convertStringToIntegerList(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 숫자 개수는 6개여야 합니다.");
    }

    @Test
    void 정해진_구분자가_아닐때_예외가_발생한다() {
        // given
        String inputString = "1@2@3@4@5@6";

        // when, then
        assertThatThrownBy(() -> Parser.convertStringToIntegerList(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자 ','와 1 ~ 45 숫자 이외는 입력할 수 없습니다.");
    }

    @Test
    void 공백이_존재하면_예외가_발생한다() {
        // given
        String inputString = "1 2 3 4 5 6";

        // when, then
        assertThatThrownBy(() -> Parser.convertStringToIntegerList(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자 ','와 1 ~ 45 숫자 이외는 입력할 수 없습니다.");
    }

    @Test
    void 숫자_입력_범위를_벗어나면_예외가_발생한다1() {
        // given
        String inputString = "1,2,3,4,5,46";

        // when, then
        assertThatThrownBy(() -> Parser.convertStringToIntegerList(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자 ','와 1 ~ 45 숫자 이외는 입력할 수 없습니다.");
    }

    @Test
    void 숫자_입력_범위를_벗어나면_예외가_발생한다2() {
        // given
        String inputString = "0,1,2,3,4,5";

        // when, then
        assertThatThrownBy(() -> Parser.convertStringToIntegerList(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자 ','와 1 ~ 45 숫자 이외는 입력할 수 없습니다.");
    }

    @Test
    void 중복된_숫자가_존재하면_예외가_발생한다2() {
        // given
        String inputString = "1,2,3,4,5,5";

        // when, then
        assertThatThrownBy(() -> Parser.convertStringToIntegerList(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 당첨 숫자를 입력할 수 없습니다.");
    }
}