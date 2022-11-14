package lotto.validate;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UserValidateTest {

    private UserValidate userValidate;

    @BeforeEach
    void setUp(){
        userValidate = new UserValidate();
    }

    @DisplayName("money에 숫자 이외의 값이 있으면 예외가 발생한다.")
    @Test()
    void 숫자_이외의_값_입력_inputMoney() {
        assertThatThrownBy(() -> userValidate.validateMoney("1000q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("money에 1000이하의 값이 들어가면 예외가 발생한다.")
    @Test
    void 천원_이하의_값_입력_inputMoney() {
        assertThatThrownBy(() -> userValidate.validateMoney("800"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("money에 1000원 단위가 아닌 값이 들어가면 예외가 발생한다.")
    @Test
    void 천원_단위가_아닌_값_입력_inputMoney(){
        assertThatThrownBy(() -> userValidate.validateMoney("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("winningNumber에 콤마로 구분하지 않으면 예외가 발생한다.")
    @Test
    void 여섯자리를_콤마로_구분하지_않고_입력_inputWinningNumber() {
        assertThatThrownBy(() -> userValidate.validateWinningNumbers("1/2/3/4/5/6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("winningNumber에 콤마로 구분하여 6자리를 넣지 않으면 예외가 발생한다.(1)")
    @Test
    void 다섯_자리만_입력_inputWinningNumber(){
        assertThatThrownBy(() -> userValidate.validateWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("winningNumber에 콤마로 구분하여 6자리를 넣지 않으면 예외가 발생한다.(2)")
    @Test
    void 일곱_자리_입력_inputWinningNumber(){
        assertThatThrownBy(() -> userValidate.validateWinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("winningNumber에 콤마와 숫자 이외의 값을 넣으면 예외가 발생한다.")
    @Test
    void 숫자_이외의_값_입력_inputWinningNumber(){
        assertThatThrownBy(() -> userValidate.validateWinningNumbers("1,2,3,4,5,ㅂ"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("winningNumber에 숫자의 입력 범위는 1~45이다. 넘어가면 예외가 발생한다.")
    @Test
    void 범위_테스트_inputWinningNumber(){
        assertThatThrownBy(() -> userValidate.validateWinningNumbers("2,22,222,2222,22222,222222"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("winningNumber에 숫자중복이 발생하면 예외가 발생한다.")
    @Test
    void 중복_테스트_inputWinningNumber(){
        assertThatThrownBy(() -> userValidate.validateWinningNumbers("1,2,3,4,5,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("bonusNumber에 숫자 이외의 값이 입력되면 예외가 발생한다.")
    @Test
    void 숫자_이외의_값_입력_BonusNumber() {
        assertThatThrownBy(() -> userValidate.validateBonusNumber(List.of(1,2,3,4,5,6),"a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("bonusNumber에 1~45이외의 숫자를 입력하면 예외가 발생한다.")
    @Test
    void 범위_테스트_BonusNumber() {
        assertThatThrownBy(() -> userValidate.validateBonusNumber(List.of(1,2,3,4,5,6),"46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("bonusNumber가 winningNumber에 들어있으면 예외가 발생한다.")
    @Test
    void winningNumber에_들어있는지_테스트_BonusNumber() {
        assertThatThrownBy(() -> userValidate.validateBonusNumber(List.of(1,2,3,4,5,6),"2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}