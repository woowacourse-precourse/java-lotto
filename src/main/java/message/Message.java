package message;

public enum Message {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    COUNT_LOTTO("개를 구매했습니다."),
    INPUT_LOTTO_NUMBER("당첨 번호를 입력해주세요"),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해주세요"),
    STATISTICS("당첨통계\n---");

    private String str;

    Message(String str) {
        this.str = str;
    }

    public String getStatus() {
        return str;
    }
}
