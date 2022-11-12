package lotto;

import lotto.service.LottoService;
import lotto.util.InputValidator;
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
        assertThatThrownBy(() -> InputValidator.checkUserInputMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 당첨 번호가 유효하지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5","1 2 3 4 5 6","99,1,2,3,4,5","ㅁ,1,3,4,5,6"})
    void checkValidWinningNumber(String input) {
        assertThatThrownBy(() -> InputValidator.checkWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
