package lotto.valid;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidTest {

    @Test
    void check_size() {
        String str = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> Valid.check_size(str))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void check_number() {
        String str = "1,2,3,4,a,6";
        assertThatThrownBy(() -> Valid.check_number(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_Overlap() {
        String str = "1,2,3,4,5,5";
        assertThatThrownBy(() -> Valid.check_Overlap(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_Range() {
        String str = "0,2,3,4,5,45";
        assertThatThrownBy(() -> Valid.check_Range(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_under_thousand() {
        String str = "1300";
        assertThatThrownBy(() -> Valid.check_under_thousand(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void check_empty() {
        String str = "1,2,3,4,,6";
        assertThatThrownBy(() -> Valid.check_empty(str))
                .isInstanceOf(IllegalArgumentException.class);
    }
}