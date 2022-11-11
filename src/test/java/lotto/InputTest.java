package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputTest {
    public static final String ERROR_MSG = "[ERROR]";

    private final Input input = new Input();
    private int countErr;
    private final List<String> prize = List.of(
            "1, 2, 3, 4, 5, 47", "가나다", "abc", "123abc", "1, 2, 3, 4, 5"
    );
    private final List<String> budget = List.of("999","abc","가","10990","1~947");
    private final List<String> bonus = List.of("0", "47", "abc", "가", "@@!");

    private Method invokeMethod(String declaredMethod) throws NoSuchMethodException {
        Method method = input.getClass().getDeclaredMethod(declaredMethod, String.class);
        method.setAccessible(true);

        return method;
    }

    private void getCountErr(Method method, List<String> whichCase) {
        for(String inputCase : whichCase) {
            System.out.println("input: "+inputCase);
            try {
                method.invoke(input, inputCase);
            } catch (InvocationTargetException e) {
                if(e.getTargetException().getMessage().contains(ERROR_MSG)) {
                    countErr++;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @BeforeEach
    void setCountErr() {
        countErr = 0;
    }

    @Test
    @DisplayName("로또 당첨번호 입력 유효성 검사")
    void validateInputPrizeNum() throws Exception {
        Method method = invokeMethod("validateInputPrize");

        getCountErr(method, prize);

        System.out.println("countErr: "+countErr);
        assertEquals(countErr, prize.size());
    }

    @Test
    @DisplayName("로또 구입 금액 입력 유효성 검사")
    void validateInputBudget() throws Exception {
        Method method = invokeMethod("validateInputBudget");

        getCountErr(method, budget);

        System.out.println("countErr: "+countErr);
        assertEquals(countErr, budget.size());
    }

    @Test
    @DisplayName("보너스 번호 입력 유효성 검사")
    void validateInputBonus() throws Exception {
        Method method = invokeMethod("validateInputBonus");

        getCountErr(method, bonus);

        System.out.println("countErr: "+countErr);
        assertEquals(countErr, bonus.size());
    }

}
