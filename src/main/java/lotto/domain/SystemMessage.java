package lotto.domain;

public enum SystemMessage {
    INPUT_PURCHASE_MONEY("구매 금액을 입력해 주세요."),
    INPUT_WINNING_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_PURCHASE_LOTTO("개를 구매했습니다.");
    private String message;

    SystemMessage(String message){
        this.message=message;
    }

    public String print(){
        return message;
    }
}
