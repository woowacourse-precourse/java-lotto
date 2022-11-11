package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    
    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오기")
    void charAt() {
        assertThat("abc".charAt(1)).isEqualTo('b');
    }
    
    @Test
    @DisplayName("charAt()의 인덱스 위치가 벗어날 시 예외 확인")
    void charAt_out_of_bound_exception() {
        assertThatThrownBy(() -> "abc".charAt(3))
                .isExactlyInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 3");
    }
}
