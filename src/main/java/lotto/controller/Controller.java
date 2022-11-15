package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public abstract class Controller {
    public static final String FORMAT_ERROR_MESSAGE = "[ERROR] 잘못된 형식을 입력하였습니다.";
    protected final InputView inputView = InputView.getInstance();
    protected final OutputView outputView = OutputView.getInstance();
}
