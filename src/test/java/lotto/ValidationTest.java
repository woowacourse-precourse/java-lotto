package lotto;

import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("입력받은 금액이 유효하지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"01000","100","r10","-100","1240"})
    void checkValidMoney(String input) {
        assertThatThrownBy(() -> LottoService.getTheNumberOfLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
