package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.constant.ErrorConstant.ERROR_DUPLICATE_NUMBER;
import static lotto.constant.ErrorConstant.ERROR_NOT_VALID_COUNT;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserLottoTest {

    @DisplayName("예외 처리 : 구매금액이 유효한지 검증")
    @ParameterizedTest
    @ValueSource(ints = {0,1050,100})
    void isDigitInputValidation(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new UserLotto(input));
    }

    @DisplayName("로또 번호의 개수가 6개인지 검증")
    @Test
    void isValidSizeOfLotto() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .withMessageStartingWith(ERROR_NOT_VALID_COUNT);
    }

    @DisplayName("로또 번호가 중복인지 검증")
    @Test
    void checkDuplicateLotto() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .withMessageStartingWith(ERROR_DUPLICATE_NUMBER);
    }

}
