package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberParserTest {

    @DisplayName("1,2,3,4,5,6 형태의 문자열 값을 받아 List<Integer>로 반환한다.")
    @Test
    void formattedNumberToIntegerList() {
        List<Integer> numbers = NumberParser.numbers("1,2,3,4,5,6");
        assertThat(numbers).hasSize(6);
    }
}