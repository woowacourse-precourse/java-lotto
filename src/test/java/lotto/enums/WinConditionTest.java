package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinConditionTest {

    @DisplayName("로또 번호와 일치하는 값을 확인하고 결과에 해당하는 index를 반환한다.")
    @Test
    void getIndex() {
        int index = WinCondition.getIndex(6, 0);
        assertThat(index).isEqualTo(4);
    }
    @DisplayName("로또 번호와 일치하는 값을 확인하고 조건에 없으면 -1을 반환한다.")
    @Test
    void getIndex2() {
        int index = WinCondition.getIndex(2, 0);
        assertThat(index).isEqualTo(-1);
    }
}
