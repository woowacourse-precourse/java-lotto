package lotto.domain.winningLotto;

import lotto.domain.myLotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateWinningLottoTest {

    ValidateWinningLotto validateWinningLotto = new ValidateWinningLotto();

    @DisplayName("예외처리확인 - 로또번호 - 로또 번호의 개수 6개 이상 입력")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> validateWinningLotto.validateInputLottoNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외처리확인 - 로또번호 - 로또 번호의 개수 6개 이하 입력")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> validateWinningLotto.validateInputLottoNumber("5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외처리확인 - 로또번호 - 중복된 숫자 존재 확인")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> validateWinningLotto.validateInputLottoNumber("1,2,3,4,4,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외처리확인 - 로또번호 - 올바른 범위의 숫자인지")
    @Test
    void validateInputNumberIsBetween(){
        assertThatThrownBy(() -> validateWinningLotto.validateInputLottoNumber("46,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외처리확인 - 보너스 숫자 - 제대로된 숫자 입력 확인")
    @Test
    void validateBonusNumberIsRightNumber1(){
        assertThatThrownBy(() -> validateWinningLotto.validateBonusNumberIsRightNumber("12H"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외처리확인 - 보너스 숫자 - 제대로된 숫자 입력 확인")
    @Test
    void validateBonusNumberIsRightNumber2(){
        assertThatThrownBy(() -> validateWinningLotto.validateBonusNumberIsRightNumber("::"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외처리확인 - 보너스 숫자 - 숫자 범위 확인")
    @Test
    void validateBonusNumberIsRightNumber(){
        assertThatThrownBy(() -> validateWinningLotto.validateBonusNumberIsRightNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
