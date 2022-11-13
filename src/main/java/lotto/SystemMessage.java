package lotto;

public enum SystemMessage {
    INPUT_PURCHASE_MONEY("구매 금액을 입력해주세요."),
    OUTPUT_PURCHASE_LOTTO("개를 구매했습니다.");
    private String message;

    SystemMessage(String message){
        this.message=message;
    }

    public String print(){
        return message;
    }
}
