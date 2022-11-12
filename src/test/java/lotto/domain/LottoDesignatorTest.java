package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoDesignatorTest {
    private static final LottoDesignator = new LottoDesignator();
    @DisplayName("입력받은 로또번호가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_숫자가_아닐_경우_예외() {
        String input = "1,2,3,a,4,5";
        assertThatThrownBy(() -> lottoDesignator.checkOnlyNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
