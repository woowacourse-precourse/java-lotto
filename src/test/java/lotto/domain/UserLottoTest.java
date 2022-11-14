package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserLottoTest {

    @DisplayName("예외 처리 : 구매금액이 유효한지 검증")
    @ParameterizedTest
    @ValueSource(ints = {0,1050,100})
    void isDigitInputValidation(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new UserLotto(input));
    }

}
