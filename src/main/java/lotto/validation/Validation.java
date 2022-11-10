package lotto.validation;

import lotto.view.ErrorView;

public abstract class Validation {

    public abstract void isValidate(String userInput);

    protected void createError(String errorMessage) {
        printErrorMessage(errorMessage);
        throwError(errorMessage);
    }

    private void printErrorMessage(String errorMessage) {
        ErrorView errorView = new ErrorView();
        errorView.setErrorMessage(errorMessage);
        errorView.show();
    }

    private void throwError(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

}
