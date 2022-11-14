package lotto.presentation.view.converter;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReaderConverterTest {

    @DisplayName("문자열로 이루어진 숫자를 Integer형으로 변환")
    @Test
    void convertInteger() {
        String number = "15000";

        int convertedNumber = ReaderConverter.convertInteger(number);

        assertThat(convertedNumber).isEqualTo(15000);
    }

    @DisplayName("',' 문자를 기준으로 이루어진 숫자 배열을 Integer 배열로 변환")
    @Test
    void convertIntegerList() {
        String numbers = "1,2,3,4,5,6";

        List<Integer> convertedNumbers = ReaderConverter.convertIntegerList(numbers);

        assertThat(convertedNumbers).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }
}