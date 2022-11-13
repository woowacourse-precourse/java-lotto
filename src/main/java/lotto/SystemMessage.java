package lotto;

public enum SystemMessage {
    INPUT_PURCHASE_MONEY("구매 금액을 입력해주세요.");

    private String message;

    SystemMessage(String message){
        this.message=message;
    }

    public String print(){
        return message;
    }
}
