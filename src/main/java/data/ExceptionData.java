package data;

public enum ExceptionData {
    EXCEPTION_HEAD("[ERROR] "),
    NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_INTEGER("숫자만 입력해야 합니다."),
    NOT_DIVIDED("1000의 배수로만 입력해야 합니다."),
    NOT_SIX_NUMBER("6개의 숫자만 입력해야 합니다.");

    private final String errorMessage;

    ExceptionData(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void callErrorMessage() {
        System.out.print(EXCEPTION_HEAD.errorMessage);
        System.out.println(errorMessage);
    }
}
