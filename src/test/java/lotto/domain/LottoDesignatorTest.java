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

    @DisplayName("입력받은 로또번호가 1 ~ 45 범위에 벗어날 경우 예외가 발생한다.")
    @Test
    void 로또_범위_예외() {
        String input = "1,2,3,4,5,61";
        assertThatThrownBy(() -> lottoDesignator.checkRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 보너스 번호가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 보너스_번호_숫자_아닐_경우_예외() {
        String input = "a";
        assertThatThrownBy(() -> lottoDesignator.checkOnlyNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 보너스 번호가 6 자리와 중복일 경우 예외가 발생한다.")
    @Test
    void 보너스번호_중복_예외() {
        String bonus = "1";
        String lotto = "1,2,3,4,5,6";
        assertThatThrownBy(() -> lottoDesignator.checkBonusDuplication(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 보너스 번호가 1 ~ 45 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void 보너스번호_범위_예외() {
        String bonus = "70";
        assertThatThrownBy(() -> lottoDesignator.checkRange(bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
