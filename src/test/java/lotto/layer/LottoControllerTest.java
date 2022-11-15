package lotto.layer;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

class LottoControllerTest {

    private final LottoService lottoService = mock(LottoService.class);
    private final InputView inputView = mock(InputView.class);
    private final OutputView outputView = mock(OutputView.class);
    private final LottoController lottoController = new LottoController(lottoService, inputView, outputView);

    @DisplayName("잘못된 숫자 금액을 입력한 경우 예외를 발생한다")
    @Test
    void generateLottoByIllegalNumberFormat() {
        // given
        Mockito.when(inputView.requestMoney()).thenReturn("a100");

        // expect
        assertThatThrownBy(lottoController::generateLotto).isInstanceOf(IllegalArgumentException.class);
    }

}