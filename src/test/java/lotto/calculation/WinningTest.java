package lotto.calculation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningTest {

    @Test
    void 당첨_번호가_여섯개가_아닌_경우() {
        assertThatThrownBy(() -> new Winning(List.of("1", "2", "3", "4", "5", "6", "7")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_내_중복된_숫자() {
        assertThatThrownBy(() -> new Winning(List.of("1", "2", "3", "4", "5", "5")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_45_이상() {
        assertThatThrownBy(() -> new Winning(List.of("1", "2", "3", "4", "5", "55")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호와_중복되는_보너스_번호() {
        assertThatThrownBy(() -> new Winning(List.of("1", "2", "3", "4", "5", "6")).setBonusNumber(5))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
