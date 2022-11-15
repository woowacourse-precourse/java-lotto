package lotto.exception;

public enum LottoMachineExceptionMessage {
    MACHINE_NOT_ENOUGH_CASH("[ERROR] 부족한 금액으로 인한 오류가 발생하였습니다.");

    private final String message;

    LottoMachineExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
