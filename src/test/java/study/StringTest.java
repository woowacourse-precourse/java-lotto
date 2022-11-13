package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    @DisplayName("split 했을 때 기준점을 통해 잘 분리되는지 테스트한다.")
    void 기준점을_통해_잘_분리되는지_테스트() {
        String target = "1,2";
        assertThat(target.split(",")).containsExactly("1", "2");
    }

    @Test
    @DisplayName("기준점이 없는 스트링을 split 했을 때 잘 분리되는지 테스트한다.")
    void 기준점이_없을때_분리되는지_테스트() {
        String target = "1";
        assertThat(target.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("substring을 통해 부분문자열을 잘 구할 수 있는지 테스트한다.")
    void substring으로_괄호를_잘_제거하는지_테스트() {
        String target = "(1,2)";
        assertThat(target.substring(target.indexOf("(") + 1, target.indexOf(")"))).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt을 통해 특정 문자열을 가져오고, 정상적인 값이 아니면 예외가 발생하는지 테스트한다.")
    void charAt으로_특정_범위를_벗어난_값을_가져오면_예외가_발생하는지_테스트() {
        String target = "abc";
        assertThatThrownBy(() -> target.charAt(target.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
