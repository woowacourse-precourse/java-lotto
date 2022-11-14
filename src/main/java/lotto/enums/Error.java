package lotto.enums;

public enum Error {
    ER_MONETARYUNIT("[ERROR] 1,000원 단위의 숫자를 입력해 주세요."),
    ER_STRINGCHECK("[ERROR] 문자,공백 입력은 불가능 합니다. 1,000원 단위의 숫자를 입력해 주세요."),
    ER_STRINGCHECK_SIXNUMBERS("[ERROR] 문자 또는 공백은 입력이 불가능합니다. 1~45 사이의 6개의 숫자를 쉼표(,)로 구분해서 입력해 주세요."),
    ER_MONETARYUNIT_ONENUMBER("[ERROR] 문자 또는 공백은 입력이 불가능합니다. 1~45 사이의 숫자 1개를 입력해 주세요."),
    ER_NUMBER_RANGE("[ERROR] 로또 번호의 숫자 범위는 1~45까지 입니다."),
    ER_NUMBER_LENGTH("[ERROR] 로또 번호는 6개의 수로 이루어져 있습니다."),
    ER_BONUSNUMBERINLOTTONUMBER("[ERROR] 보너스 번호와 로또 번호는 중복이 안됩니다."),
    ER_DUPLICATION("[ERROR] 중복 없이 1~45까지 6개의 숫자를 쉼표(,)로 구분해서 입력해주세요.");

    private final String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}

