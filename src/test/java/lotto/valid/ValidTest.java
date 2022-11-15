package lotto.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidTest {

    @DisplayName("[ERROR] 로또 번호가 7자리가 들어왔을 때 오류 발생")
    @Test
    void check_size() {
        String str = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> Valid.check_size(str))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("[ERROR] 로또 번호가 정수가 아닐 때 오류 발생")
    @Test
    void check_number() {
        String str = "1,2,3,4,a,6";
        assertThatThrownBy(() -> Valid.check_number(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[ERROR] 로또 번호가 중복된 값이 들어 왔을 때")
    @Test
    void check_Overlap() {
        String str = "1,2,3,4,5,5";
        assertThatThrownBy(() -> Valid.check_Overlap(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[ERROR] 로또번호가 1 ~ 45 범위를 벗어났을 때")
    @Test
    void check_Range() {
        String str = "0,2,3,4,5,45";
        assertThatThrownBy(() -> Valid.check_Range(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[ERROR] 사용자에게 받은 금액이 1000원 미만의 단위가 존재할 때")
    @Test
    void check_under_thousand() {
        String str = "1300";
        assertThatThrownBy(() -> Valid.check_under_thousand(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("[ERROR] 공백 문자가 존재할 때")
    @Test
    void check_empty() {
        String str = "1,2,3,4,,6";
        assertThatThrownBy(() -> Valid.check_empty(str))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
