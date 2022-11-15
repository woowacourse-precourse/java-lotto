package lotto;

public enum ErrorCode {
    PRICE_INCORRECT_INPUT("[ERROR] 로또는 1,000원 단위로 구매할 수 있습니다."),
    LOTTERY_INADEQUATE_NUMBER_AMOUNT("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
    LOTTERY_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTERY_DUPLICATED_NUMBER("[ERROR] 로또 번호는 중복되지 않는 숫자들로만 이루어져야 합니다."),
    JACKPOT_OUT_OF_RANGE("[ERROR] 로또 번호는 ,로 구분된 6개의 숫자로만 입력하여 주십시오."),
    BONUS_DUPLICATED_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 숫자여야 합니다."),
    NUM_OUT_OF_RANGE("[ERROR] 숫자로만 입력하여 주십시오.");

    String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
