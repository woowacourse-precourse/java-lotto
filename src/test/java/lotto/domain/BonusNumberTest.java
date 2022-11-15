package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp(){
        winningLotto = new WinningLotto("1,2,3,4,5,6");
    }

    @Test
    @DisplayName("숫자 형식 아니면 예외 발생")
    void bonusNumberNonNumeric() {
        String bonusNumberInput = "abc";
        assertThatThrownBy(() -> {
             new BonusNumber(bonusNumberInput, winningLotto.getWinningLottoNumbers());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 1 ~ 45 밖의 숫자인 경우 예외 발생")
    void bonusNumberOutOfRange() {
        String bonusNumberInput = "46";
        assertThatThrownBy(() -> {
            new BonusNumber(bonusNumberInput, winningLotto.getWinningLottoNumbers());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 보너스 번호 입력 시 예외 발생")
    void bonusNumberDuplicated() {
        String bonusNumberInput = "6";
        assertThatThrownBy(() -> {
            new BonusNumber(bonusNumberInput, winningLotto.getWinningLottoNumbers());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호 정상 입력 시, 저장된 값 확인")
    void validBonusNumberInput(){
        String bonusNumberInput = "7";
        BonusNumber bonusNumber = new BonusNumber(bonusNumberInput, winningLotto.getWinningLottoNumbers());
        assertThat(bonusNumber.getNumber()).isEqualTo(7);
    }
}