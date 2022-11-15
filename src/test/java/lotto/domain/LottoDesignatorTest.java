package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoDesignatorTest {
    @DisplayName("입력받은 로또번호가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_숫자가_아닐_경우_예외() {
        String input = "1,2,3,a,4,5";

        assertThatThrownBy(() -> LottoDesignator.getInstance.inputLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 숫자만 입력 가능합니다.(구분자 쉼표만 가능)");
    }

    @DisplayName("입력받은 로또번호가 6 자리가 아닐 경우 예외가 발생한다.")
    @Test
    void 로또_번호_자릿수_예외() {
        String input = "1,2,3,4,5";

        assertThatThrownBy(() -> LottoDesignator.getInstance.inputLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개를 입력해야 합니다.");
    }

    @DisplayName("입력받은 로또번호가 중복 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void 로또_번호_중복_예외() {
        String input = "1,2,3,4,5,5";

        assertThatThrownBy(() -> LottoDesignator.getInstance.inputLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @DisplayName("입력받은 로또번호가 1 ~ 45 범위에 벗어날 경우 예외가 발생한다.")
    @Test
    void 로또_범위_예외() {
        String input = "1,2,3,4,5,61";

        assertThatThrownBy(() -> LottoDesignator.getInstance.inputLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1 ~ 45 범위만 입력 가능합니다.");
    }

    @DisplayName("입력받은 보너스 번호가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void 보너스_번호_숫자_아닐_경우_예외() {
        String lotto = "1,2,3,4,5,6";
        String input = "a";

        assertThatThrownBy(() -> LottoDesignator.getInstance.inputBonus(lotto, input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 숫자만 입력 가능합니다.(구분자 쉼표만 가능)");
    }

    @DisplayName("입력받은 보너스 번호가 6 자리와 중복일 경우 예외가 발생한다.")
    @Test
    void 보너스번호_중복_예외() {
        String bonus = "1";
        String lotto = "1,2,3,4,5,6";

        assertThatThrownBy(() -> LottoDesignator.getInstance.inputBonus(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 로또 번호와 중복 불가합니다.");
    }

    @DisplayName("입력받은 보너스 번호가 1 ~ 45 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void 보너스번호_범위_예외() {
        String bonus = "70";
        String lotto = "1,2,3,4,5,6";

        assertThatThrownBy(() -> LottoDesignator.getInstance.inputBonus(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1 ~ 45 범위만 입력 가능합니다.");
    }
}
