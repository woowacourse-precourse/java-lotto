package lotto;

import lotto.domain.Lotto;
import lotto.repository.LottoRepository;
import lotto.service.LottoService;
import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {
    private LottoService lottoService = LottoService.getInstance();

    @DisplayName("입력받은 금액이 유효하지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"01000","100","r10","-100","1240","0"," "})
    void checkValidMoney(String input) {
        assertThatThrownBy(() -> InputValidator.checkUserInputMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 당첨 번호가 유효하지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5","1 2 3 4 5 6","99,1,2,3,4,5","ㅁ,1,3,4,5,6","-1,9,8,7,6,5"})
    void checkValidWinningNumber(String input) {
        assertThatThrownBy(() -> InputValidator.checkWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 보너스 번호가 유효하지 않으면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"6","ㄱ","46","-1"})
    void createBonusNumber(String input) {
        assertThatThrownBy(() -> InputValidator.checkBonusNumber(input,new Lotto(List.of(1,2,3,4,5,6))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
