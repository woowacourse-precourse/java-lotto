package lotto.utils;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringParserTest {

    @DisplayName("숫자로 변경 가능한 문자와 ,로 구성된 문자열이 들어왔을때 리스트로 잘 반환되는지 테스트한다.")
    @Test
    void parseInputToIntegerListSuccess() {
        //given
        String input = "1,2,3,4,5,6";
        //when
        List<Integer> parsedInputs = StringParser.parseInputToIntegerList(input);
        //then
        assertThat(parsedInputs.size())
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

    @DisplayName("사용자가 구매한 로또를 [ , ] 를 포함한 문자열로 잘 반환하는지 테스트")
    @Test
    void parseLottoToString() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        //when
        String parsedLotto = StringParser.parseLottoToString(lotto);
        //then
        assertThat(parsedLotto).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}