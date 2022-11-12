package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareTest {

    @Test
    void 숫자_비교_테스트() {
        Compare compare = new Compare();
        int sameNumber = compare.compareNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(2, 3, 4, 9, 10, 13));

        assertThat(sameNumber).isEqualTo(3);
    }

    @Test
    void 숫자_일치_개수_출력() {
        Compare compare = new Compare();
        int sameNumber = compare.compareNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 31), Arrays.asList(1, 3, 5, 7, 9, 35));

        assertThat(sameNumber).isEqualTo(3);
    }
}
