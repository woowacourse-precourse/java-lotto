package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputConverterTest {

    @DisplayName("[정상] 구매금액이 숫자일 경우 숫자로 변환된다.")
    @Test
    void createInput_Can_Be_Converted_Integer() {
        Integer result = InputConverter.toInteger("123456");
        assertThat(result).isEqualTo(123456)
                .isInstanceOf(Integer.class);
    }

    @DisplayName("[예외] 구매금액이 숫자가 아닐경우 예외가 발생한다.")
    @Test
    void createInput_Can_Not_Be_Converted_Integer() {
        assertThatThrownBy(() -> InputConverter.toInteger("a1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 입력입니다.");
    }

    @DisplayName("[정상] 올바른 당첨 번호일 경우 숫자 리스트로 변환된다.")
    @Test
    void createInput_Can_Be_Converted_IntegerList() {
        List<Integer> result = InputConverter.toIntegerList("1,2,3,4,5,6");

        assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(result.size()).isEqualTo(6);
    }

    @DisplayName("[예외] 문자가 존재할 경우 IntegerList 변환 과정 예외가 발생한다.")
    @Test
    void createInput_Can_Not_Be_Converted_IntegerList() {
        assertThatThrownBy(() -> InputConverter.toInteger("a,1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 입력입니다.");
    }

    @DisplayName("[예외] 올바른 형식이 아닐경우(숫자,숫자...) IntegerList 변환 과정 예외가 발생한다.")
    @Test
    void createInput_Can_Not_Be_Converted_IntegerList_2() {
        assertThatThrownBy(() -> InputConverter.toInteger("a1, 2, 3, 4"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 입력입니다.");
    }

}
