package lotto.controller;

import lotto.model.LottoDrawingMachine;
import lotto.model.LottoIssuingMachine;
import lotto.model.LottoWinningStatistics;
import lotto.view.LottoView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static lotto.constant.LottoConstant.*;
import static org.assertj.core.api.Assertions.*;

class LottoControllerTest {

    private LottoController lottoController;

    @BeforeEach
    void setUp() {
        LottoIssuingMachine issuingMachine = new LottoIssuingMachine();
        LottoDrawingMachine drawingMachine = new LottoDrawingMachine();
        LottoWinningStatistics winningStatistics = new LottoWinningStatistics();
        LottoView lottoView = LottoView.getInstance();
        lottoController = new LottoController(issuingMachine, drawingMachine, winningStatistics, lottoView);
    }

    @DisplayName("로또 구매 금액으로 숫자 아닌 문자 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1004a", " ", "5,000"})
    void purchaseLottosExceptionTest(String purchaseMoney) {
        final byte[] buf = String.join("\n", purchaseMoney).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> lottoController.purchaseLottos())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_INPUT_ONLY_NUMBER);
    }

    @DisplayName("당첨 번호로 숫자와 쉼표(,) 외의 문자 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5.6", "1,2,3a,4,5"})
    void drawLottoExceptionTestByWinningNumbers(String winningNumbers) {
        final byte[] buf = String.join("\n", winningNumbers).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> lottoController.drawLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_INPUT_ONLY_NUMBER_COMMA);
    }

    @DisplayName("보너스 번호로 숫자 아닌 문자 입력 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"5a", " ", "i"})
    void drawLottoExceptionTestByBonusNumber(String bonusNumber) {
        final byte[] buf = String.join("\n", "1,2,3,4,5", bonusNumber).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> lottoController.drawLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_INPUT_ONLY_NUMBER);
    }
}
