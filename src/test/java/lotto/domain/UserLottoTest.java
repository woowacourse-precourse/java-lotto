package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.constant.ErrorConstant.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserLottoTest {

    @DisplayName("예외 처리 : 구매금액이 유효한지 검증")
    @ParameterizedTest
    @ValueSource(ints = {0,1050,100})
    void isDigitInputValidation(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new UserLotto(input));
    }

    @DisplayName("예외 처리 : 로또 번호의 개수가 6개인지 검증")
    @Test
    void isValidSizeOfLotto() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .withMessageStartingWith(ERROR_NOT_VALID_COUNT);
    }

    @DisplayName("예외 처리 : 로또 번호가 중복인지 검증")
    @Test
    void checkDuplicateLotto() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .withMessageStartingWith(ERROR_DUPLICATE_NUMBER);
    }

    @DisplayName("예외 처리 : 로또 번호가 범위 안인지 검증")
    @Test
    void checkRangeOfLotto() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 47)))
                .withMessageStartingWith(ERROR_OUT_OF_RANGE);
    }

    @DisplayName("예외 처리 : 유저 로또 번호가 오름차순 정렬이 되었는지 검증")
    @Test
    void isLottoSorted() {
        List<Integer> lottoTest = UserLotto.sortLotto(List.of(7, 13, 12, 1, 5, 2));
        assertThat(List.of(1,2,5,7,12,13)).isEqualTo(lottoTest);

    }

}
