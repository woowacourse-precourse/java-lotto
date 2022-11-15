package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.utils.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest extends NsTest {
    @DisplayName("입력받은 당첨번호는 숫자여야한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1,2,3,4,5,a", "1000:a,b,c,d"}, delimiter = ':')
    void checkWinningNumberIsNumeric(String firstInput, String secondInput) {
        assertSimpleTest(() -> {
            runException(firstInput, secondInput);
            assertThat(output()).contains(Validation.LOTTO_INPUT_MUST_NUMBER);
        });
    }

    @DisplayName("입력받은 당첨번호는 List<Integer>로 변환되서 받아져야한다.")
    @Test
    void checkWinningNumberIsConvert() {
        String answer = "1,2,3,4,5,6";
        Lotto winningNumber = new Lotto(answer);

        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);

        assertThat(winningNumber.getNumbers()).isEqualTo(result);
    }

    @DisplayName("입력받은 당첨번호는 개수가 총 6개여야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1,2,3,4,5,6,7", "1000:1,2,3,4"}, delimiter = ':')
    void checkWinningNumberSize(String firstInput, String secondInput) {
        assertSimpleTest(() -> {
            runException(firstInput, secondInput);
            assertThat(output()).contains(Validation.LOTTO_NUMBER_IS_SIX);
        });
    }

    @DisplayName("입력받은 당첨번호는 중복이 없어야한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1,2,3,3,2,1", "1000:1,2,3,4,5,5"}, delimiter = ':')
    void checkWinningNumberDuplicated(String firstInput, String secondInput) {
        assertSimpleTest(() -> {
            runException(firstInput, secondInput);
            assertThat(output()).contains(Validation.LOTTO_NUMBER_IS_DISTINCT);
        });
    }

    @DisplayName("입력받은 당첨번호는 정렬이 되어있어야 한다.")
    @Test
    void checkWinningNumberSorted() {
        String answer = "6,5,4,3,2,1";
        Lotto winningNumber = new Lotto(answer);

        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);

        assertThat(winningNumber.getNumbers()).isEqualTo(result);
    }

    @DisplayName("입력받은 당첨번호는 1~45의 범위안에 들어가야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1,2,0,4,5,6", "1000:46,1,2,3,4,5"}, delimiter = ':')
    void checkWinningNumberInRange(String firstInput, String secondInput) {
        assertSimpleTest(() -> {
            runException(firstInput, secondInput);
            assertThat(output()).contains(Validation.LOTTO_NUMBER_IN_RANGE);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
