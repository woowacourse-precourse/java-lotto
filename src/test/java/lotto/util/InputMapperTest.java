package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InputMapperTest {

    private InputMapper inputMapper = new InputMapper();

    @Test
    @DisplayName("split 메서드 기능 테스트_공백 제거 테스트")
    void split_with_blank() {
        List<Integer> list = inputMapper.splitByComma("1 , 2 ,   3  , 4, 5");
        assertThat(list).isEqualTo(List.of(1, 2, 3, 4, 5));
    }

    @Test
    @DisplayName("split 메서드 기능 테스트_정상입력")
    void split_without_blank() {
        List<Integer> list = inputMapper.splitByComma("1,2,3,4,5");
        assertThat(list).isEqualTo(List.of(1, 2, 3, 4, 5));
    }

    @Test
    @DisplayName("split 메서드 기능 테스트_에러")
    void split_regex_error() {
        assertThatThrownBy(() -> inputMapper.splitByComma("1,2  ,3.  4.5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}