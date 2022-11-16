package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCompanyTest {

    LottoCompany lottoCompany = new LottoCompany();

    @DisplayName("보너스번호가 여러 개 입력되면 예외 발생.")
    @Test
    void checkBonusInputLength() {
        assertThatThrownBy(() ->  lottoCompany.validateBonusOneNumber("3,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호에 숫자가 아닌 값이 입력되면 예외 발생.")
    @Test
    void checkBonusInputType() {
        assertThatThrownBy(() ->  lottoCompany.validateBonusOneNumber("c"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호의 값이 1보다 작거나 45보다 크면 예외 발생.")
    @Test
    void checkBonusUnderRange() {
        assertThatThrownBy(() ->  lottoCompany.validateBonusRange(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호의 값이 1보다 작거나 45보다 크면 예외 발생.")
    @Test
    void checkBonusOverRange() {
        assertThatThrownBy(() ->  lottoCompany.validateBonusRange(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스번호와 당첨 번호가 중복되면 예외 발생.")
    @Test
    void checkBonusDuplicateWithWinningNumbers() {
        assertThatThrownBy(() ->  lottoCompany.validateBonus("1", List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 중복이 입력되면 예외 발생.")
    @Test
    void checkWinningNumbersDuplicate() {
        assertThatThrownBy(() ->  lottoCompany.makeWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호를 쉼표 없이 입력하면 예외 발생.")
    @Test
    void checkWinningWithNoComma() {
        assertThatThrownBy(() ->  lottoCompany.makeWinningNumbers("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호에 숫자와 쉼표 외의 값을 입력하면 예외 발생.")
    @Test
    void checkWinningNumberType() {
        assertThatThrownBy(() ->  lottoCompany.makeWinningNumbers("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
