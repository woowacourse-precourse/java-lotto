package lotto.validation;

import lotto.view.ErrorView;

public abstract class Validation {

    public abstract void isValidate(String userInput);

    public void createError(String errorMessage) {
        printErrorMessage(errorMessage);
        throwError(errorMessage);
    }

    public void printErrorMessage(String errorMessage) {
        ErrorView errorView = new ErrorView();
        errorView.setErrorMessage(errorMessage);
        errorView.show();
    }

    public void throwError(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

}
