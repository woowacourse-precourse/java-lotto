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
        assertThat("1,2".split(",")).containsExactly("1", "2");
    }
    
    @Test
    @DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void one_split() {
        assertThat("1".split(",")).containsExactly("1");
    }
    
    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 \"1,2\"를 반환")
    void substring() {
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }
}
