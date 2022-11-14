package lotto.view;

public enum Message {
    SELLING_MSG("구입 금액을 입력해 주세요."),
    BUYING_MSG("개를 구매했습니다."),
    CHOOSE_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    CHOOSE_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String msg;
    Message(String msg){
        this.msg = msg;
    }
    public String toString(){
        return msg;
    }
}
