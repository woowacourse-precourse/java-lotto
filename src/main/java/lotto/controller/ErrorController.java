package lotto.controller;

import lotto.view.ErrorView;
import lotto.view.View;

public class ErrorController {
    public View createErrorView(String message) {
        return new ErrorView(message);
    }
}
