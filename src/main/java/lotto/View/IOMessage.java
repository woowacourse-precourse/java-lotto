package lotto.View;

public enum IOMessage {
    GET_LOTTO_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_TICKET_NUMBER_MESSAGE("개를 구매했습니다."),
    GET_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_MESSAGE("당첨 통계\n---");

    private final String message;
    IOMessage(String message){
        this.message = message;
    }
    public String toString(){
        return message;
    }
}
