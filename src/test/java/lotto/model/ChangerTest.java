package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChangerTest {

    @DisplayName("숫자를 1000단위로 나누서 수량 계산하기")
    @Test
    void count_quantity() {
        assertThat(Changer.moneyToQuantityChanger(10000)).isEqualTo(10);
        assertThat(Changer.moneyToQuantityChanger(20000)).isEqualTo(20);
    }

    @DisplayName("문자를 숫자리스트로 전환")
    @Test
    void change_string_to_Integers() {
        assertThat(Changer.stringToIntegers("1,2,3,4,5,6")).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
