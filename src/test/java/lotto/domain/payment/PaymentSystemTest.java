package lotto.domain.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class PaymentSystemTest {

    private PaymentSystem paymentSystem;

    @BeforeEach
    void setUp() {
        paymentSystem = new PaymentSystem();
    }

    @DisplayName("validateForm 메소드에 문자가 입력되었을 때 오류를 발생시키는지 확인")
    @ParameterizedTest()
    @ValueSource(strings = {"1000", "1", "12345", "a", ".", "1a"})
    void validateForm_error_test(String number) throws NoSuchMethodException, IllegalAccessException {
        Method method = paymentSystem.getClass().getDeclaredMethod("validateForm", String.class);
        method.setAccessible(true);

        try {
            method.invoke(paymentSystem, number);

        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException()).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 금액은 숫자로 입력해야 합니다.");
        }
    }

    @DisplayName("validateAmount 메소드에 1000미만의 숫자가 입력되었을 때 오류를 발생시키는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 1, 123, 20})
    void validateAmount_test_with_under_1000(int number) throws NoSuchMethodException, IllegalAccessException {
        Method method = paymentSystem.getClass().getDeclaredMethod("validateAmount", int.class);
        method.setAccessible(true);

        try {
            method.invoke(paymentSystem, number);

        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException()).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 금액은 1000원 이상이어야 합니다.");
        }
    }

    @DisplayName("validateAmount 메소드에 1000의 배수가 아닌 수가 입력되었을 때 오류를 발생시키는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 1001, 1543, 2522})
    void validateAmount_test_with_non_multiple_of_1000(int number) throws NoSuchMethodException, IllegalAccessException {
        Method method = paymentSystem.getClass().getDeclaredMethod("validateAmount", int.class);
        method.setAccessible(true);

        try {
            method.invoke(paymentSystem, number);

        } catch (InvocationTargetException e) {
            assertThat(e.getTargetException()).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }
}