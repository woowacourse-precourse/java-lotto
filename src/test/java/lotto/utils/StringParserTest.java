package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class StringParserTest {

    @DisplayName("숫자로 변경 가능한 문자와 ,로 구성된 문자열이 들어왔을때 리스트로 잘 반환되는지 테스트한다.")
    @Test
    void parseInputToIntegerListSuccess() {
        //given
        String input = "1,2,3,4,5,6";
        //when
        List<Integer> parsedInputs = StringParser.parseInputToIntegerList(input);
        //then
        Assertions.assertThat(parsedInputs.size())
                  .isEqualTo(6);
    }

    @DisplayName("숫자로 변경 불가능한 문자와 ,로 구성된 문자열이 들어왔을때 예외를 던지는지 테스트한다.")
    @Test
    void parseInputToIntegerListFail() {
        //given
        String input = "1,2,3,4,5,A";
        //when
        //then
        Assertions.assertThatThrownBy(() -> {
                      StringParser.parseInputToIntegerList(input);
                  })
                  .isInstanceOf(IllegalArgumentException.class);
    }
}