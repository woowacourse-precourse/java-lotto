package lotto.domain;

public enum Error {
    //★ 변수명, 메소드명 컨벤션 확인하기 (ERROR_NUMBER?)
    IS_NOT_NUMBER("[ERROR] 숫자가 아닙니다."),
    IS_NOT_DIVIDED("[ERROR] 구입 금액이 1000원 단위가 아닙니다."),
    IS_NOT_SIX_TOKEN("[ERROR] ,를 기준으로 6개의 토큰이 아닙니다."),
    IS_NOT_RANGE("[ERROR] 당첨번호의 범위를 벗어났습니다."),
    IS_NOT_UNIQUE("[ERROR] 유일한 숫자가 아닙니다.");

    private String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
