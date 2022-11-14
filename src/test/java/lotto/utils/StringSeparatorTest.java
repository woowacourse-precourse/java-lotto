package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSeparatorTest {
    @DisplayName("쉼표로 구분되어 있는 문자열을 리스트로 변환한다.")
    @Test
    void separateStringTest() {
        List<Integer> winningNumbers = new StringSeparator().separateStringToList("1,2,3,4,5,6");
        assertThat(winningNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
