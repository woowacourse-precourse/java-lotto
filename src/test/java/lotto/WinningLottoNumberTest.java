package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoNumberTest {
    Lotto userLotto;
    Lotto winningNumber;
    BonusNumber bonusNumber;

    @BeforeEach
    void crateInit(){
        userLotto = new Lotto("1,2,3,4,5,6");
        winningNumber = new Lotto("4,5,6,7,8,9");
        bonusNumber = new BonusNumber("1");
    }

    @DisplayName("사용자의 로또 번호와 당첨번호를 비교해 동일한 개수를 도출")
    @Test
    void correctCountCalculation() {
        Assertions.assertThat(new WinningLottoNumber(winningNumber, bonusNumber).correctCountCalculation(userLotto))
                .isEqualTo(3);
    }

    @DisplayName("사용자의 로또 번호와 보너스 번호를 비교해 동일한 개수를 도출")
    @Test
    void bonusCountCalculation() {
        Assertions.assertThat(new WinningLottoNumber(winningNumber, bonusNumber).bonusCountCalculation(userLotto))
                .isEqualTo(1);
    }

    @DisplayName("보너스 번호는 당첨번호와 중복될 수 없다.")
    @Test
    void duplicateWinningAndBonusNum(){
        assertThatThrownBy(()-> new WinningLottoNumber(winningNumber, new BonusNumber("4")))
                .isInstanceOf(IllegalArgumentException.class);
    }

}