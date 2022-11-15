package lotto;

import lotto.model.WinningNumberParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberParserTest {
    private WinningNumberParser winningNumberParser;

    @BeforeEach
    void setUp() {
        winningNumberParser = new WinningNumberParser();
    }

    @DisplayName("추첨 번호가 쉼표로 끝나면 예외가 발생한다.")
    @Test
    void EndsWithComma() {
        assertThatThrownBy(() -> winningNumberParser.parse("1,2,3,4,5,6,7,"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("추첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void ByOverSize() {
        assertThatThrownBy(() -> winningNumberParser.parse("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("추첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void ByDuplicatedNumber() {
        assertThatThrownBy(() -> winningNumberParser.parse("1,1,1,1,1,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
