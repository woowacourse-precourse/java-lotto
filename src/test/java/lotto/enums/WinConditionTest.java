package lotto.enums;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinConditionTest {

    @Test
    void getIndex() {
        int index = WinCondition.getIndex(6, 0);
        assertThat(index).isEqualTo(4);
    }
    @Test
    void getIndex2() {
        int index = WinCondition.getIndex(2, 0);
        assertThat(index).isEqualTo(-1);
    }
}
