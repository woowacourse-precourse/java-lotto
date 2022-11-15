package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidationTest {

    @DisplayName("금액 입력 시 예외가 발생하는 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"abc:[ERROR] 문자가 아닌 숫자를 입력해주세요.", "14500:[ERROR] 금액을 1000원 단위로 입력해주세요."},
            delimiter = ':')
    void createException(String input, String exceptionMessage) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateMoney(input);
        });
        assertThat(exception.getMessage()).contains(exceptionMessage);
    }

    @DisplayName("로또 번호 입력 시 예외가 발생하는 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,a,b,c,d:[ERROR] 문자가 아닌 숫자를 입력해주세요.",
            "1 2 3 4 5 6:[ERROR] 문자가 아닌 숫자를 입력해주세요.",
            "123456:[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.",
            "0,1,2,3,45,50:[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.",
            "1,2,3,4:[ERROR] 로또 번호 6개를 입력해주세요.",
            "1,1,2,2,3,4:[ERROR] 로또 번호 6개는 서로 다른 숫자여야 합니다."},
            delimiter = ':')
    void createLottoNumbersException(String input, String exceptionMessage) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateLottoNumbers(input);
        });
        assertThat(exception.getMessage()).contains(exceptionMessage);
    }

    @DisplayName("보너스 번호 입력 시 예외가 발생하는 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = {"46:[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", "a:[ERROR] 문자가 아닌 숫자를 입력해주세요."},
            delimiter = ':')
    void createBonusNumberException(String input, String exceptionMessage) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateBonusNumbers(input);
        });
        assertThat(exception.getMessage()).contains(exceptionMessage);
    }

    @DisplayName("보너스 번호를 로또 번호와 중복하여 입력하는 경우 예외 테스트")
    @Test
    void createDuplicationException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Validation.checkDuplicateLottoNumbersAndBonusNumber(List.of(1,2,3,4,5,6), 1);
        });
        assertThat(exception.getMessage()).contains("[ERROR] 보너스 번호는 로또 번호와 다른 숫자여야 합니다.");
    }
}