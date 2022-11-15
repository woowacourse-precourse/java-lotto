package view;

public class ExceptionView {

    private final String errorMessage;

    public ExceptionView(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void show() {
        System.out.println(errorMessage);
    }
}
