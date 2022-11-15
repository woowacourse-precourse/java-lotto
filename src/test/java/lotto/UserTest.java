package lotto;

import lotto.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    private User user;

    @BeforeEach
    void setUp(){
        user = new User();
    }

    @DisplayName("구매금액이 1000단위가 아니라면 예외가 발생한다.")
    @Test
    void isValidPrice(){
        assertThatThrownBy(() -> user.isValidPrice(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매금액을 숫자 아닌 다른 문자로 입력하면 예외가 발생한다.")
    @Test
    void isNumericPrice(){
        assertThatThrownBy(() -> user.isNumeric("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호가 1~46 범위 밖의 숫자라면 예외가 발생한다.")
    @Test
    void isOutOfRange(){
        assertThatThrownBy(() -> user.isOutOfRange("1,2,0,3,47,8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호를 6자리로 입력하지 않는다면 예외가 발생한다.")
    @Test
    void isSixDigit(){
        assertThatThrownBy(()->user.isSixDigit("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호를 중복해서 입력한다면 예외가 발생한다.")
    @Test
    void isDuplicate(){
        assertThatThrownBy(()->user.isDuplicate("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
