package lotto;

import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    private LottoService lottoService = new LottoService();
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

    @DisplayName("입력받은 보너스 번호가 유효하지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6","1,2,3,4,5,6:ㄱ","1,2,3,4,5,6:46"} , delimiter = ':')
    void createBonusNumber(String winningNumber , String input) {
        lottoService.createWinningLotto(winningNumber);
        assertThatThrownBy(() -> InputValidator.checkBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
