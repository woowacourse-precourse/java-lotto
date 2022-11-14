package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lotto.constant.enumtype.UserInterfaceMessage;
import org.junit.jupiter.api.Test;

class LottoInputServiceTest {
    @Test
    void 로또_구매_금액_문자열_형식_체크() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException {
        Method validateInputLottoPrice = Class.forName("lotto.service.LottoInputService").getDeclaredMethod(
                "validateInputLottoPrice", String.class);
        validateInputLottoPrice.setAccessible(true);
        try {
            validateInputLottoPrice.invoke(LottoInputService.getInstance(), "8000j");
        } catch (IllegalArgumentException exception) {
            assertThat(exception.getMessage())
                    .isEqualTo(UserInterfaceMessage.ERROR_INPUT_BUY_INFO.getValue());
        } catch (InvocationTargetException exception) {
            assertThat(exception.getCause().getMessage())
                    .isEqualTo(UserInterfaceMessage.ERROR_INPUT_BUY_INFO.getValue());
        }
    }
}