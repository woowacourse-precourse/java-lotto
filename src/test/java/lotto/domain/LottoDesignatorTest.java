package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoDesignatorTest {
    private static final LottoDesignator lottoDesignator = new LottoDesignator();
    @DisplayName("입력받은 로또번호가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_숫자가_아닐_경우_예외() {
        String input = "1,2,3,a,4,5";
        assertThatThrownBy(() -> lottoDesignator.checkOnlyNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 로또번호가 6 자리가 아닐 경우 예외가 발생한다.")
    @Test
    void 로또_번호_자릿수_예외() {
        String input = "1,2,3,4,5";
        assertThatThrownBy(() -> lottoDesignator.checkSixCipher(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 로또번호가 중복 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void 로또_번호_중복_예외() {
        String input = "1,2,3,4,5,5";
        assertThatThrownBy(() -> lottoDesignator.checkDuplication(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
