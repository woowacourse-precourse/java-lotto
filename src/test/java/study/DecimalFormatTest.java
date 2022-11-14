package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.DecimalFormat;

import static org.assertj.core.api.Assertions.*;

public class DecimalFormatTest {

    @DisplayName("DecimalFormat은 정수를 Format형식의 String으로 반환해주는 기능을 가지고 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1,000", "10000000:10,000,000", "12345:12,345"}, delimiterString = ":")
    void DecimalFormat_사용법_테스트(int intArg, String expected) {
        DecimalFormat decFormat = new DecimalFormat("###,###");
        assertThat(decFormat.format(intArg)).isEqualTo(expected);
    }

    @DisplayName("DecimalFormat에 %를 붙힌다면 퍼센트 수치를 보여준다 1을 입력한 것은 100% 의미한다.")
    @ParameterizedTest
    @CsvSource(value = {"10:1,000%", "100000:10,000,000%", "12345:1,234,500%"}, delimiterString = ":")
    void DecimalFormat_형식문자를_포함한_사용법_테스트(int intArg, String expected) {
        DecimalFormat decFormat = new DecimalFormat("###,###%");
        assertThat(decFormat.format(intArg)).isEqualTo(expected);
    }

}
