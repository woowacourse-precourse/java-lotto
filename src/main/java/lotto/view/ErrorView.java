package lotto.view;

public class ErrorView extends View{

    private String errorMessage;

    @Override
    public void show() {
        OutputView.printEndsWithEnter(this.errorMessage);
    }

    public void setErrorMessage(String message) {
        this.errorMessage = message;
    }

}
