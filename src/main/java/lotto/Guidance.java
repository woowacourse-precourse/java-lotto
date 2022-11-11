package lotto;

public enum Guidance {
    INPUT_BUYING_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    final String guide;

    Guidance(String guide){
        this.guide = guide;
    }
}
