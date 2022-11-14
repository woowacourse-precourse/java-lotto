package lotto.view;

public enum Message {
    SELLING_MSG("구입 금액을 입력해 주세요."),
    BUYING_MSG("개 구매했습니다.");

    private final String msg;
    Message(String msg){
        this.msg = msg;
    }
    public String toString(){
        return msg;
    }
}
