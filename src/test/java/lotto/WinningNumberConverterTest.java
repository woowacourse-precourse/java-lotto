package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.WinningNumberConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class WinningNumberConverterTest {
    @DisplayName("','를 기준으로 분리해 불변 String 리스트로 변환한다.")
    @Test
    void convertToImmutableStringListTest() {
        List<String> converted =
                WinningNumberConverter.convertToImmutableStringList("1,2,3");

        assertThat(converted).containsExactly("1", "2", "3");
        assertThatThrownBy(() -> converted.add("4"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("','를 기준으로 분리해 불변 Integer 리스트로 변환한다.")
    @Test
    void convertToImmutableIntegerListTest() {
        List<Integer> converted =
                WinningNumberConverter.convertToImmutableIntegerList("1,2,3");

        assertThat(converted).containsExactly(1, 2, 3);
        assertThatThrownBy(() -> converted.add(4))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("String 리스트를 불변 Integer 리스트로 변환한다.")
    @Test
    void convertStringListToImmutableIntegerListTest() {
        List<Integer> converted =
                WinningNumberConverter.convertToImmutableIntegerList(List.of("1", "2", "3"));

        assertThat(converted).containsExactly(1, 2, 3);
        assertThatThrownBy(() -> converted.add(4))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}