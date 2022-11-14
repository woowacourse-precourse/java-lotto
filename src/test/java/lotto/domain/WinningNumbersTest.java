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
        String input = "1,2,3,4,5,45\n7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WinningNumbers winningNumbers = new WinningNumbers();
        List<Integer> numbers = winningNumbers.getNumbers();

        List<Integer> result = List.of(1,2,3,4,5,45);

        assertThat(numbers).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "0,1,2,3,4,5", "1,1,1,1,1,1"})
    void 당첨_번호_입력_예외_처리(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> new WinningNumbers()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_입력_확인(){
        String input = "1,2,3,4,5,6\n10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WinningNumbers winningNumbers = new WinningNumbers();
        int bonus = winningNumbers.getBonus();

        int result = 10;

        assertThat(bonus).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6\na","1,2,3,4,5,6\n48", "1,2,3,4,5,6\n1"})
    void 보너스_번호_예외_처리(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> new WinningNumbers()).isInstanceOf(IllegalArgumentException.class);
    }

}