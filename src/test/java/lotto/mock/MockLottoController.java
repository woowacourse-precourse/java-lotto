package lotto.mock;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class MockLottoController extends LottoController {

    public static final String MOCK_EXCEPTION_MESSAGE = "테스트 예외입니다.";

    public MockLottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        super(inputView, outputView, lottoService);
    }

    @Override
    public void runLotto() {
        throw new IllegalArgumentException(MOCK_EXCEPTION_MESSAGE);
    }
}
