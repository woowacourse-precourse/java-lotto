package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {
    Validator validator = new Validator();

    @DisplayName("로또 구입 값이 숫자가 아니라면 예외가 발생한다.")
    @Test
    public void createUserMoneyByNotNumber() throws Exception{
        Money money = new Money("1234asdf");
        assertThatThrownBy(()->validator.validateMoneyNumber(money.getUserMoney())).isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 구입 값이 1,000의 배수가 아니라면 예외가 발생한다.")
    @Test
    public void createUserMoneyByWrongNumber(){
        Money money = new Money("1234");
        assertThatThrownBy(()->validator.validateMoneyUnit(money.getUserMoney())).isInstanceOf(IllegalArgumentException.class);
    }



    @DisplayName("당첨 번호 개수가 6개가 아닐 경우 예외가 발생한다.")
    @Test
    public void createWinningNumberByOverSize() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7, 8));

        assertThatThrownBy(() -> validator.validateWinningNumberSize(winningNumbers.getWinningNumbers()))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateWinningNumberSize(winningNumbers.getWinningNumbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 당첨 번호가 입력되면 예외가 발생한다.")
    @Test
    public void createWinningNumberByWrongNumber() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(0,1,2,46,47,48));
        assertThatThrownBy(() -> validator.validateWinningNumberRange(winningNumbers.getWinningNumbers()))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("당첨 번호 중 중복이 있다면 예외가 발생한다.")
    @Test
    public void createWinningNumberByReference() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,1,2,3,4,5));

        assertThatThrownBy(() -> validator.validateWinningNumberReference(winningNumbers.getWinningNumbers()))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("잘못된 보너스 번호가 입력되면 예외가 발생한다.")
    @Test
    public void createWinningNumberByWrongBonusNumber() {
        BonusNumber bonusNumber1 = new BonusNumber("ㄱ");
        BonusNumber bonusNumber2 = new BonusNumber("46");

        assertThatThrownBy(() -> validator.validateBonusNumberRange(bonusNumber1.getBonusNumber()))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateBonusNumberRange(bonusNumber2.getBonusNumber()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복된다면 예외가 발생한다.")
    @Test
    public void createWinningNumber_BonusNumberByReference(){
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber("6");
        assertThatThrownBy(()->validator.validateReference(winningNumbers.getWinningNumbers(), bonusNumber.getBonusNumber()))
                .isInstanceOf(IllegalArgumentException.class);

    }

}