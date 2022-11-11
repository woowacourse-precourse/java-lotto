package lotto;

public enum LottoError {
    OUT_OF_BOUND("로또 번호는 1부터 45사이의 숫자여야 합니다."),
    DUPLICATION("로또 번호는 중복되지 않아야 합니다."),
    WRONG_SIZE("로또 번호는 6개입니다.");

    final String message;

    LottoError(String message) {
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
