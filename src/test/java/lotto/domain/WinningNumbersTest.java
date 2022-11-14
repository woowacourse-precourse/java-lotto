package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class WinningNumbersTest {

    @Test
    void 당첨_번호_입력_확인(){
        String input = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WinningNumbers winningNumbers = new WinningNumbers();
        List<Integer> numbers = winningNumbers.getNumbers();

        List<Integer> result = List.of(1,2,3,4,5,6);

        assertThat(numbers).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "0,1,2,3,4,5", "1,1,1,1,1,1"})
    void 당첨_번호_입력_예외_처리(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> new WinningNumbers()).isInstanceOf(IllegalArgumentException.class);
    }

}