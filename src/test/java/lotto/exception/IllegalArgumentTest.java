package lotto.exception;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class IllegalArgumentTest {

    @Test
    void 숫자가_아닌_입력값() {
        assertThat(IllegalArgument.isNumber("숫자아님")).isFalse();
    }

    @Test
    void 숫자인_입력값() {
        assertThat(IllegalArgument.isNumber("13000")).isTrue();
    }

    @Test
    void 천원_단위_숫자_입력() {
        assertThat(IllegalArgument.isThousandWon("13000")).isTrue();
    }

    @Test
    void 천원_단위_아닌_숫자_입력() {
        assertThat(IllegalArgument.isThousandWon("1234")).isFalse();
    }

    @Test
    void 범위_밖_숫자_포함() {
        assertThat(IllegalArgument.isInRange(Arrays.asList(1, 3, 46, 4, 7, 9))).isFalse();
    }

    @Test
    void 중복_포함_리스트() {
        assertThat(IllegalArgument.isRedundancy(Arrays.asList(1, 3, 3, 4, 5, 6))).isTrue();
    }

    @Test
    void 중복_없는_리스트() {
        assertThat(IllegalArgument.isRedundancy(Arrays.asList(1, 2, 3, 4, 5, 6))).isFalse();
    }
}
