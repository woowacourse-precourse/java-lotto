package lotto;

import lotto.model.Compare;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareTest {


    @Test
    void 숫자_3개를_맞춰서_5등일_때_결과_배열_구하기_test() {
        Compare compare = new Compare();
        int[] result = compare.getResult(1000, List.of(List.of(1,2,3,4,5,6)), List.of(1,2,3,7,8,9), 10);
        assertThat(result).isEqualTo(new int[] {1, 0, 0, 0, 0});
    }

    @Test
    void 숫자_4개를_맞춰서_4등일_때_결과_배열_구하기_test() {
        Compare compare = new Compare();
        int[] result = compare.getResult(1000, List.of(List.of(1,2,3,4,5,6)), List.of(1,2,3,4,8,9), 10);
        assertThat(result).isEqualTo(new int[] {0, 1, 0, 0, 0});
    }

    @Test
    void 숫자_6개를_맞춰서_1등일_때_결과_배열_구하기_test() {
        Compare compare = new Compare();
        int[] result = compare.getResult(1000, List.of(List.of(1,2,3,4,5,6)), List.of(1,2,3,4,5,6), 10);
        assertThat(result).isEqualTo(new int[] {0, 0, 0, 0, 1});
    }
}
