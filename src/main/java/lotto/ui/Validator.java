package lotto;

public class Validator {
    private void throwExceptionWithErrorMessage(String errorMessage) {
        throw new IllegalArgumentException("[ERROR] " + errorMessage);
    }

    public void throwIfEmtpy(String input) {
        if (input.isEmpty()) {
            throwExceptionWithErrorMessage("입력값이 비어있습니다.");
        }
    }

}
