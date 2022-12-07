package lotto.enums;

public enum StringEnum {
    PRICE("구입금액을 입력해주세요."),
    CHECK_LOTTO("개를 구매했습니다."),
    WIN_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;
    private StringEnum(String message){
        this.message = message;
    }
    public String getMessage(){return this.message;}
}
