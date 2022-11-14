package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {

    @DisplayName("숫자로 변경 가능한 문자와 ,로 구성된 문자열이 들어왔을때 리스트로 잘 반환되는지 테스트")
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
}