package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class LottoWinningNumberTest {

    @Test
    void 당첨_번호_6개_이하인_경우_에러처리() {
        String input = "1,2,3,4,5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(LottoWinningNumber::new)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_6개_이상인_경우_에러처리() {
        String input = "1,2,3,4,5,6,7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(LottoWinningNumber::new)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_숫자가_아닌_경우_에러처리() {
        String input = "1,a,3,4,5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(LottoWinningNumber::new)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_범위에_맞지_않는_경우_예외처리() {
        String input = "1,2,3,4,5,47";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(LottoWinningNumber::new)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_쉼표로_구분되지_않는_경우_예외처리() {
        String input = "12 13 12 24 12 42";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(LottoWinningNumber::new)
                .isInstanceOf(IllegalArgumentException.class);
    }
}