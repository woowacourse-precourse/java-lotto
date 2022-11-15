package lotto.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidationTest {
    private static final LottoValidation lottoValidation = new LottoValidation();

    @DisplayName("숫자 개수가 6개가 아니면 IllegalArgumentException 가 발생하는지 확인")
    @Test
    void numberCount() {
        List<Integer> exception = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        assertThatThrownBy(() -> lottoValidation.numberCountCheck(exception))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 있을 때 IllegalArgumentException 가 발생하는지 확인")
    @ParameterizedTest(name = "[{index}] : {0},{1},{2},{3},{4},{5} : IllegalArgumentException 발생")
    @CsvSource({"1,2,3,4,5,5", "1,1,2,3,4,5", "1,1,1,1,1,1", "45,45,45,45,45,45"})
    void duplicateNumber(int number1, int number2, int number3, int number4, int number5, int number6) {
        List<Integer> exception = new ArrayList<>(List.of(number1, number2, number3, number4, number5, number6));
        assertThatThrownBy(() -> lottoValidation.numberDuplicateCheck(exception))
                .isInstanceOf(IllegalArgumentException.class);
    }
}