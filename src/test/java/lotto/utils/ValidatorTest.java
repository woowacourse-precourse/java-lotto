package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    Validator validator = new Validator();

    @DisplayName("숫자로 된 문자열을 int로 변환")
    @Test
    void convertToInt() {
        Assertions.assertThat(validator.convertToInt("30")).isEqualTo(30);
    }

    @DisplayName("예외 - 숫자로만 이루어져있지 않은 문자열을 int로 변환 시 오류 발생")
    @Test
    void convertInvalidValueToInt() {
        assertThatThrownBy(() -> validator.convertToInt("30, 1"))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("숫자 리스트로 된 문자열을 List<Integer>로 변환하기")
    @Test
    void convertToIntList() {
        Assertions.assertThat(validator.convertToIntList("1, 2, 3, 4")).isEqualTo(List.of(1, 2, 3, 4));
    }

    @DisplayName("예외 - 숫자 리스트로만 이루어져있지 않은 문자열을 List<Integer>로 변환 시 오류 발생")
    @Test
    void convertInvalidValueToIntList() {
        assertThatThrownBy(() -> validator.convertToIntList("1, 2, 삼, 4"))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("1000의 배수인지 확인하기")
    @Test
    void isThousandMultiplesTest() {
        Assertions.assertThat(validator.isThousandMultiples(3000)).isEqualTo(true);
        Assertions.assertThat(validator.isThousandMultiples(3023)).isEqualTo(false);
        Assertions.assertThat(validator.isThousandMultiples(0)).isEqualTo(false);
        Assertions.assertThat(validator.isThousandMultiples(-1)).isEqualTo(false);
    }
}