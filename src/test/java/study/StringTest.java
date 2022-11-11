package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {
    @Test
    @DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void split() {
        final List<String> strings = Arrays.asList("1,2".split(","));
        assertThat(strings).isEqualTo(List.of("1", "2"));
    }
}
