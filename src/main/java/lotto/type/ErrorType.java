package lotto.type;

/**
 * 출력 문구 상수를 모아둔 Enum 클래스
 */
public enum ErrorType {
    NOT_NUMBER_INPUT("[ERROR] 숫자가 아닌 다른 값을 입력하였습니다."),
    INVALID_UNIT("[ERROR] 유효하지 않은 금액 단위입니다."),
    DUPLICATE_NUMBER("[ERROR] 중복된 숫자로 로또를 생성할 수 없습니다."),
    OVER_SIZE("[ERROR] 로또 번호는 6개로 구성되어야 합니다."),
    OVER_SIZE_WIN_NUMBER("[ERROR] 당첨 번호는 6개를 입력해야 합니다."),
    OVER_WIN_NUMBER("[ERROR] 당첨번호의 범위를 초과했습니다."),
    OVER_BONUS_NUMBER("[ERROR] 보너스번호의 범위를 초과했습니다."),
    DUPLICATE_WHIT_WIN_NUMBERS("[ERROR] 보너스번호는 당첨번호와 겹치치 않는 번호여야 합니다.");

    private final String error;

    ErrorType(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
