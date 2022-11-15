package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserMissCheckingTest {



    @Test
    public void 숫자대신_문자입력_에러(){
        assertThatThrownBy(() -> UserMissChecking.numberChecking("사십사"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserMissChecking.numberChecking("test"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserMissChecking.numberChecking(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또금액_첫원단위_미입금(){
        assertThatThrownBy(()->UserMissChecking.thousandChecking(4200))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->UserMissChecking.thousandChecking(12305))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->UserMissChecking.thousandChecking(123130))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 지정된_로또_숫자범위_이외_숫자_삽입(){
        assertThatThrownBy(()->UserMissChecking.numberLimitChecking(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->UserMissChecking.numberLimitChecking(47))
                .isInstanceOf(IllegalArgumentException.class);
    }
}