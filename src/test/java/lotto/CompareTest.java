package lotto;

import lotto.model.Compare;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CompareTest {
    Compare compare;

    @BeforeEach
    void setUp() {
        compare = new Compare();
    }


    @Test
    void 숫자_3개_일치시_5등_결과_배열_구하기_test() {
        int[] result = compare.getResult(1000, List.of(List.of(1,2,3,4,5,6)), List.of(1,2,3,7,8,9), 10);
        assertThat(result).isEqualTo(new int[] {1, 0, 0, 0, 0});
    }

    @Test
    void 숫자_4개를_일치시_4등_결과_배열_구하기_test() {
        int[] result = compare.getResult(1000, List.of(List.of(1,2,3,4,5,6)), List.of(1,2,3,4,8,9), 10);
        assertThat(result).isEqualTo(new int[] {0, 1, 0, 0, 0});
    }

    @Test
    void 숫자_6개_일치시_1등_결과_배열_구하기_test() {
        int[] result = compare.getResult(1000, List.of(List.of(1,2,3,4,5,6)), List.of(1,2,3,4,5,6), 10);
        assertThat(result).isEqualTo(new int[] {0, 0, 0, 0, 1});
    }

    @Test
    void 입력받은_당첨번호에_중복이_있을_때_test() {
        Compare compare = new Compare();
        assertThatThrownBy(() -> compare.validateDuplication(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_당첨번호의_길이가_6이_넘을_떄_test() {
        assertThatThrownBy(() -> compare.validateLength(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_당첨번호에_범위가_아닌_숫자가_있을_떄_test() {
        assertThatThrownBy(() -> compare.validateRange(List.of(1, 2, 3, 4, 5, 100), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호와_당첨번호에_중복된_수가_있을_떄_test() {
        assertThatThrownBy(() -> compare.validateDuplicationInBonus(List.of(1, 2, 3, 4, 5, 7), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
