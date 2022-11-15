package lotto.util;

import jdk.jfr.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputCheckerTest {
    InputChecker inputChecker;

    @BeforeEach
    void setup(){
        inputChecker=new InputChecker();
    }

    @DisplayName("입력한 값이 정수가 아닌 경우 예외 발생 확인")
    @Test
    void isDigitTest(){
        assertThatThrownBy(()->inputChecker.isDigit("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력한 숫자가 1000으로 나누어떨어지지 않으면 예외 발생하는지 확인")
    @Test
    void isMultipleThousandTest1(){
        assertThatThrownBy(()->inputChecker.isMultipleThousand(1004))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(inputChecker.isMultipleThousand(1000)).isTrue();
    }
    @DisplayName("입력한 숫자가 1000으로 나누어떨어지면 true 반환하는지 확인")
    @Test
    void isMultipleThousandTest2(){
        assertThat(inputChecker.isMultipleThousand(1000)).isTrue();
    }

    @DisplayName("입력한 값이 숫자아니거나 1000으로 나누어떨어지지 않으면 예외 발생하는지 확인")
    @Test
    void checkInputMoney1(){
        assertThatThrownBy(()->inputChecker.checkInputMoney("1004"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->inputChecker.checkInputMoney("hi"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력한 값이 숫자이고 1000으로 나누어떨어지면 true를 반환하는지 확인")
    @Test
    void checkInputMoney2(){
        assertThat(inputChecker.checkInputMoney("14000")).isTrue();
    }
    @DisplayName("정수가 아니면 false 반환하는지 확인")
    @Test
    void isNumeric1(){
        assertThat(inputChecker.isNumeric("k")).isFalse();
    }
    @DisplayName("정수가 아니면 true 반환하는지 확인")
    @Test
    void isNumeric2(){
        assertThat(inputChecker.isNumeric("10")).isTrue();
    }
    @DisplayName("입력받은 보너스 번호가 당첨번호와 중복되면 예외처리가 발생하는지 확인")
    @Test
    void isNotDuplication(){
        assertThatThrownBy(()->inputChecker.isNotDuplication(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력받은 보너스 번호가 1~45사이 숫자가 아니면 예외처리 발생하는지 확인")
    @Test
    void isNumberInRange(){
        assertThatThrownBy(()->inputChecker.isNumberInRange(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력받은 당첨 번호가 정수가 아닌 경우 예외처리가 발생하는지 확인")
    @Test
    void checkInputWinningLottoNumbersIsNumeric1(){
        assertThatThrownBy(()->inputChecker.checkInputWinningLottoNumbersIsNumeric(List.of("1", "2", "3", "k", "5", "6")))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력받은 당첨 번호가 모두 정수인 경우 true를 반환하는지 확인")
    @Test
    void checkInputWinningLottoNumbersIsNumeric2(){
        assertThat(inputChecker.checkInputWinningLottoNumbersIsNumeric(List.of("1", "2", "3", "4", "5", "6"))).isTrue();
    }
    @DisplayName("정상적인 보너스 번호를 입력받은 경우 true를 반환하는지 확인")
    @Test
    void checkInputBonusNumber(){
        assertThat(inputChecker.checkInputBonusNumber("7", List.of(1,2,3,4,5,6))).isTrue();
    }
}