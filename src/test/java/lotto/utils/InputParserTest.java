package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {
    @DisplayName("문자열이 주어졌을 때 정수형이 아닌경우 오류를 반환")
    @Test
    void givenCannotParseToInt_whenParseToInteger_thenThrowError() {
        //given
        String input = "h93";

        //when
        Throwable thrown = catchThrowable(() -> InputParser.parseToInteger(input));

        //then
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열이 주어졌을 때 정수형 변환이 가능하면 변환값을 반환")
    @Test
    void givenCanParseToInt_whenParseToInteger_thenReturnInteger() {
        //given
        String input = "34";
        int result = 34;

        //when
        int parsedNum = InputParser.parseToInteger(input);

        //then
        assertThat(parsedNum).isEqualTo(result);
    }

    @DisplayName("처음과 끝이 공백이 있는 숫자로된 문자열이 주어졌을 때 정수형 변환값을 반환")
    @Test
    void givenStringHasWhiteSpace_whenParseToInteger_thenThrowError() {
        //given
        String input = " 34   ";
        int result = 34;

        //when
        int parsedNum = InputParser.parseToInteger(input);

        //then
        assertThat(parsedNum).isEqualTo(result);
    }


}