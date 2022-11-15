package lotto.service;

public enum ErrorPrint {
    ERROR_1_AND_45(" 1부터 45 사이의 숫자를 입력해주세요"),
    ERROR_BONUS_DUPLICATE(" 당첨 번호에 들어있는 숫자입니다 다른 숫자 입력해야합니다."),
    ERROR_ONLY_NUMBER(" 숫자만 입력하세요"),
    ERROR_1000(" 1000원 단위로 입력해야 합니다."),
    ERROR_MONEY_0(" 돈을 내세요"),
    ERROR_WIN_DUPLICATE(" 중복인 숫자가 있습니다."),
    ERROR_WIN_SIX(" 6개의 숫자를 입력하세여"),
    ERROR("[ERROR]"),
    REGEX("[0-9]+");

    private final String value;

    ErrorPrint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
