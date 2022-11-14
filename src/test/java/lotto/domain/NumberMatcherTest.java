package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberMatcherTest {
    @DisplayName("두 리스트를 받아 일치하는 숫자의 개수를 반환한다.")
    @Test
    void matchElements() {
        NumberMatcher matcher = new NumberMatcher();
        List<Integer> buyer = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumber = List.of(8, 7, 6, 5, 4, 3);
        assertThat(matcher.winningNumberCount(buyer, winningNumber)).isEqualTo(4);
    }
}
