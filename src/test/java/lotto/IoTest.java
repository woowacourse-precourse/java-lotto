package lotto;

import lotto.model.Lotto;
import lotto.view.InputUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IoTest {
    @Test
    void inputException() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InputUser user = new InputUser();
        Method method = user.getClass().getDeclaredMethod("checkPurchase", String.class);
        method.setAccessible(true);

        try {
            method.invoke(user,"1021");
        } catch (InvocationTargetException e) {
            e.getTargetException();
        }
    }
}
