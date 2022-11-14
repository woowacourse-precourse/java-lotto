package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {
    @DisplayName("정상적으로 로또 갯수를 구한 경우 Lotto의 리스트 형 객체가 반환된다.")
    @Test
    void lottoTest() {
        assertThat(Purchase.lotto("10000"))
                .isInstanceOf(List.class);
    }

    @DisplayName("입력한 금액을 숫자로 변환할 수 없는 경우 오류가 발생한다.")
    @Test
    void invalidFormOfMoney() {
        assertThatThrownBy(() -> Purchase.lotto("100$"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 금액이 1000원 단위가 아닌 경우 오류가 발생한다.")
    @Test
    void invalidUnit() {
        assertThatThrownBy(() -> Purchase.lotto("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("8000원인 경우 로또의 갯수는 8개이다.")
    @Test
    void numberOfLotto() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Method method = getNumberOfLottoMethod();
        assertThat(method.invoke(Purchase.class , "8000")).isEqualTo(8);
    }

    private Method getNumberOfLottoMethod() throws NoSuchMethodException {
        Method method = Purchase.class.getDeclaredMethod("getNumberOfLotto", String.class);
        method.setAccessible(true);
        return method;
    }
}