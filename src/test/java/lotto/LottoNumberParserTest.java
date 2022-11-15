package lotto;

import lotto.utility.LottoNumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberParserTest {
    @DisplayName("인자로 들어가는 문자열이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void parseLottoNumberNotNumeric() {
        assertThatThrownBy(() -> LottoNumberParser.parseLottoNumbers("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("인자로 들어가는 문자열이 45보다 크면 예외가 발생한다.")
    @Test
    void parseLottoNumberBiggerThanMaxSize() {
        assertThatThrownBy(() -> LottoNumberParser.parseLottoNumbers("46,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("인자로 들어가는 문자열이 1보다 작으면 예외가 발생한다.")
    @Test
    void parseLottoNumberSmallerThanMinSize() {
        assertThatThrownBy(() -> LottoNumberParser.parseLottoNumbers("-1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoNumberParser.parseLottoNumbers("0,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

