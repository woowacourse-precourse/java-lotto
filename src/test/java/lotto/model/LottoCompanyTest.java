package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCompanyTest {
    private LottoCompany makeLottoCompany(String winningLottoInput, String bonusNumberInput) {
        Lotto winningLotto = new WinningLotto(winningLottoInput).toLotto();
        LottoNumber bonusNumber = new LottoNumber(bonusNumberInput);
        return new LottoCompany(winningLotto, bonusNumber);
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복되면 예외가 발생한다.")
    @Test
    void createLottoCompanyByDuplicateNumber() {
        Assertions.assertThatThrownBy(() -> makeLottoCompany("1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호와 당첨 번호가 중복되지 않다면 성공한다.")
    @Test
    void createLottoCompany() {
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> makeLottoCompany("1,2,3,4,5,6", "7"));
    }
}