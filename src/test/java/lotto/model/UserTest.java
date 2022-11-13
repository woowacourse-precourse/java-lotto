package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {
    private User user;

    @BeforeEach
    void setUp(){
        user = new User();
    }

    @DisplayName("사용자가 구입금액에 빈 값을 입력했을때 예외가 발생한다.")
    @Test
    void validateNull(){
        String userInput = "";
        assertThatThrownBy(() -> user.validateUserMoney(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 구입금액에 빈 값을 입력했을때 예외가 발생한다2.")
    @Test
    void validateNull2(){
        String userInput = " ";
        assertThatThrownBy(() -> user.validateUserMoney(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 구입금액에 0을 입력했을때 예외가 발생한다.")
    @Test
    void validateZero(){
        String userInput = "0";
        assertThatThrownBy(() -> user.validateUserMoney(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 구입금액에 숫자가 아닌 값을 입력했을때 예외가 발생한다.")
    @Test
    void validateNumber(){
        String userInput = "하이";
        assertThatThrownBy(() -> user.validateUserMoney(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 구입금액에 int 범위를 넘는 금액을 입력했을 때 값을 입력했을때 예외가 발생한다.")
    @Test
    void validateNotRange(){
        String userInput = "34348593000";
        assertThatThrownBy(() -> user.validateUserMoney(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 구입금액에 잔돈이 남는 금액을 입력했을 때 값을 입력했을때 예외가 발생한다.")
    @Test
    void validateNoChange(){
        String userInput = "3400";
        assertThatThrownBy(() -> user.validateUserMoney(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 당첨번호에 빈 값을 넣엇을때 예외가 발생한다.")
    @Test
    void validateNullWinningNumber(){
        String userInput = "";
        assertThatThrownBy(() -> user.validateUserWinningNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 당첨번호에 띄어쓰기를 포함한 값을 넣엇을때 예외가 발생한다.")
    @Test
    void validateHasSpace(){
        String userInput = " 1,2,3,4,5,6";
        assertThatThrownBy(() -> user.validateUserWinningNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 당첨번호에 띄어쓰기를 포함한 값을 넣엇을때 예외가 발생한다.2")
    @Test
    void validateHasSpace2(){
        String userInput = "1, 2,3,4, 5,6";
        assertThatThrownBy(() -> user.validateUserWinningNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 당첨번호에 , 가 없을때 예외가 발생한다")
    @Test
    void validateHasComma(){
        String userInput = "123456";
        assertThatThrownBy(() -> user.validateUserWinningNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 당첨번호에 숫자가 아닌 값을 입력했을때 예외가 발생한다")
    @Test
    void validateNotNumber(){
        String userInput = "a,b,c";
        assertThatThrownBy(() -> user.validateUserWinningNumber(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }



}