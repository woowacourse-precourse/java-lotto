package lotto;

import User.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    User user = new User();

    @DisplayName("입력된 숫자가 1000 단위인 경우에는 true가 반환된다.")
    @Test
    void validateMoney_정상() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method validateMoneyMethod = User.class.getDeclaredMethod("validateMoney", int.class);
        validateMoneyMethod.setAccessible(true);
        boolean isValidate = (boolean) validateMoneyMethod.invoke(user, 12000);
        assertThat(isValidate).isEqualTo(true);
    }

    @DisplayName("입력된 숫자가 1000 단위가 아닌 경우에는 false가 반환된다.")
    @Test
    void validateMoney_예외() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method validateMoneyMethod = User.class.getDeclaredMethod("validateMoney", int.class);
        validateMoneyMethod.setAccessible(true);
        boolean isValidate = (boolean) validateMoneyMethod.invoke(user, 12500);
        assertThat(isValidate).isEqualTo(false);
    }

    @DisplayName("입력된 숫자가 1000 단위인 경우에는 금액을 1000으로 나눈 몫만큼 로또를 구매한다.")
    @Test
    void buyLotto_정상() {
        String money = "12000";
        InputStream in = new ByteArrayInputStream(money.getBytes(Charset.defaultCharset()));
        System.setIn(in);
        user.buyLottos();
        assertThat(user.getLottos().size()).isEqualTo(Integer.parseInt(money) / 1000);
    }

    @DisplayName("입력된 숫자가 1000 단위가 아닌 경우에는 IllegalArgumentException을 반환한다.")
    @Test
    void buyLotto_예외() {
        String money = "12500";
        InputStream in = new ByteArrayInputStream(money.getBytes(Charset.defaultCharset()));
        System.setIn(in);
        assertThatThrownBy(() -> user.buyLottos())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
