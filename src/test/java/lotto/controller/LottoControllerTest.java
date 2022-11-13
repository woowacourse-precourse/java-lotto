package lotto.controller;

import lotto.model.LottoDrawingMachine;
import lotto.model.LottoIssuingMachine;
import lotto.model.LottoWinningStatistics;
import lotto.view.LottoView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @Test
    void purchaseLottosExceptionTest() {
        final byte[] buf = String.join("\n", "1004a").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> lottoController.purchaseLottos())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_INPUT_ONLY_NUMBER);
    }

    @DisplayName("당첨 번호로 숫자와 쉼표(,) 외의 문자 입력 시 예외가 발생한다.")
    @Test
    void drawLottoExceptionTestByWinningNumbers() {
        final byte[] buf = String.join("\n", "1,2,3,4,5.6", "7").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> lottoController.drawLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_INPUT_ONLY_NUMBER_COMMA);
    }

    @DisplayName("보너스 번호로 숫자 아닌 문자 입력 시 예외가 발생한다.")
    @Test
    void drawLottoExceptionTestByBonusNumber() {
        final byte[] buf = String.join("\n", "1,2,3,4,5", "7a").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> lottoController.drawLotto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_INPUT_ONLY_NUMBER);
    }
}
