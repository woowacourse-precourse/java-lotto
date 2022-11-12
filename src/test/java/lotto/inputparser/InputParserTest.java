package lotto.inputparser;

import lotto.lottonumber.Lotto;
import org.junit.jupiter.api.Test;

import static lotto.inputparser.InputParser.parseLottoString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * InputParser 클래스 관련 테스트 클래스입니다.
 */
class InputParserTest {

    /**
     * 정상 케이스입니다.
     */
    @Test
    void parseLottoStringSuccessTest() {
        Lotto lotto = parseLottoString("1,2,3,4,5,6");
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
        assertThat(lotto.getNumbers().get(0)).isEqualTo(1);
        assertThat(lotto.getNumbers().get(1)).isEqualTo(2);
        assertThat(lotto.getNumbers().get(2)).isEqualTo(3);
        assertThat(lotto.getNumbers().get(3)).isEqualTo(4);
        assertThat(lotto.getNumbers().get(4)).isEqualTo(5);
        assertThat(lotto.getNumbers().get(5)).isEqualTo(6);
    }

    /**
     * 숫자가 아닌 비정상적인 수가 들어간 경우입니다.
     */
    @Test
    void parseLottoStringIsNotNumberTest() {
        assertThatThrownBy(() -> parseLottoString("ab,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(",과 숫자로만 이루어져있어야 합니다.");
    }

    /**
     * 6개의 숫자로 이루어지지 않은 경우입니다.
     */
    @Test
    void parseLottoStringIsNotSixNumbersTest() {
        assertThatThrownBy(() -> parseLottoString("2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("6개의 숫자로 이루어져 있어야 합니다.");
        assertThatThrownBy(() -> parseLottoString("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("6개의 숫자로 이루어져 있어야 합니다.");
    }

    /**
     * 1 ~ 45의 범위의 숫자로만 이루어지지 않은 경우입니다.
     */
    @Test
    void parseLottoStringOutOfRangeTest() {
        assertThatThrownBy(() -> parseLottoString("0,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 ~ 45의 범위를 갖는 숫자로만 이루어져 있어야 합니다.");

        assertThatThrownBy(() -> parseLottoString("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 ~ 45의 범위를 갖는 숫자로만 이루어져 있어야 합니다.");
    }

    /**
     * 중복된 숫자가 입력된 경우입니다.
     */
    @Test
    void parseLottoStringDuplicatedNumberTest() {
        assertThatThrownBy(() -> parseLottoString("1,1,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자를 입력할 수 없습니다.");
    }

}