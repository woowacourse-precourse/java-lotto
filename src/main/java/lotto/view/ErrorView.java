package lotto.view;

public class ErrorView implements View {

    private String message;

    public ErrorView(String message) {
        this.message = message;
    }

    @Override
    public void print() {
        System.out.printf("[ERROR] " + message);
    }
}
