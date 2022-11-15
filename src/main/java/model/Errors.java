package model;

public enum Errors {
    NUMBER("숫자 혹은 형식에 맞게 입력해주세요."),
    MONEY("1,000원 단위로만 입력해주세요."),
    LOTTO_NUMBER_FORMAT("형식에 맞게 입력해주세요. 번호는 쉼표(,)를 기준으로 구분합니다."),
    DUPLICATE_BONUS_NUMBER("당첨번호와 중복되지 않는 보너스번호를 입력해주세요."),
    DUPLICATE_LOTTO_NUMBER("숫자가 중복되지 않게 입력해주세요."),
    NUMBER_RANGE("1부터 45까지의 숫자만 입력해주세요.");


    private String errorMsg;

    Errors(String errorMsg) {
        String errorPrefix = "[ERROR] ";
        this.errorMsg = errorPrefix + errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
