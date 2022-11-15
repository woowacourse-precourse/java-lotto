package lotto.domain.winningElements;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class WinningElementsTest {
    @CsvSource(value = {
            "1,2,3,4,5,6 : 1 : 2 : 3 : 4 : 5 : 6",
            "11,13,15,17,25,37 : 11 : 13 : 15 : 17 : 25 : 37",
            "34,42,45,7,9,18 : 34 : 42 : 45 : 7 : 9 : 18",
            "3,29,32,17,5,41 : 3 : 29 : 32 : 17 : 5 : 41",
            "13,42,40,30,25,8 : 13 : 42 : 40 : 30 : 25 : 8",
            "1,8,24,37,35,5 : 1 : 8 : 24 : 37 : 35 : 5"
    }, delimiter = ':')
    @ParameterizedTest
    void 당첨_번호를_입력받고_유효성_검사_후_리스트_형태로_반환한다(String input, int one, int two, int three, int four, int five, int six) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        List<Integer> expected = new ArrayList<>(
                Arrays.asList(one, two, three, four, five, six));

        List<Integer> result = WinningElements.getWinningNumbers();

        assertThat(result).isEqualTo(expected);
    }

    @CsvSource(value = {
            "1,2,2,4,5,6",
            "11,13,15,46,25,37",
            "34,42,45,7,9,0",
            "3,29,32,17,999,41",
            "13,42,40,-111,25,8",
            "1,8,24,a,35,5",
            "1812131111",
            "1,,3,4,5,6",
            ",1,2,3,4,5,",
            "1,2,3,4,5,6,7"
    }, delimiter = ':')
    @ParameterizedTest
    void 당첨_번호를_입력받고_유효성_검사했을_때_이상이_있을_경우_예외처리한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(WinningElements::getWinningNumbers).isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource(value = {
            "1,2,3,4,5,6 : 1 : 2 : 3 : 4 : 5 : 6",
            "11,13,15,17,25,37 : 11 : 13 : 15 : 17 : 25 : 37",
            "34,42,45,7,9,18 : 34 : 42 : 45 : 7 : 9 : 18",
            "3,29,32,17,5,41 : 3 : 29 : 32 : 17 : 5 : 41",
            "13,42,40,30,25,8 : 13 : 42 : 40 : 30 : 25 : 8",
            "1,8,24,37,35,5 : 1 : 8 : 24 : 37 : 35 : 5"
    }, delimiter = ':')
    @ParameterizedTest
    void 입력받은_당첨_번호를_콤마로_구분하여_나눈다(String input, int one, int two, int three, int four, int five, int six) {
        List<Integer> expected = new ArrayList<>(
                Arrays.asList(one, two, three, four, five, six));

        List<Integer> result = WinningElements.parseReceivedWinningNumbers(input);

        assertThat(result).isEqualTo(expected);
    }
}