package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BonusNumberTest {

    @DisplayName("보너스 번호는 1미만의 수가 입력되면 예외가 발생한다.")
    @Test
    void createBonusNumberLowerSize(){
        assertThatThrownBy(()-> new BonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호는 45초과의 수가 입력되면 예외가 발생한다.")
    @Test
    void createBonusNumberOverSize(){
        assertThatThrownBy(()-> new BonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호는 숫자외 다른 문자를 입력할 시 예외가 발생한다.")
    @Test
    void createBonusNumberByAlpha(){
        assertThatThrownBy(()-> new BonusNumber("12h"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("String으로 입력한 값을 Integer로 변환하여 저장한다.")
    @Test
    void getBonusNumber() {
       //given
       String inputNumber = "14";
       //when
       BonusNumber bonusNumber = new BonusNumber(inputNumber);
       //then
        assertThat(bonusNumber.getBonusNumber())
                .isEqualTo(14);
        assertThat(bonusNumber.getBonusNumber())
                .isInstanceOf(Integer.class);
    }
}