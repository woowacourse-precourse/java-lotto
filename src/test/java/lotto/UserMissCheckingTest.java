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
    }

    @Test
    public void 로또금액_첫원단위_미입금(){
        assertThatThrownBy(()->UserMissChecking.thousandChecking(4200))
                .isInstanceOf(IllegalArgumentException.class);
    }
}