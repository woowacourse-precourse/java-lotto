package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {
    public static final String ERROR_MSG = "[ERROR]";

    private Input input = new Input();
    private final List<String> prize = List.of(
            "1, 2, 3, 4, 5, 47",
            "가나다",
            "abc",
            "123abc",
            "1, 2, 3, 4, 5"
    );

    private Method invokeMethod(String declaredMethod) throws NoSuchMethodException {
        Method method = input.getClass().getDeclaredMethod(declaredMethod, String.class);
        method.setAccessible(true);

        return method;
    }

    @Test
    @DisplayName("로또 당첨번호 입력 유효성 검사")
    void validateInputPrizeNum() throws Exception {
        int countErr = 0;
        Method method = invokeMethod("validateInputPrize");

        for(String inputPrize : prize) {
            System.out.println("inputPrize: "+inputPrize);
            try {
                method.invoke(input, inputPrize);
            } catch (InvocationTargetException e) {
                if(e.getTargetException().getMessage().contains(ERROR_MSG)) {
                    countErr++;
                }
            }
        }

        assertEquals(countErr, prize.size());
    }

}
