package lotto.input;

public enum InputError {
    NOTHING("아무것도 입력되지 않았습니다."),
    WRONG_FORMAT("입력 형식에 맞게 입력되어야 합니다.");

    final String message;

    InputError(String message) {
        this.message = "[ERROR] " + message;
    }
    public void createError() {
        printMessage();
        throw new IllegalArgumentException();
    }
    private void printMessage() {
        System.out.print(this.message);
    }
}
