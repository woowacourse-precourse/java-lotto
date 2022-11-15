package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NumberValidatorTest {
    @DisplayName("로또 구매 금액이 숫자가 아닐경우")
    @Test
    void lottoPriceIsNotNumber() {
        assertThatThrownBy(() -> NumberValidator.isValidPurchasePrice("1000jh"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 1000원 단위가 아닐 경우")
    @Test
    void lottoPriceIsNotDivided() {
        assertThatThrownBy(() -> NumberValidator.isValidPurchasePrice("2400"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 숫자가 아닌 경우")
    @Test
    void lottoNumberIsNotNumber() {
        assertThatThrownBy(() -> NumberValidator.isValidLottoNumbers("djs,23,fd,12,##,14"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 form이 올바르지 않은 경우")
    @Test
    void inValidLottoNumber() {
        assertThatThrownBy(() -> NumberValidator.isValidLottoNumbers("1.2.4.42.40.3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개가 아닌 경우")
    @Test
    void invalidLottoCount() {
        assertThatThrownBy(() -> NumberValidator.isValidLottoNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1부터 45사이가 아닌 경우")
    @Test
    void invalidLottoRange() {
        assertThatThrownBy(() -> NumberValidator.isValidLottoNumbers("46,61,2,3,15,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 중복될 경우")
    @Test
    void lottoNumberIsDuplicated() {
        assertThatThrownBy(() -> NumberValidator.isValidLottoNumbers("1,1,1,1,1,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아닐 경우")
    @Test
    void bonusIsNotNumber() {
        assertThatThrownBy(() -> NumberValidator.isValidBonusNumber("f", "1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위가 1부터 45사이가 아닌 경우")
    @Test
    void invalidBonusRange() {
        assertThatThrownBy(() -> NumberValidator.isValidBonusNumber("50", "1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 보너스 번호가 중복되는 경우")
    @Test
    void isDuplicateWithLottoNumbers() {
        assertThatThrownBy(() -> NumberValidator.isValidBonusNumber("3", "1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
