package lotto;

public enum WinningMessage {
    STATICS("당첨 통계\n" + "---"),
    THIRD_MATCH("3개 일치 (5,000원) - "),
    FORTH_MATCH("4개 일치 (50,000원) - "),
    FIFTH_MATCH("5개 일치 (1,500,000원) - "),
    BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIXTH_MATCH("6개 일치 (2,000,000,000원) - "),
    VOLUME("개");

    WinningMessage(String message){
        this.message = message;
    }
    private final String message;

    public String getMessage() {
        return message;
    }
}
